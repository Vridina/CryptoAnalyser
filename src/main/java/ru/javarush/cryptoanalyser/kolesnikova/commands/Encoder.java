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

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path readPathFirstFile = Action.readPathFirstFile(parameters);
        try {
            List<String> strings = Files.readAllLines(readPathFirstFile);
            String takeString = strings.get(0);
            char takeChar = takeString.charAt(0);
            int key = Integer.parseInt(parameters[2]);
            char[] alfabet = Strings.ALPHABET.toCharArray();



            // проверить содежится ли символ в алфавите
            // если да то заменить
            //заменить как - найти текущий индек полученого символа и прибавить к нему + кей, то есть по сути у меня
            // стринг Алфавитов должен быть преобразован в массив с индексами
            // если нет то ничего не делать - континуе.


            System.out.println("\n\n\n_____попытка понять v____");
            System.out.println(strings.get(0));
            System.out.println(strings.size());
            System.out.println(alfabet);


        } catch (
                IOException e) {
            throw new ApplicationExceptions("IO error", e);
        }
        return new Result(ResultCode.OK, "Файл успешно прочитан. Адрес файла: " + readPathFirstFile);




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
