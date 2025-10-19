@echo off
REM Simple launcher for Windows. Adjust JAVA_HOME if necessary.
if "%JAVA_HOME%"=="" (
  set "JAVA_EXE=java"
) else (
  set "JAVA_EXE=%JAVA_HOME%\bin\java"
)
set BASE=%~dp0target\resume-builder-analyzer-1.0-SNAPSHOT
set JAR_FILE=%BASE%-shaded.jar
if not exist "%JAR_FILE%" (
  rem fallback to non-shaded jar name created by some shade configurations
  set JAR_FILE=%BASE%.jar
)
if not exist "%JAR_FILE%" (
  echo Jar not found: %~dp0target\
  echo Please run: mvn clean package
  pause
  exit /b 1
)
"%JAVA_EXE%" -jar "%JAR_FILE%" %*

REM Keep the console open after the program exits so you can read output when double-clicking
echo.
echo Program finished. Press any key to exit...
pause >nul
