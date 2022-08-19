package ru.javarush.cryptoanalyser.kolesnikova.app;

import ru.javarush.cryptoanalyser.kolesnikova.controller.MainController;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;

import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }


    public Result run(String[] args) {

        String command = args[0]; //encode
        String[] parameters = Arrays.copyOfRange(args, 1 ,args.length); //text.txt encoded.txt 45
        return mainController.execute(command,parameters);
    }
}
