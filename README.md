# Planet Metas

Dashboard interno para acompanhamento de metas comerciais com dados integrados da IXC, cache local em MySQL, ranking de vendedores e exportacao de relatorio em Excel.

## Visao geral

O sistema consolida instalacoes, planos, tickets e pontuacao de vendedores em uma interface web simples para acompanhamento operacional. A aplicacao consulta a IXC, grava os dados tratados em cache local e usa esse cache para carregar o dashboard com mais previsibilidade.

## Principais recursos

- Dashboard por periodo com atalhos: hoje, ontem, este mes, mes passado, ultimos 3 meses e este ano.
- Filtro por tipo de vendedor: todos, internos ou externos.
- Ranking de vendedores por pontuacao.
- Filtro rapido da tabela ao clicar em um vendedor do ranking.
- Indicadores de instalacoes, vendedores, ticket medio e pontos totais.
- Exportacao de relatorio em Excel.
- Cache local em banco MySQL.
- Atualizacao agendada do cache duas vezes ao dia.
- Logs diarios em arquivo.

## Requisitos

- Java 17.
- MySQL acessivel pela aplicacao.
- Maven ou Maven Wrapper.
- Credenciais/API da IXC configuradas por variavel de ambiente.

## Configuracao

As principais configuracoes ficam em `src/main/resources/application.properties`.

Variaveis de ambiente suportadas:

| Variavel | Descricao | Padrao |
| --- | --- | --- |
| `IXC_AUTH` | Token/credencial de autenticacao da IXC | obrigatoria |
| `DB_URL` | URL JDBC do MySQL | `jdbc:mysql://localhost:3306/metas?...` |
| `DB_USER` | Usuario do banco | `root` |
| `DB_PASSWORD` | Senha do banco | vazio |
| `DB_DDL_AUTO` | Estrategia Hibernate DDL | `update` |
| `METAS_CACHE_SCHEDULER_ENABLED` | Liga/desliga scheduler | `true` |
| `METAS_CACHE_SCHEDULER_CRON` | Cron da atualizacao do cache | `0 0 6,12 * * *` |
| `METAS_CACHE_SCHEDULER_ZONE` | Timezone do scheduler | `America/Sao_Paulo` |
| `METAS_CACHE_SCHEDULER_DATA_INICIAL` | Data inicial do processamento automatico | `2026-01-01` |
| `LOG_PATH` | Pasta dos logs | `logs` |

A aplicacao sobe por padrao na porta:

```text
5051
```

URL local:

```text
http://localhost:5051
```

## Cache e atualizacao automatica

O cache e atualizado automaticamente todos os dias as 06:00 e 12:00, buscando dados da IXC desde a data inicial configurada ate o dia atual.

Tambem existe endpoint tecnico para atualizacao manual:

```http
POST /metas/cache/atualizar?dataInicial=2026-01-01&dataFinal=2026-05-15
```

O cache evita duplicidade usando contrato e ordem de servico como referencia.

## Logs

Os logs sao gravados por dia na pasta `logs`:

```text
logs/metas_15-05-2026.log
```

A retencao configurada e de 30 dias, com limite total de 1GB.

## Build

Para compilar e gerar o jar:

```powershell
mvn clean package -DskipTests
```

Artefato esperado:

```text
target/Metas-1.0.1.jar
```

## Execucao no servidor

Copie para o servidor:

- `target/Metas-1.0.1.jar`
- `run-metas.bat`

Mantenha os dois arquivos na mesma pasta e execute:

```bat
run-metas.bat
```

Antes de iniciar, configure as variaveis de ambiente necessarias, principalmente `IXC_AUTH`, `DB_URL`, `DB_USER` e `DB_PASSWORD`.

## Endpoints principais

| Metodo | Endpoint | Descricao |
| --- | --- | --- |
| `GET` | `/` | Interface web |
| `GET` | `/metas/dashboard` | Dados consolidados do dashboard |
| `GET` | `/metas/relatorio` | Exportacao Excel |
| `GET` | `/metas/cache/ultima-atualizacao` | Ultima atualizacao do cache |
| `POST` | `/metas/cache/atualizar` | Atualizacao manual do cache |

## Versionamento

O projeto usa versionamento semantico:

```text
MAJOR.MINOR.PATCH
```

Exemplo:

```text
v1.0.0
```

Correcoes pequenas devem incrementar `PATCH`, novas funcionalidades incrementam `MINOR`, e mudancas incompatveis incrementam `MAJOR`.
