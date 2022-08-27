package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;


import java.nio.file.Path;
import java.util.Arrays;


public interface Action {


    Result execute(String[] parameters);

    static Path readPathFirstFile(String[] parameters) {
        //  encode text.txt encoded.txt 22
        String txtFile = parameters[0];

        Arrays.stream(parameters).forEach(System.out::println);
        System.out.println(txtFile);
        return Path.of(PathFinder.getRoot() + txtFile);

    }



}
