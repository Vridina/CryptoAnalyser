package ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI;

import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;

import java.util.Scanner;

import static ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI.ConsoleApp.*;
import static ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI.Menu.*;
import static ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI.Message.*;
import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.getSizeAlfabet;

public interface ActionsMenu {

    static void goMainMenu() {
        printMainMenu();
        try {
            int numMainMenu = Integer.parseInt(new Scanner(System.in).nextLine());

            switch (numMainMenu) {
                case 1 -> encodeMessage();
                case 2 -> decodeMessage();
                case 3 -> bruteForseMessage();
                case 4 -> statAnalisMessage();
                case 5 -> ExitMessage();
                default ->   System.out.println("¬ведены некооректные щданыне");
            }
        } catch (ApplicationExceptions e) {
            System.out.println("¬ведены некооректные щданыне");
        } finally {
            goMainMenu();
        }
    }

    static String readPathScanner(String[] args, int index) {

        String pathIn = new Scanner(System.in).nextLine();
        if (!pathIn.matches("(?)")) {
            if (pathIn.matches(REGEXP_SISTEM_PATH_WINDOWS)) {
                args[index] = pathIn;
                System.out.println("–егексп прошла успешно проверка, записали путь к файлу ->" + args[index]);
            } else if (pathIn.matches("\\d")) {
                goSubMenu(pathIn);
            } else {
                ErrorMessage();
            }
        } else {
//            args[index] = ;
            System.out.println("Ѕудет использоватьс€ файл по умолчанию:" + args[index]);
        }
        return args[index];
    }


    static String readKeyScanner(String[] args, int index) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("”кажите целое в диапазоне от 0 до \" + getSizeAlfabet())");
            throw new ApplicationExceptions("”кажите целое в диапазоне от 0 до " + getSizeAlfabet());
        }
        if (scanner.hasNextInt()) {
            int pathIn = scanner.nextInt();
            if ((pathIn > 0) || (pathIn < getSizeAlfabet())) {
                args[index] = String.valueOf(pathIn);
            } else {
                ErrorMessage();
            }
        }

        return args[index];

    }


    private static void goSubMenu(String pathIn) {
        if (Integer.parseInt(pathIn) == 1) {
            goMainMenu();
        } else if (Integer.parseInt(pathIn) == 2) {
            ExitMessage();
        }
    }
}
