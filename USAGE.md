Resume Builder & Analyzer — Quick Usage

This is a console app that collects your resume via Q&A and suggests job matches + learning roadmaps.

Prerequisites
- Java 21 (JDK) installed

Quick run (already built)
1. Extract `resume-builder-release.zip` (or be in project root)
2. Double-click `run.bat` (Windows) or run `./run.sh` (macOS/Linux)

Run directly (PowerShell):
```powershell
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-21'
java -jar .\target\resume-builder-analyzer-1.0-SNAPSHOT.jar
```

Build from source (optional)
```powershell
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-21'
.\mvnw clean package -DskipTests
```

If something goes wrong
- Verify the JAR exists in `target\\`.
- Make sure `JAVA_HOME` points to a Java 21 JDK.

License: See `LICENSE`
