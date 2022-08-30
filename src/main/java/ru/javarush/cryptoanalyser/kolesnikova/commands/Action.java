package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;


import java.nio.file.Path;
import java.util.Arrays;


public interface Action {


    Result execute(String[] parameters);


}
