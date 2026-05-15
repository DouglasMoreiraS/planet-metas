# Changelog

Todas as mudancas relevantes deste projeto serao documentadas neste arquivo.

## v1.0.0 - 2026-05-15

### Adicionado

- Dashboard web para acompanhamento de metas comerciais.
- Consulta de dados por periodo.
- Atalhos de periodo: hoje, ontem, este mes, mes passado, ultimos 3 meses e este ano.
- Filtro por vendedores internos e externos.
- Ranking de vendedores por pontuacao.
- Filtro local da planilha ao clicar no vendedor do ranking.
- Indicadores de instalacoes, vendedores, ticket medio e pontos totais.
- Exportacao de relatorio em Excel.
- Cache local em MySQL.
- Atualizacao agendada do cache as 06:00 e 12:00.
- Endpoint tecnico para atualizacao manual do cache.
- Endpoint de ultima atualizacao do cache.
- Logs diarios em arquivo com retencao de 30 dias.

### Alterado

- Porta padrao configurada para `5051`.
- Coluna Cliente removida temporariamente da tabela web de dados da planilha.

### Observacoes

- O campo Cliente permanece fora da view nesta versao porque a consulta ainda precisa ser otimizada para nao aumentar o custo da integracao com a IXC.
- Registros antigos de cache podem exigir reprocessamento para refletir alteracoes recentes na classificacao de vendedores internos/externos.
