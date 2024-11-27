# Advents

[![pipeline status](http://lab.ottorohenkohl.de/entwicklung/kotlin/advents/badges/main/pipeline.svg)](http://lab.ottorohenkohl.de/entwicklung/kotlin/advents/-/commits/main) [![coverage report](http://lab.ottorohenkohl.de/entwicklung/kotlin/advents/badges/main/coverage.svg)](http://lab.ottorohenkohl.de/entwicklung/kotlin/advents/-/commits/main) [![Latest Release](http://lab.ottorohenkohl.de/entwicklung/kotlin/advents/-/badges/release.svg)](http://lab.ottorohenkohl.de/entwicklung/kotlin/advents/-/releases)

**Advents** ist eine CLI-Anwendung, die speziell für die Herausforderungen von **Advent of Code** entwickelt wurde. Sie ermöglicht es, Eingabedaten automatisch herunterzuladen und Lösungen einfach zu registrieren und auszuführen. Die Anwendung wurde mit **Kotlin** und **Gradle** entwickelt und nutzt moderne Frameworks und Bibliotheken, um eine einfache und erweiterbare Lösung zu bieten.

## 1. Projektbeschreibung

Das Projekt automatisiert viele Schritte, die bei der Teilnahme an Advent of Code erforderlich sind:

- **Automatischer Input-Download**: Über ein konfigurierbares Advent of Code Session-Token werden die Inputs der jeweiligen Tage automatisch geladen.
- **Einfache Lösungserstellung**: Lösungen können mithilfe der Annotation `@Riddle` registriert werden.
- **Flexible CLI-Parameter**: Bestimme gezielt, welchen Tag, welches Jahr und welchen Teil du lösen möchtest.
- **Debug-Modus**: Zeigt den Input und die Lösung direkt in der Konsole an.

Das Projekt ist modular aufgebaut und integriert sich nahtlos in Gradle.

## 2. Installation/Einrichtung

### Konfiguration

Die Anwendung benötigt ein gültiges Advent of Code Session-Token, das in der Datei `application.properties` konfiguriert wird. Die Datei liegt im Hauptverzeichnis des Projekts.

Beispiel:

```properties
aoc.session=YOUR_SESSION_TOKEN
```

### Start der Anwendung

Die Anwendung kann mit Gradle ausgeführt werden:

```bash
./gradlew run --args="-d 1 -p 1 -y 2023"
```

## 3. Nutzung/Beispiele

Die CLI-Anwendung bietet folgende Parameter:

| Parameter      | Kürzel      | Beschreibung                                                 |
|----------------|-------------|-------------------------------------------------------------|
| `--day`        | `-d`        | Der Tag der Aufgabe (1–25).                                 |
| `--year`       | `-y`        | Das Jahr der Aufgabe. Standardmäßig das aktuelle Jahr.      |
| `--part`       | `-p`        | Der Teil der Aufgabe (1 oder 2).                            |
| `--debug`      | `-d`        | Aktiviert Debug-Logs, die den Input und die Lösung zeigen.  |

### Beispiele

**Lösung für Tag 1, Teil 1 aus dem Jahr 2023 ausführen:**

```bash
./gradlew run --args="-d 1 -p 1 -y 2023"
```

**Debug-Modus aktivieren:**

```bash
./gradlew run --args="-d 1 -p 1 -y 2023 --debug"
```

### Registrierung von Lösungen

Lösungen werden mithilfe der Annotation `@Riddle` definiert. Diese registriert die Lösung automatisch für einen bestimmten Tag, Teil und ein Jahr.

Beispiel:

```kotlin
@Riddle(day = 1, part = 1, year = 2023)
class Day1Part1Solution : Solver {
    override fun solve(input: String): String {
        // Deine Lösung hier
        return "Lösung"
    }
}
```

Die Anwendung erkennt automatisch alle Klassen mit der Annotation `@Riddle` und führt die passende Lösung aus, basierend auf den CLI-Parametern.

### Debugging

Der Debug-Modus zeigt den aktuellen Input und das Ergebnis in der Konsole:

```bash
./gradlew run --args="-d 1 -p 1 -y 2023 --debug"
```

## 4. Weiterführende Links

- [Advent of Code](https://adventofcode.com) – Die offizielle Website von Advent of Code.
- [Kotlin](https://kotlinlang.org/) – Dokumentation zur Programmiersprache.
- [Gradle](https://gradle.org/) – Dokumentation zum Build-Tool.