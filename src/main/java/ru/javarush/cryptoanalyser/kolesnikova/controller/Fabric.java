package ru.javarush.cryptoanalyser.kolesnikova.controller;

import ru.javarush.cryptoanalyser.kolesnikova.commands.Action;
import ru.javarush.cryptoanalyser.kolesnikova.commands.BrutForse;
import ru.javarush.cryptoanalyser.kolesnikova.commands.Decoder;
import ru.javarush.cryptoanalyser.kolesnikova.commands.Encoder;

public enum Fabric {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTE_FORSE(new BrutForse());

    private final Action action;

    Fabric(Action action) {
        this.action = action;
    }

    static Action find(String command) {
        return Fabric.valueOf(command.toUpperCase()).action;
    }
}
