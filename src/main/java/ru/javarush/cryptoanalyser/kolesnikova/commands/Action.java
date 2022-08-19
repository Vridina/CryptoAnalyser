package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;

public interface Action {


    Result execute(String[] parameters);
}
