package ru.javarush.cryptoanalyser.kolesnikova;

import ru.javarush.cryptoanalyser.kolesnikova.app.Application;
import ru.javarush.cryptoanalyser.kolesnikova.controller.MainController;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController(); //encode text.encoded.txt 45
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);
    }
}
