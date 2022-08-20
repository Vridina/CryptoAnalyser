package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.constants.Strings;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.ALPHABET;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path readPathFirstFile = Action.readPathFirstFile(parameters);
        try {
            List<String> strings = Files.readAllLines(readPathFirstFile);
            int key = Integer.parseInt(parameters[2]);
            for (int i = 0; i < strings.size(); i++) {
                String takeString = strings.get(i);
//                System.out.println("Строка № " + i + " : " + takeString);
                char[] takeCharAr = takeString.toCharArray();
                for (int j = 0; j < takeCharAr.length; j++) {
                    if (ALPHABET.contains(Character.toLowerCase(takeCharAr[j]))) {
                        int IndexSymbol = ALPHABET.indexOf(Character.toLowerCase(takeCharAr[j]));
                        int resaltIndex = (IndexSymbol + key) % ALPHABET.size();
                        takeCharAr[j] = ALPHABET.get(resaltIndex);
                    }
                }
//                System.out.println(takeCharAr);
            }
        } catch (
                IOException e) {
            throw new ApplicationExceptions("IO error", e);
        }
        return new Result(ResultCode.OK, "Файл успешно прочитан. Адрес файла: " + readPathFirstFile);


//                    ПОДНЯТЬ ДО ТОГО КАК МЕНЯЮ СИМВОЛЫ vvvvv
//                    System.out.println("Вот это есть в алфавите ->  " + symbols);
//                    System.out.println("Старый индекс(IndexSymbol) ->" + IndexSymbol);
//                    System.out.println("НОВЫЙ индекс(resaltIndex)->" + resaltIndex);
//                    System.out.println("Новый символ теперь это --- " + symbols);
//                    System.out.println("_________________");


//            }
        // TODO - доработать заглавные буквы, сейчас я их теряю при шифровании
        // TODO - доработать что делать, если символа нет в алфавите
        // я одна мега тупая и ничо не понимаюююююююююююююююю, ааааааааааааааааа!!! почему так сложно)))))
        // и эта тема по потоам меня УБИВАЕТ
        // проверить содежится ли символ в алфавите
        // если да то заменить
        //заменить как - найти текущий индек полученого символа и прибавить к нему + кей, то есть по сути у меня
        // стринг Алфавитов должен быть преобразован в массив с индексами
        // если нет то ничего не делать - континуе.

//
//            System.out.println("\n\n\n_____попытка понять v____");
//            System.out.println(strings.get(0));
//            System.out.println(strings.size());
//            System.out.println("Длина алфавита " + ALPHABET.size());
////            System.out.println(alfabet);

        /*
        1. чтение пути файла - метод - ок
        2. кодирование файла
        3. возврат файла как результат


//        String txtfile = parameters[0];
//        String encryptydFile = parameters[0];
//        Path path = Path.of(PathFinder.getRoot() + txtfile);
        */
    }

}
