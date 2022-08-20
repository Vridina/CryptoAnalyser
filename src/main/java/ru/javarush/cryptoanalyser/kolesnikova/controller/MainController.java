package ru.javarush.cryptoanalyser.kolesnikova.controller;

import ru.javarush.cryptoanalyser.kolesnikova.commands.Action;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;

public class MainController {

    public Result execute(String command, String[] parameters) {
        try {
            Action action = Fabric.find(command);
            return action.execute(parameters);
        } catch (ApplicationExceptions e) {
            return new Result(ResultCode.ERROR, "e.getMessage");
        }
    }
}
