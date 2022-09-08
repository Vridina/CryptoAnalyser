package ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI;

import java.util.Arrays;

import static ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI.ActionsMenu.*;
import static ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI.ActionsMenu.readPathScanner;
import static ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI.Message.*;

public class Menu implements Message, ActionsMenu {



    static void encodeMessage() {
        /// encode text.txt encoded.txt 3
        String[] args = new String[3];

        for (int i = 0; i < 2; i++) {
            System.out.println("_____________");
            System.out.println(Arrays.toString(encodeMessage[i]));
            submenu();
            args[i] = readPathScanner(args,i);
        }
        System.out.println("_____________");
        int index2 = 2;
        System.out.println(Arrays.toString(encodeMessage[index2]));
        submenu();
        args[index2] = readKeyScanner(args,index2);
        System.out.print("Мы получили во ттак массив ->");
        System.out.println(args);



//        args[0] = "encode"; // слить !
    }











}
