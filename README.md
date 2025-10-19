# Resume Builder & Analyzer (OOP Prototype)

This is a small console application that collects a user's resume via Q&A, compares it to mock job posts, analyzes fit, and suggests a learning roadmap.

## Requirements
- Java 21 (JDK)
- Maven (or use the included `mvnw` wrapper)

## Build
From the project root (Windows PowerShell example):

```powershell
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-21'
.\mvnw clean package
```

The build creates a shaded (self-contained) jar at:

```
target\resume-builder-analyzer-1.0-SNAPSHOT-shaded.jar
```

## Run
Use the provided launcher scripts or run the jar directly.

Windows:
```
run.bat
```

Unix/macOS:
```
./run.sh
```

Directly:

```powershell
java -jar target\resume-builder-analyzer-1.0-SNAPSHOT-shaded.jar
```

## Quick dev run (no packaging)

```powershell
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-21'
.\mvnw exec:java -Dexec.mainClass="com.resumeanalyzer.ui.MainApp"
```

## Packaging for distribution
After building the shaded jar, zip the jar and the launchers for distribution.

## Troubleshooting
- If `java -jar` errors with `No main manifest attribute`, ensure you built with `mvn clean package` and that the shaded jar exists.
- Missing dependencies at runtime -> use shaded jar (packaged above).

