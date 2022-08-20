package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;


import java.nio.file.Path;


public interface Action {


    Result execute(String[] parameters);

    static Path readPathFirstFile(String[] parameters) {
        String txtfile = parameters[0];
        return Path.of(PathFinder.getRoot() + txtfile);
    }



}
