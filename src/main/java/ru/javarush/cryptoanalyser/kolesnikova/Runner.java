package ru.javarush.cryptoanalyser.kolesnikova;

import ru.javarush.cryptoanalyser.kolesnikova.app.Application;
import ru.javarush.cryptoanalyser.kolesnikova.controller.MainController;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI.ConsoleApp;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController(); //encode text.encoded.txt 45
        Application application = new Application(mainController);
//        args = ConsoleApp.main();
        Result result = application.run(args);
        System.out.println(result);
    }
}
