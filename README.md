# Logs, Logs, Logs! in Java

🔗 [Repository on GitHub](https://github.com/lcortes89/kata-java-enums-logs)

Kata based on Exercism's Java Track exercise: parses log lines formatted as `"[<LVL>]: <MESSAGE>"`, maps the abbreviated level to a `LogLevel` enum, and converts the line into a compact encoded format to save disk space. Tests written with JUnit 5 and Hamcrest, code style verified with Checkstyle.

[![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/downloads/) [![Maven](https://img.shields.io/badge/build-Maven-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/) [![JUnit5](https://img.shields.io/badge/tested%20with-JUnit%205-25A162?logo=junit5&logoColor=white)](https://junit.org/junit5/) [![Hamcrest](https://img.shields.io/badge/matchers-Hamcrest-6E4C13)](https://hamcrest.org/JavaHamcrest/) [![Checkstyle](https://img.shields.io/badge/style-Checkstyle-4D7A97)](https://checkstyle.sourceforge.io/)

<a id="index"></a>

# 📑 Index

- [📖 Description](#description)
- [🚀 Demo](#demo)
- [✨ Features](#features)
- [🛠 Technologies](#technologies)
- [⚙ Installation](#installation)
- [▶ Usage](#usage)
- [🧪 Testing and coverage](#testing)
- [📂 Project structure](#structure)
- [👩‍💻 Author](#author)

<a id="description"></a>

## Description

`LogLevel` is an enum representing the six severity levels a log line can have (`TRACE`, `DEBUG`, `INFO`, `WARNING`, `ERROR`, `FATAL`), plus `UNKNOWN` for unrecognized levels. `LogLine` wraps a raw log line and exposes two operations: parsing its level, and converting it to a short encoded format where each level is replaced by a fixed number.

[↑ Index](#index) • [Demo →](#demo)

<a id="demo"></a>

## Demo

```java
var logLine = new LogLine("[INF]: File deleted");
logLine.getLogLevel();
// => LogLevel.INFO

var errorLine = new LogLine("[ERR]: Stack Overflow");
errorLine.getOutputForShortLog();
// => "6:Stack Overflow"
```

[← Description](#description) • [↑ Index](#index) • [Features →](#features)

<a id="features"></a>

## Features

- `LogLevel` enum with the six standard log levels plus `UNKNOWN` for unrecognized ones.
- `LogLine.getLogLevel()`: parses the abbreviated level (`TRC`, `DBG`, `INF`, `WRN`, `ERR`, `FTL`) from a raw log line and maps it to the corresponding `LogLevel`.
- `LogLine.getOutputForShortLog()`: encodes the log line into a compact format (`"<code>:<message>"`), mapping each level to a fixed number (`UNKNOWN` → 0, `TRACE` → 1, `DEBUG` → 2, `INFO` → 4, `WARNING` → 5, `ERROR` → 6, `FATAL` → 42).
- 15 unit tests with JUnit 5 + Hamcrest, covering every log level and the unknown-level case.
- Code style enforced with Checkstyle (`com.github.ngeor:checkstyle-rules`) — 0 violations.

[← Demo](#demo) • [↑ Index](#index) • [Technologies →](#technologies)

<a id="technologies"></a>

## Technologies

- <img src="https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white" alt="Java 21" align="middle"> — Programming language used for the project
- <img src="https://img.shields.io/badge/build-Maven-C71A36?logo=apachemaven&logoColor=white" alt="Maven" align="middle"> — Dependency management and build tool
- <img src="https://img.shields.io/badge/tested%20with-JUnit%205-25A162?logo=junit5&logoColor=white" alt="JUnit 5" align="middle"> — Unit testing framework
- <img src="https://img.shields.io/badge/matchers-Hamcrest-6E4C13" alt="Hamcrest" align="middle"> — Matcher library for readable assertions
- <img src="https://img.shields.io/badge/style-Checkstyle-4D7A97" alt="Checkstyle" align="middle"> — Static code style verification
- <img src="https://img.shields.io/badge/Visual%20Studio%20Code-007ACC?logo=visualstudiocode&logoColor=white" alt="VS Code" align="middle"> — Editor used to develop and manage the project
- <img src="https://img.shields.io/badge/Markdown-000000?logo=markdown&logoColor=white" alt="Markdown" align="middle"> — Markup language for the README
- <img src="https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white" alt="Git" align="middle"> <img src="https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white" alt="GitHub" align="middle"> — Version control and project hosting

[← Features](#features) • [↑ Index](#index) • [Installation →](#installation)

<a id="installation"></a>

## Installation

```bash
git clone https://github.com/lcortes89/kata-java-enums-logs.git
cd kata-java-enums-logs
```

[← Technologies](#technologies) • [↑ Index](#index) • [Usage →](#usage)

<a id="usage"></a>

## Usage

```java
var unknownLine = new LogLine("[XYZ]: Overly specific, out of context message");
unknownLine.getLogLevel();
// => LogLevel.UNKNOWN

var fatalLine = new LogLine("[FTL]: Never gonna give you up");
fatalLine.getOutputForShortLog();
// => "42:Never gonna give you up"
```

[← Installation](#installation) • [↑ Index](#index) • [Testing and coverage →](#testing)

<a id="testing"></a>

## Testing and coverage

```bash
mvn test
```

15 tests in `LogsTest` cover parsing every log level (`TRC`, `DBG`, `INF`, `WRN`, `ERR`, `FTL`), two unrecognized-level cases, and the short-log output for all seven levels including `UNKNOWN`.

Checkstyle is not bound to the `test` phase in this project, so it needs to be run separately:

```bash
mvn checkstyle:check
```

Currently reports 0 violations.

> **Note:** JaCoCo is configured but, as with the previous kata, the bundled version isn't compatible with Java 21 bytecode, so the coverage report analyzes 0 classes. The build still passes because the threshold is set to 0%.

![Tests in VSCode](docs/img/testing.png)

[← Usage](#usage) • [↑ Index](#index) • [Project structure →](#structure)

<a id="structure"></a>

## Project structure

```
KATA-JAVA-ENUMS-LOGS
├── docs/
│   └── img/
│       └── testing.png
├── src/
│   ├── main/java/org/luisa/logs/
│   │   ├── LogLevel.java
│   │   └── LogLine.java
│   └── test/java/org/luisa/logs/
│       └── LogsTest.java
├── pom.xml
└── README.md
```

[← Testing and coverage](#testing) • [↑ Index](#index) • [Author →](#author)

<a id="author"></a>

## Author

**[Luisa Cortés](https://github.com/lcortes89)**

[← Project structure](#structure) • [↑ Index](#index)