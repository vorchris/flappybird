# Gedankengänge zu Flappy Bird in JavaFX

## Allgemeine Designentscheidungen
- Einsatz von JavaFX für UI und Animationen.
- Trennung von Logik und Darstellung mittels FXML.
- Modulares Design für leichte Erweiterbarkeit und Wartung.

## `Application` Klasse
- Einstiegspunkt des Spiels.
- Initialisiert die Hauptbühne (`Stage`) und Szene (`Scene`).
- Lädt FXML für UI Layout.
- Registriert Tastatur-Handler für Spielersteuerung.

## `Controller` Klasse
- Zentrale Spielsteuerung und Event-Handling.
- Verwaltet Animationen und Spiellogik (Start, Ende).
- Initialisiert Spielkomponenten und startet Spiel-Loop.
- Verwaltet UI-Elemente wie Score, Game Over Screen.

## `Data` Klasse
- Sammelpunkt für Spielkonfigurationen und Ressourcenpfade.
- Statische innere Klassen für Bilder und Spieleinstellungen.

## `Pipe` Klasse
- Darstellung einzelner Hindernisse (Rohre).
- Kollisionsdetektion mit dem Spieler.
- Dynamische Höhen und Öffnungen für Herausforderung.

## `PipeMover` Klasse
- Verwaltet und animiert alle Rohre auf dem Bildschirm.
- Recycling von Rohren zur Performance-Optimierung.
- Verfolgt und aktualisiert den Spieler-Score.

## `Player` Klasse
- Repräsentiert den Spielercharakter (den Vogel).
- Behandelt Eingaben für das Springen.
- Simuliert Schwerkraft für realistische Bewegung.
- Zurücksetzen der Spielerposition bei Neustart.

## Schlussfolgerung
- Ziel: Ein einfaches, intuitives Spiel, das herausfordernd und unterhaltsam ist.
- Design unterstützt einfache Anpassungen und Feature-Erweiterungen.
