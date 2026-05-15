package br.com.planet.metas.service;

import br.com.planet.metas.dto.FiltroContratoDTO;
import br.com.planet.metas.integration.ContratoIntegration;
import br.com.planet.metas.integration.GridParamConstructor;
import br.com.planet.metas.model.Acrescimo;
import br.com.planet.metas.model.Contrato;
import br.com.planet.metas.model.Desconto;
import br.com.planet.metas.model.PlanoVenda;
import br.com.planet.metas.model.ProdutoContrato;
import br.com.planet.metas.model.ServicoAdicional;
import br.com.planet.metas.model.Vendedor;
import br.com.planet.metas.response.ContratoResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContratoService {

    private final ContratoIntegration integration;
    private final VendedorService vendedorService;
    private final PlanoVendaService planoVendaService;
    private final ProdutoContratoService produtoContratoService;
    private final AcrescimoService acrescimoService;
    private final DescontoService descontoService;
    private final ServicoAdicionalService servicoAdicionalService;

    public ContratoService(
            ContratoIntegration integration,
            VendedorService vendedorService,
            PlanoVendaService planoVendaService,
            ProdutoContratoService produtoContratoService,
            AcrescimoService acrescimoService,
            DescontoService descontoService,
            ServicoAdicionalService servicoAdicionalService
    ) {
        this.integration = integration;
        this.vendedorService = vendedorService;
        this.planoVendaService = planoVendaService;
        this.produtoContratoService = produtoContratoService;
        this.acrescimoService = acrescimoService;
        this.descontoService = descontoService;
        this.servicoAdicionalService = servicoAdicionalService;
    }

    public List<Contrato> listarAPI(FiltroContratoDTO filtro) {
        return this.parseResponse(integration.listar(montarGridParams(filtro)));
    }

    public Contrato buscarPorId(Long id) {
        if (id == null) {
            return null;
        }

        FiltroContratoDTO filtro = new FiltroContratoDTO();
        filtro.setId(id);

        return listarAPI(filtro).stream()
                .findFirst()
                .orElse(null);
    }

    public Contrato buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        return buscarPorId(Long.parseLong(id));
    }

    protected List<Contrato> parseResponse(ContratoResponse response) {
        try {
            List<Contrato> contratos = new ArrayList<>();

            if (response == null
                    || response.getTotal() == null
                    || response.getTotal().equals("0")
                    || response.getRegistros() == null) {
                return contratos;
            }

            List<Vendedor> vendedores = vendedorService.listarAPI();

            response.getRegistros().forEach(c -> {
                Contrato cc = new Contrato();

                if (c.getId() != null && !c.getId().isBlank()) {
                    cc.setId(Long.parseLong(c.getId()));
                }

                try {
                    if (c.getDataAtivacao() != null
                            && !c.getDataAtivacao().isBlank()
                            && !c.getDataAtivacao().equals("0000-00-00")) {
                        cc.setDataAtivacao(LocalDate.parse(c.getDataAtivacao()));
                    }
                } catch (DateTimeParseException e) {
                    cc.setDataAtivacao(null);
                }

                cc.setStatusAcesso(c.getStatusInternet());
                cc.setStatusContrato(c.getStatus());
                cc.setBairro(c.getBairro());

                try {
                    if (c.getDataCancelamento() != null
                            && !c.getDataCancelamento().isBlank()
                            && !c.getDataCancelamento().equals("0000-00-00")) {
                        cc.setDataCancelamento(LocalDate.parse(c.getDataCancelamento()));
                    }
                } catch (DateTimeParseException e) {
                    cc.setDataCancelamento(null);
                }

                Vendedor vendedor = vendedores.stream()
                        .filter(v -> v.getId() != null)
                        .filter(v -> c.getIdVendedor() != null)
                        .filter(v -> v.getId().toString().equals(c.getIdVendedor()))
                        .findFirst()
                        .orElse(null);

                cc.setVendedor(vendedor);

                PlanoVenda planoVenda = planoVendaService.buscarPorId(c.getIdVdContrato());

                if (planoVenda != null) {
                    cc.setPlanoVenda(planoVenda);
                    cc.setPlano(planoVenda.getNome());
                } else {
                    cc.setPlano(c.getContrato());
                }

                if (cc.getId() != null) {
                    List<ProdutoContrato> produtos = produtoContratoService.buscarPorContratoId(cc.getId());
                    List<Acrescimo> acrescimos = acrescimoService.buscarPorContratoId(cc.getId());
                    List<Desconto> descontos = descontoService.buscarPorContratoId(cc.getId());
                    List<ServicoAdicional> servicosAdicionais = servicoAdicionalService.buscarPorContratoId(cc.getId());

                    cc.setProdutos(produtos);
                    cc.setAcrescimos(acrescimos);
                    cc.setDescontos(descontos);

                    cc.setValorPlano(calcularValorPlano(
                            planoVenda,
                            produtos,
                            acrescimos,
                            descontos,
                            servicosAdicionais
                    ));
                } else {
                    cc.setValorPlano(calcularValorPlano(
                            planoVenda,
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>()
                    ));
                }

                contratos.add(cc);
            });

            return contratos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter contratos: ", e);
        }
    }

    private static String montarGridParams(FiltroContratoDTO filtro) {
        List<String> params = new ArrayList<>();

        if (filtro.getDataInicialAtivacao() != null && filtro.getDataFinalAtivacao() != null) {
            params.add(GridParamConstructor.DoubleGridParamConstructor(
                    "cliente_contrato.data_ativacao",
                    GridParamConstructor.BE,
                    filtro.getDataInicialAtivacao().toString(),
                    filtro.getDataFinalAtivacao().toString()
            ));
        }

        if (filtro.getDataInicialCancelamento() != null && filtro.getDataFinalCancelamento() != null) {
            params.add(GridParamConstructor.DoubleGridParamConstructor(
                    "cliente_contrato.data_cancelamento",
                    GridParamConstructor.BE,
                    filtro.getDataInicialCancelamento().toString(),
                    filtro.getDataFinalCancelamento().toString()
            ));
        }

        if (filtro.getStatusContrato() != null && !filtro.getStatusContrato().isBlank()) {
            params.add(GridParamConstructor.SimpleGridParamConstructor(
                    "cliente_contrato.status",
                    GridParamConstructor.EQUAL,
                    filtro.getStatusContrato()
            ));
        }

        if (filtro.getId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor(
                    "cliente_contrato.id",
                    GridParamConstructor.EQUAL,
                    filtro.getId().toString()
            ));
        }

        if (filtro.getStatusAcesso() != null && !filtro.getStatusAcesso().isBlank()) {
            params.add(GridParamConstructor.SimpleGridParamConstructor(
                    "cliente_contrato.status_internet",
                    GridParamConstructor.EQUAL,
                    filtro.getStatusAcesso()
            ));
        }

        if (filtro.getVendedorId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor(
                    "cliente_contrato.vendedor_id",
                    GridParamConstructor.EQUAL,
                    filtro.getVendedorId().toString()
            ));
        }

        if (filtro.getPlanoId() != null) {
            params.add(GridParamConstructor.SimpleGridParamConstructor(
                    "cliente_contrato.contrato",
                    GridParamConstructor.EQUAL,
                    filtro.getPlanoId().toString()
            ));
        }

        return String.join(",", params);
    }

    private Double calcularValorPlano(
            PlanoVenda planoVenda,
            List<ProdutoContrato> produtos,
            List<Acrescimo> acrescimos,
            List<Desconto> descontos,
            List<ServicoAdicional> servicosAdicionais
    ) {
        double valorPlanoVenda = planoVenda != null && planoVenda.getValorContrato() != null
                ? planoVenda.getValorContrato()
                : 0.0;

        double valorProdutos = produtos != null
                ? produtos.stream()
                        .filter(produto -> produto.getValorUnitario() != null)
                        .mapToDouble(produto -> {
                            double quantidade = produto.getQuantidade() != null
                                    ? produto.getQuantidade()
                                    : 1.0;

                            return produto.getValorUnitario() * quantidade;
                        })
                        .sum()
                : 0.0;

        double valorAcrescimos = acrescimos != null
                ? acrescimos.stream()
                        .filter(acrescimo -> acrescimo.getValor() != null)
                        .mapToDouble(Acrescimo::getValor)
                        .sum()
                : 0.0;

        double valorDescontos = descontos != null
                ? descontos.stream()
                        .filter(desconto -> desconto.getValor() != null)
                        .mapToDouble(Desconto::getValor)
                        .sum()
                : 0.0;

        double valorServicosAdicionais = servicosAdicionais != null
                ? servicosAdicionais.stream()
                        .filter(servico -> servico.getValorTotal() != null)
                        .mapToDouble(ServicoAdicional::getValorTotal)
                        .sum()
                : 0.0;

        return valorPlanoVenda + valorProdutos + valorAcrescimos + valorServicosAdicionais - valorDescontos;
    }

}
