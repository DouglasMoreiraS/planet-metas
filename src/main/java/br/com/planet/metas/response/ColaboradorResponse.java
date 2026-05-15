package br.com.planet.metas.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColaboradorResponse {

    private String page;
    private int total;
    private List<Registro> registros;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Registro {

        @JsonProperty("img_assinatura")
        private String imgAssinatura;

        @JsonProperty("ramal")
        private String ramal;

        @JsonProperty("envia_telegram_os")
        private String enviaTelegramOs;

        @JsonProperty("telegram_chat_id_funcionario")
        private String telegramChatIdFuncionario;

        @JsonProperty("id_chat_telegram_funcionario")
        private String idChatTelegramFuncionario;

        @JsonProperty("id_perfil_jornada_trabalho")
        private String idPerfilJornadaTrabalho;

        @JsonProperty("rastreador")
        private String rastreador;

        @JsonProperty("ferias_colaborador")
        private String feriasColaborador;

        @JsonProperty("id_conta_decimo")
        private String idContaDecimo;

        @JsonProperty("rastreador_tipo")
        private String rastreadorTipo;

        @JsonProperty("maximo_os_dia")
        private String maximoOsDia;

        @JsonProperty("id")
        private String id;

        @JsonProperty("funcionario")
        private String funcionario;

        @JsonProperty("ativo")
        private String ativo;

        @JsonProperty("id_funcao")
        private String idFuncao;

        @JsonProperty("fone_celular")
        private String foneCelular;

        @JsonProperty("id_conta")
        private String idConta;

        @JsonProperty("email")
        private String email;

        @JsonProperty("coeficiente")
        private String coeficiente;

        @JsonProperty("cor_mapa")
        private String corMapa;

        @JsonProperty("filial_id")
        private String filialId;

        @JsonProperty("data_nascimento")
        private String dataNascimento;

        @JsonProperty("data_admissao")
        private String dataAdmissao;

        @JsonProperty("id_conta_salario")
        private String idContaSalario;

        @JsonProperty("envia_email_os")
        private String enviaEmailOs;

        @JsonProperty("envia_sms_os")
        private String enviaSmsOs;

        @JsonProperty("integracao_calendario")
        private String integracaoCalendario;

        @JsonProperty("id_setor_padrao")
        private String idSetorPadrao;

        @JsonProperty("endereco")
        private String endereco;

        @JsonProperty("cidade")
        private String cidade;

        @JsonProperty("numero")
        private String numero;

        @JsonProperty("bairro")
        private String bairro;

        @JsonProperty("uf")
        private String uf;

        @JsonProperty("cep")
        private String cep;

        @JsonProperty("complemento")
        private String complemento;

        @JsonProperty("referencia")
        private String referencia;

        @JsonProperty("cpf_cnpj")
        private String cpfCnpj;

        @JsonProperty("ie_identidade")
        private String ieIdentidade;

        @JsonProperty("rg_orgao_emissor")
        private String rgOrgaoEmissor;

        @JsonProperty("nacionalidade")
        private String nacionalidade;

        @JsonProperty("fone")
        private String fone;

        @JsonProperty("telefone_comercial")
        private String telefoneComercial;

        @JsonProperty("assinatura_email")
        private String assinaturaEmail;

        @JsonProperty("id_email_smtp")
        private String idEmailSmtp;

        @JsonProperty("banco")
        private String banco;

        @JsonProperty("agencia")
        private String agencia;

        @JsonProperty("numero_conta_dv")
        private String numeroContaDv;

        @JsonProperty("agencia_dv")
        private String agenciaDv;

        @JsonProperty("conta")
        private String conta;

        @JsonProperty("tipo_recebimento")
        private String tipoRecebimento;

        @JsonProperty("data_demissao")
        private String dataDemissao;

        @JsonProperty("obs")
        private String obs;

        @JsonProperty("percen_max_desc_areceber")
        private String percenMaxDescAreceber;

        @JsonProperty("prj_custo_hora_adicionais")
        private String prjCustoHoraAdicionais;

        @JsonProperty("prj_custo_hora_base")
        private String prjCustoHoraBase;

        @JsonProperty("camara_centralizadora")
        private String camaraCentralizadora;

        @JsonProperty("estado_civil")
        private String estadoCivil;

        @JsonProperty("nome_mae")
        private String nomeMae;

        @JsonProperty("nome_pai")
        private String nomePai;

        @JsonProperty("tipo_deficiencia")
        private String tipoDeficiencia;

        @JsonProperty("possui_deficiencia")
        private String possuiDeficiencia;

        @JsonProperty("camiseta")
        private String camiseta;

        @JsonProperty("num_manequim")
        private String numManequim;

        @JsonProperty("cor_raca")
        private String corRaca;

        @JsonProperty("num_dependentes")
        private String numDependentes;

        @JsonProperty("dependentes_ir")
        private String dependentesIr;

        @JsonProperty("nome_conjuge")
        private String nomeConjuge;

        @JsonProperty("estagio_escolaridade")
        private String estagioEscolaridade;

        @JsonProperty("periodo_escolaridade")
        private String periodoEscolaridade;

        @JsonProperty("grau_escolaridade")
        private String grauEscolaridade;

        @JsonProperty("falar_com")
        private String falarCom;

        @JsonProperty("fone_emergencia")
        private String foneEmergencia;

        @JsonProperty("salario")
        private String salario;

        @JsonProperty("cnh_categoria")
        private String cnhCategoria;

        @JsonProperty("titulo_secao")
        private String tituloSecao;

        @JsonProperty("titulo_zona")
        private String tituloZona;

        @JsonProperty("titulo_numero")
        private String tituloNumero;

        @JsonProperty("ctps_cidade_emissao")
        private String ctpsCidadeEmissao;

        @JsonProperty("ctps_data_emissao")
        private String ctpsDataEmissao;

        @JsonProperty("ctps_serie")
        private String ctpsSerie;

        @JsonProperty("ctps_numero")
        private String ctpsNumero;

        @JsonProperty("cnh_numero")
        private String cnhNumero;

        @JsonProperty("cpf_conjuge")
        private String cpfConjuge;

        @JsonProperty("rg_conjuge")
        private String rgConjuge;

        @JsonProperty("cnh_vencimento")
        private String cnhVencimento;

        @JsonProperty("pis_data")
        private String pisData;

        @JsonProperty("pis_numero")
        private String pisNumero;

        @JsonProperty("rg_data_emissao")
        private String rgDataEmissao;

        @JsonProperty("dep_tres_cpf")
        private String depTresCpf;

        @JsonProperty("dep_tres_rg")
        private String depTresRg;

        @JsonProperty("dep_tres_nome")
        private String depTresNome;

        @JsonProperty("dep_dois_cpf")
        private String depDoisCpf;

        @JsonProperty("dep_dois_rg")
        private String depDoisRg;

        @JsonProperty("dep_dois_nome")
        private String depDoisNome;

        @JsonProperty("dep_um_cpf")
        private String depUmCpf;

        @JsonProperty("dep_um_rg")
        private String depUmRg;

        @JsonProperty("dep_um_nome")
        private String depUmNome;

        @JsonProperty("id_departamento")
        private String idDepartamento;

        @JsonProperty("ultima_atualizacao")
        private String ultimaAtualizacao;

        @JsonProperty("exibir_colaborador_inmap")
        private String exibirColaboradorInmap;

        @JsonProperty("tipo_chave_pix")
        private String tipoChavePix;

        @JsonProperty("chave_pix")
        private String chavePix;

        @JsonProperty("mostrar_no_quadro_kanban")
        private String mostrarNoQuadroKanban;

        @JsonProperty("tipo_documento_identificacao_col")
        private String tipoDocumentoIdentificacaoCol;

        public String getImgAssinatura() {
            return imgAssinatura;
        }

        public void setImgAssinatura(String imgAssinatura) {
            this.imgAssinatura = imgAssinatura;
        }

        public String getRamal() {
            return ramal;
        }

        public void setRamal(String ramal) {
            this.ramal = ramal;
        }

        public String getEnviaTelegramOs() {
            return enviaTelegramOs;
        }

        public void setEnviaTelegramOs(String enviaTelegramOs) {
            this.enviaTelegramOs = enviaTelegramOs;
        }

        public String getTelegramChatIdFuncionario() {
            return telegramChatIdFuncionario;
        }

        public void setTelegramChatIdFuncionario(String telegramChatIdFuncionario) {
            this.telegramChatIdFuncionario = telegramChatIdFuncionario;
        }

        public String getIdChatTelegramFuncionario() {
            return idChatTelegramFuncionario;
        }

        public void setIdChatTelegramFuncionario(String idChatTelegramFuncionario) {
            this.idChatTelegramFuncionario = idChatTelegramFuncionario;
        }

        public String getIdPerfilJornadaTrabalho() {
            return idPerfilJornadaTrabalho;
        }

        public void setIdPerfilJornadaTrabalho(String idPerfilJornadaTrabalho) {
            this.idPerfilJornadaTrabalho = idPerfilJornadaTrabalho;
        }

        public String getRastreador() {
            return rastreador;
        }

        public void setRastreador(String rastreador) {
            this.rastreador = rastreador;
        }

        public String getFeriasColaborador() {
            return feriasColaborador;
        }

        public void setFeriasColaborador(String feriasColaborador) {
            this.feriasColaborador = feriasColaborador;
        }

        public String getIdContaDecimo() {
            return idContaDecimo;
        }

        public void setIdContaDecimo(String idContaDecimo) {
            this.idContaDecimo = idContaDecimo;
        }

        public String getRastreadorTipo() {
            return rastreadorTipo;
        }

        public void setRastreadorTipo(String rastreadorTipo) {
            this.rastreadorTipo = rastreadorTipo;
        }

        public String getMaximoOsDia() {
            return maximoOsDia;
        }

        public void setMaximoOsDia(String maximoOsDia) {
            this.maximoOsDia = maximoOsDia;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFuncionario() {
            return funcionario;
        }

        public void setFuncionario(String funcionario) {
            this.funcionario = funcionario;
        }

        public String getAtivo() {
            return ativo;
        }

        public void setAtivo(String ativo) {
            this.ativo = ativo;
        }

        public String getIdFuncao() {
            return idFuncao;
        }

        public void setIdFuncao(String idFuncao) {
            this.idFuncao = idFuncao;
        }

        public String getFoneCelular() {
            return foneCelular;
        }

        public void setFoneCelular(String foneCelular) {
            this.foneCelular = foneCelular;
        }

        public String getIdConta() {
            return idConta;
        }

        public void setIdConta(String idConta) {
            this.idConta = idConta;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCoeficiente() {
            return coeficiente;
        }

        public void setCoeficiente(String coeficiente) {
            this.coeficiente = coeficiente;
        }

        public String getCorMapa() {
            return corMapa;
        }

        public void setCorMapa(String corMapa) {
            this.corMapa = corMapa;
        }

        public String getFilialId() {
            return filialId;
        }

        public void setFilialId(String filialId) {
            this.filialId = filialId;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public String getDataAdmissao() {
            return dataAdmissao;
        }

        public void setDataAdmissao(String dataAdmissao) {
            this.dataAdmissao = dataAdmissao;
        }

        public String getIdContaSalario() {
            return idContaSalario;
        }

        public void setIdContaSalario(String idContaSalario) {
            this.idContaSalario = idContaSalario;
        }

        public String getEnviaEmailOs() {
            return enviaEmailOs;
        }

        public void setEnviaEmailOs(String enviaEmailOs) {
            this.enviaEmailOs = enviaEmailOs;
        }

        public String getEnviaSmsOs() {
            return enviaSmsOs;
        }

        public void setEnviaSmsOs(String enviaSmsOs) {
            this.enviaSmsOs = enviaSmsOs;
        }

        public String getIntegracaoCalendario() {
            return integracaoCalendario;
        }

        public void setIntegracaoCalendario(String integracaoCalendario) {
            this.integracaoCalendario = integracaoCalendario;
        }

        public String getIdSetorPadrao() {
            return idSetorPadrao;
        }

        public void setIdSetorPadrao(String idSetorPadrao) {
            this.idSetorPadrao = idSetorPadrao;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getUf() {
            return uf;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public String getComplemento() {
            return complemento;
        }

        public void setComplemento(String complemento) {
            this.complemento = complemento;
        }

        public String getReferencia() {
            return referencia;
        }

        public void setReferencia(String referencia) {
            this.referencia = referencia;
        }

        public String getCpfCnpj() {
            return cpfCnpj;
        }

        public void setCpfCnpj(String cpfCnpj) {
            this.cpfCnpj = cpfCnpj;
        }

        public String getIeIdentidade() {
            return ieIdentidade;
        }

        public void setIeIdentidade(String ieIdentidade) {
            this.ieIdentidade = ieIdentidade;
        }

        public String getRgOrgaoEmissor() {
            return rgOrgaoEmissor;
        }

        public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
            this.rgOrgaoEmissor = rgOrgaoEmissor;
        }

        public String getNacionalidade() {
            return nacionalidade;
        }

        public void setNacionalidade(String nacionalidade) {
            this.nacionalidade = nacionalidade;
        }

        public String getFone() {
            return fone;
        }

        public void setFone(String fone) {
            this.fone = fone;
        }

        public String getTelefoneComercial() {
            return telefoneComercial;
        }

        public void setTelefoneComercial(String telefoneComercial) {
            this.telefoneComercial = telefoneComercial;
        }

        public String getAssinaturaEmail() {
            return assinaturaEmail;
        }

        public void setAssinaturaEmail(String assinaturaEmail) {
            this.assinaturaEmail = assinaturaEmail;
        }

        public String getIdEmailSmtp() {
            return idEmailSmtp;
        }

        public void setIdEmailSmtp(String idEmailSmtp) {
            this.idEmailSmtp = idEmailSmtp;
        }

        public String getBanco() {
            return banco;
        }

        public void setBanco(String banco) {
            this.banco = banco;
        }

        public String getAgencia() {
            return agencia;
        }

        public void setAgencia(String agencia) {
            this.agencia = agencia;
        }

        public String getNumeroContaDv() {
            return numeroContaDv;
        }

        public void setNumeroContaDv(String numeroContaDv) {
            this.numeroContaDv = numeroContaDv;
        }

        public String getAgenciaDv() {
            return agenciaDv;
        }

        public void setAgenciaDv(String agenciaDv) {
            this.agenciaDv = agenciaDv;
        }

        public String getConta() {
            return conta;
        }

        public void setConta(String conta) {
            this.conta = conta;
        }

        public String getTipoRecebimento() {
            return tipoRecebimento;
        }

        public void setTipoRecebimento(String tipoRecebimento) {
            this.tipoRecebimento = tipoRecebimento;
        }

        public String getDataDemissao() {
            return dataDemissao;
        }

        public void setDataDemissao(String dataDemissao) {
            this.dataDemissao = dataDemissao;
        }

        public String getObs() {
            return obs;
        }

        public void setObs(String obs) {
            this.obs = obs;
        }

        public String getPercenMaxDescAreceber() {
            return percenMaxDescAreceber;
        }

        public void setPercenMaxDescAreceber(String percenMaxDescAreceber) {
            this.percenMaxDescAreceber = percenMaxDescAreceber;
        }

        public String getPrjCustoHoraAdicionais() {
            return prjCustoHoraAdicionais;
        }

        public void setPrjCustoHoraAdicionais(String prjCustoHoraAdicionais) {
            this.prjCustoHoraAdicionais = prjCustoHoraAdicionais;
        }

        public String getPrjCustoHoraBase() {
            return prjCustoHoraBase;
        }

        public void setPrjCustoHoraBase(String prjCustoHoraBase) {
            this.prjCustoHoraBase = prjCustoHoraBase;
        }

        public String getCamaraCentralizadora() {
            return camaraCentralizadora;
        }

        public void setCamaraCentralizadora(String camaraCentralizadora) {
            this.camaraCentralizadora = camaraCentralizadora;
        }

        public String getEstadoCivil() {
            return estadoCivil;
        }

        public void setEstadoCivil(String estadoCivil) {
            this.estadoCivil = estadoCivil;
        }

        public String getNomeMae() {
            return nomeMae;
        }

        public void setNomeMae(String nomeMae) {
            this.nomeMae = nomeMae;
        }

        public String getNomePai() {
            return nomePai;
        }

        public void setNomePai(String nomePai) {
            this.nomePai = nomePai;
        }

        public String getTipoDeficiencia() {
            return tipoDeficiencia;
        }

        public void setTipoDeficiencia(String tipoDeficiencia) {
            this.tipoDeficiencia = tipoDeficiencia;
        }

        public String getPossuiDeficiencia() {
            return possuiDeficiencia;
        }

        public void setPossuiDeficiencia(String possuiDeficiencia) {
            this.possuiDeficiencia = possuiDeficiencia;
        }

        public String getCamiseta() {
            return camiseta;
        }

        public void setCamiseta(String camiseta) {
            this.camiseta = camiseta;
        }

        public String getNumManequim() {
            return numManequim;
        }

        public void setNumManequim(String numManequim) {
            this.numManequim = numManequim;
        }

        public String getCorRaca() {
            return corRaca;
        }

        public void setCorRaca(String corRaca) {
            this.corRaca = corRaca;
        }

        public String getNumDependentes() {
            return numDependentes;
        }

        public void setNumDependentes(String numDependentes) {
            this.numDependentes = numDependentes;
        }

        public String getDependentesIr() {
            return dependentesIr;
        }

        public void setDependentesIr(String dependentesIr) {
            this.dependentesIr = dependentesIr;
        }

        public String getNomeConjuge() {
            return nomeConjuge;
        }

        public void setNomeConjuge(String nomeConjuge) {
            this.nomeConjuge = nomeConjuge;
        }

        public String getEstagioEscolaridade() {
            return estagioEscolaridade;
        }

        public void setEstagioEscolaridade(String estagioEscolaridade) {
            this.estagioEscolaridade = estagioEscolaridade;
        }

        public String getPeriodoEscolaridade() {
            return periodoEscolaridade;
        }

        public void setPeriodoEscolaridade(String periodoEscolaridade) {
            this.periodoEscolaridade = periodoEscolaridade;
        }

        public String getGrauEscolaridade() {
            return grauEscolaridade;
        }

        public void setGrauEscolaridade(String grauEscolaridade) {
            this.grauEscolaridade = grauEscolaridade;
        }

        public String getFalarCom() {
            return falarCom;
        }

        public void setFalarCom(String falarCom) {
            this.falarCom = falarCom;
        }

        public String getFoneEmergencia() {
            return foneEmergencia;
        }

        public void setFoneEmergencia(String foneEmergencia) {
            this.foneEmergencia = foneEmergencia;
        }

        public String getSalario() {
            return salario;
        }

        public void setSalario(String salario) {
            this.salario = salario;
        }

        public String getCnhCategoria() {
            return cnhCategoria;
        }

        public void setCnhCategoria(String cnhCategoria) {
            this.cnhCategoria = cnhCategoria;
        }

        public String getTituloSecao() {
            return tituloSecao;
        }

        public void setTituloSecao(String tituloSecao) {
            this.tituloSecao = tituloSecao;
        }

        public String getTituloZona() {
            return tituloZona;
        }

        public void setTituloZona(String tituloZona) {
            this.tituloZona = tituloZona;
        }

        public String getTituloNumero() {
            return tituloNumero;
        }

        public void setTituloNumero(String tituloNumero) {
            this.tituloNumero = tituloNumero;
        }

        public String getCtpsCidadeEmissao() {
            return ctpsCidadeEmissao;
        }

        public void setCtpsCidadeEmissao(String ctpsCidadeEmissao) {
            this.ctpsCidadeEmissao = ctpsCidadeEmissao;
        }

        public String getCtpsDataEmissao() {
            return ctpsDataEmissao;
        }

        public void setCtpsDataEmissao(String ctpsDataEmissao) {
            this.ctpsDataEmissao = ctpsDataEmissao;
        }

        public String getCtpsSerie() {
            return ctpsSerie;
        }

        public void setCtpsSerie(String ctpsSerie) {
            this.ctpsSerie = ctpsSerie;
        }

        public String getCtpsNumero() {
            return ctpsNumero;
        }

        public void setCtpsNumero(String ctpsNumero) {
            this.ctpsNumero = ctpsNumero;
        }

        public String getCnhNumero() {
            return cnhNumero;
        }

        public void setCnhNumero(String cnhNumero) {
            this.cnhNumero = cnhNumero;
        }

        public String getCpfConjuge() {
            return cpfConjuge;
        }

        public void setCpfConjuge(String cpfConjuge) {
            this.cpfConjuge = cpfConjuge;
        }

        public String getRgConjuge() {
            return rgConjuge;
        }

        public void setRgConjuge(String rgConjuge) {
            this.rgConjuge = rgConjuge;
        }

        public String getCnhVencimento() {
            return cnhVencimento;
        }

        public void setCnhVencimento(String cnhVencimento) {
            this.cnhVencimento = cnhVencimento;
        }

        public String getPisData() {
            return pisData;
        }

        public void setPisData(String pisData) {
            this.pisData = pisData;
        }

        public String getPisNumero() {
            return pisNumero;
        }

        public void setPisNumero(String pisNumero) {
            this.pisNumero = pisNumero;
        }

        public String getRgDataEmissao() {
            return rgDataEmissao;
        }

        public void setRgDataEmissao(String rgDataEmissao) {
            this.rgDataEmissao = rgDataEmissao;
        }

        public String getDepTresCpf() {
            return depTresCpf;
        }

        public void setDepTresCpf(String depTresCpf) {
            this.depTresCpf = depTresCpf;
        }

        public String getDepTresRg() {
            return depTresRg;
        }

        public void setDepTresRg(String depTresRg) {
            this.depTresRg = depTresRg;
        }

        public String getDepTresNome() {
            return depTresNome;
        }

        public void setDepTresNome(String depTresNome) {
            this.depTresNome = depTresNome;
        }

        public String getDepDoisCpf() {
            return depDoisCpf;
        }

        public void setDepDoisCpf(String depDoisCpf) {
            this.depDoisCpf = depDoisCpf;
        }

        public String getDepDoisRg() {
            return depDoisRg;
        }

        public void setDepDoisRg(String depDoisRg) {
            this.depDoisRg = depDoisRg;
        }

        public String getDepDoisNome() {
            return depDoisNome;
        }

        public void setDepDoisNome(String depDoisNome) {
            this.depDoisNome = depDoisNome;
        }

        public String getDepUmCpf() {
            return depUmCpf;
        }

        public void setDepUmCpf(String depUmCpf) {
            this.depUmCpf = depUmCpf;
        }

        public String getDepUmRg() {
            return depUmRg;
        }

        public void setDepUmRg(String depUmRg) {
            this.depUmRg = depUmRg;
        }

        public String getDepUmNome() {
            return depUmNome;
        }

        public void setDepUmNome(String depUmNome) {
            this.depUmNome = depUmNome;
        }

        public String getIdDepartamento() {
            return idDepartamento;
        }

        public void setIdDepartamento(String idDepartamento) {
            this.idDepartamento = idDepartamento;
        }

        public String getUltimaAtualizacao() {
            return ultimaAtualizacao;
        }

        public void setUltimaAtualizacao(String ultimaAtualizacao) {
            this.ultimaAtualizacao = ultimaAtualizacao;
        }

        public String getExibirColaboradorInmap() {
            return exibirColaboradorInmap;
        }

        public void setExibirColaboradorInmap(String exibirColaboradorInmap) {
            this.exibirColaboradorInmap = exibirColaboradorInmap;
        }

        public String getTipoChavePix() {
            return tipoChavePix;
        }

        public void setTipoChavePix(String tipoChavePix) {
            this.tipoChavePix = tipoChavePix;
        }

        public String getChavePix() {
            return chavePix;
        }

        public void setChavePix(String chavePix) {
            this.chavePix = chavePix;
        }

        public String getMostrarNoQuadroKanban() {
            return mostrarNoQuadroKanban;
        }

        public void setMostrarNoQuadroKanban(String mostrarNoQuadroKanban) {
            this.mostrarNoQuadroKanban = mostrarNoQuadroKanban;
        }

        public String getTipoDocumentoIdentificacaoCol() {
            return tipoDocumentoIdentificacaoCol;
        }

        public void setTipoDocumentoIdentificacaoCol(String tipoDocumentoIdentificacaoCol) {
            this.tipoDocumentoIdentificacaoCol = tipoDocumentoIdentificacaoCol;
        }

        
    }

    // Getters e setters omitidos para brevidade

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        return "ColaboradorResponse{" + "page=" + page + ", total=" + total + ", registros=" + registros.size() + '}';
    }
    
    
}
