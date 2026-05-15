@echo off
setlocal

set APP_JAR=Metas-1.0.1.jar

REM IA: Mantem o bat simples para executar o jar versionado na mesma pasta do servidor.
if not exist "%APP_JAR%" (
    echo Arquivo %APP_JAR% nao encontrado.
    echo Copie o jar gerado em target\%APP_JAR% para esta pasta antes de iniciar.
    pause
    exit /b 1
)

echo Iniciando Planet Metas...
echo Porta padrao: 5051

java -jar "%APP_JAR%"

endlocal
