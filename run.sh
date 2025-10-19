#!/usr/bin/env bash
# Simple launcher for Unix-like systems. Uses JAVA_HOME if set.
if [ -n "$JAVA_HOME" ]; then
  JAVA_BIN="$JAVA_HOME/bin/java"
else
  JAVA_BIN="java"
fi
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
BASE="$SCRIPT_DIR/target/resume-builder-analyzer-1.0-SNAPSHOT"
JAR_FILE="$BASE-shaded.jar"
if [ ! -f "$JAR_FILE" ]; then
  JAR_FILE="$BASE.jar"
fi
if [ ! -f "$JAR_FILE" ]; then
  echo "Jar not found: $SCRIPT_DIR/target/"
  echo "Please run: mvn clean package"
  exit 1
fi
"$JAVA_BIN" -jar "$JAR_FILE" "$@"
