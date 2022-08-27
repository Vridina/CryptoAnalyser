package ru.javarush.cryptoanalyser.kolesnikova.commands;


import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.ALPHABET;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path pathFirstFile = Action.readPathFirstFile(parameters);
        try {
            List<String> strings = Files.readAllLines(pathFirstFile); // записываю в массив строки файла
            int key = Integer.parseInt(parameters[2]);

//            Path pathResaltFile = Path.of(PathFinder.getRoot() + "dfdf");
//            System.out.println(pathResaltFile);

//            Files.createFile(pathResaltFile);


            for (int i = 0; i < strings.size(); i++) {
                String takeString = strings.get(i);
                System.out.println("—трока є " + i + " : " + takeString);
                char[] takeCharAr = takeString.toCharArray();
                for (int j = 0; j < takeCharAr.length; j++) {
                    if (ALPHABET.contains(Character.toLowerCase(takeCharAr[j]))) {  // провер€ю символы на наличии в алфавите
                        int IndexSymbol = ALPHABET.indexOf(Character.toLowerCase(takeCharAr[j])); // получаю  индекс искомого сивола в алфавите
                        int resaltIndex = (IndexSymbol + key) % ALPHABET.size(); // получаю новый идекс символа дл€ шифровани€ символа
                        takeCharAr[j] = ALPHABET.get(resaltIndex); // получаю зашифрованный символ
//                        Files.write(pathResaltFile, takeCharAr.);
                    }
                }

//                Path pathResaltFile = Path.of(parameters[2]);
//                Files.createFile(pathResaltFile);


//                System.out.println(takeCharAr);
            }
        } catch (
                IOException e) {
            throw new ApplicationExceptions("IO error", e);
        }


        return new Result(ResultCode.OK, "‘айл успешно прочитан. јдрес файла: " + pathFirstFile);


        // TODO - доработать заглавные буквы, сейчас € их тер€ю при шифровании
        // TODO - доработать что делать, если символа нет в алфавите

    }

}
