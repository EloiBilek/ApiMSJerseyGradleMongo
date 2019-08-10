@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  ApiMSJerseyGradleMongo startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and API_MS_JERSEY_GRADLE_MONGO_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\ApiMSJerseyGradleMongo.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\jersey-core-1.19.4.jar;%APP_HOME%\lib\jersey-json-1.19.4.jar;%APP_HOME%\lib\jersey-client-1.19.4.jar;%APP_HOME%\lib\jersey-server-1.19.4.jar;%APP_HOME%\lib\jersey-servlet-1.19.4.jar;%APP_HOME%\lib\jersey-multipart-1.19.4.jar;%APP_HOME%\lib\weld-se-core-3.0.0.Final.jar;%APP_HOME%\lib\gson-2.8.1.jar;%APP_HOME%\lib\jackson-databind-2.9.0.pr4.jar;%APP_HOME%\lib\mongo-java-driver-3.4.2.jar;%APP_HOME%\lib\morphia-1.3.2.jar;%APP_HOME%\lib\jetty-client-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-deploy-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-jmx-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-plus-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-annotations-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-util-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-jaspi-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-jndi-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-rewrite-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-servlets-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-quickstart-9.4.6.v20170531.jar;%APP_HOME%\lib\websocket-servlet-9.4.6.v20170531.jar;%APP_HOME%\lib\javax-websocket-server-impl-9.4.6.v20170531.jar;%APP_HOME%\lib\websocket-client-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-alpn-client-9.4.6.v20170531.jar;%APP_HOME%\lib\http2-server-9.4.6.v20170531.jar;%APP_HOME%\lib\http2-client-9.4.6.v20170531.jar;%APP_HOME%\lib\javax.websocket-api-1.0.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\javax.mail.glassfish-1.4.1.v201005082020.jar;%APP_HOME%\lib\jsr311-api-1.1.1.jar;%APP_HOME%\lib\jettison-1.1.jar;%APP_HOME%\lib\jaxb-impl-2.2.3-1.jar;%APP_HOME%\lib\jackson-core-asl-1.9.2.jar;%APP_HOME%\lib\jackson-mapper-asl-1.9.2.jar;%APP_HOME%\lib\jackson-jaxrs-1.9.2.jar;%APP_HOME%\lib\jackson-xc-1.9.2.jar;%APP_HOME%\lib\mimepull-1.9.3.jar;%APP_HOME%\lib\weld-environment-common-3.0.0.Final.jar;%APP_HOME%\lib\weld-probe-core-3.0.0.Final.jar;%APP_HOME%\lib\cdi-api-2.0.jar;%APP_HOME%\lib\jackson-annotations-2.9.0.pr4.jar;%APP_HOME%\lib\jackson-core-2.9.0.pr4.jar;%APP_HOME%\lib\cglib-nodep-2.2.2.jar;%APP_HOME%\lib\proxytoys-1.0.jar;%APP_HOME%\lib\jetty-http-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-io-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-webapp-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-xml-9.4.6.v20170531.jar;%APP_HOME%\lib\asm-5.1.jar;%APP_HOME%\lib\asm-commons-5.1.jar;%APP_HOME%\lib\jetty-security-9.4.6.v20170531.jar;%APP_HOME%\lib\javax.security.auth.message-1.0.0.v201108011116.jar;%APP_HOME%\lib\jetty-server-9.4.6.v20170531.jar;%APP_HOME%\lib\jetty-continuation-9.4.6.v20170531.jar;%APP_HOME%\lib\javax.transaction-api-1.2.jar;%APP_HOME%\lib\websocket-api-9.4.6.v20170531.jar;%APP_HOME%\lib\javax-websocket-client-impl-9.4.6.v20170531.jar;%APP_HOME%\lib\websocket-server-9.4.6.v20170531.jar;%APP_HOME%\lib\websocket-common-9.4.6.v20170531.jar;%APP_HOME%\lib\http2-common-9.4.6.v20170531.jar;%APP_HOME%\lib\javax.activation-1.1.0.v201105071233.jar;%APP_HOME%\lib\jaxb-api-2.2.2.jar;%APP_HOME%\lib\weld-core-impl-3.0.0.Final.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\jetty-servlet-9.4.6.v20170531.jar;%APP_HOME%\lib\asm-tree-5.1.jar;%APP_HOME%\lib\http2-hpack-9.4.6.v20170531.jar;%APP_HOME%\lib\stax-api-1.0-2.jar;%APP_HOME%\lib\activation-1.1.jar;%APP_HOME%\lib\weld-api-3.0.Final.jar;%APP_HOME%\lib\weld-spi-3.0.Final.jar;%APP_HOME%\lib\jboss-classfilewriter-1.1.2.Final.jar;%APP_HOME%\lib\jboss-el-api_3.0_spec-1.0.7.Final.jar;%APP_HOME%\lib\jboss-interceptors-api_1.2_spec-1.0.0.Final.jar;%APP_HOME%\lib\jboss-logging-3.2.1.Final.jar;%APP_HOME%\lib\javax.annotation-api-1.3.jar

@rem Execute ApiMSJerseyGradleMongo
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %API_MS_JERSEY_GRADLE_MONGO_OPTS%  -classpath "%CLASSPATH%" com.apimsjerseygradlemongo.init.InitApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable API_MS_JERSEY_GRADLE_MONGO_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%API_MS_JERSEY_GRADLE_MONGO_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
