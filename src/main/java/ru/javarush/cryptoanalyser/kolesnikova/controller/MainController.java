package ru.javarush.cryptoanalyser.kolesnikova.controller;

import ru.javarush.cryptoanalyser.kolesnikova.commands.Action;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;

public class MainController {

    public Result execute(String command, String[] parameters) {

        Action action= Fabric.find(command);
        return action.execute(parameters);
    }
}
