package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Encoder implements Action{
    @Override
    public Result execute (String[] parameters){
        String txtfile = parameters[0];
        String encryptydFile = parameters[0];
        Path path = Path.of(PathFinder.getRoot() + txtfile);
        try {
            List<String> strings = Files.readAllLines(path);
        } catch (IOException e) {
            throw new ApplicationExceptions("IO error", e);
        }
        return new Result(ResultCode.OK, "���� ��������" + path);

//        return null;
    }

}
