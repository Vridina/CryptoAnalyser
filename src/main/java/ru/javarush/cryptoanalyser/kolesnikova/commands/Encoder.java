package ru.javarush.cryptoanalyser.kolesnikova.commands;


import ru.javarush.cryptoanalyser.kolesnikova.constants.Strings;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.commands.Commands.*;
import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.alphabetToList;

/// encode text.txt encoded.txt 111

public class Encoder implements Action {

    public static final String ROOT = PathFinder.getRoot();

    @Override
    public Result execute(String[] parameters) {
        Path resultPath = Path.of(ROOT + parameters[1]);
        List<String> readFile = readFile(Path.of(ROOT + parameters[0]));
        List<String> encodeText = encodingText(Integer.parseInt(parameters[2]), readFile);
        writeFile(resultPath, encodeText);
        return new Result(ResultCode.OK, "Файл успешно зашифрован. Адрес файла: " + resultPath);
    }

    public static List<String> encodingText(int key, List<String> strings) {
//        checkingTheKey(key);
        List<String> listResult = new ArrayList<>();
        for (String s : strings
        ) {
//            char[] chars = new char[s.toCharArray().length];
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (alphabetToList().contains(chars[j])) {
                    int sourceIndex = alphabetToList().indexOf(chars[j]);
                    int resultIndex = (sourceIndex + key) % alphabetToList().size();
                    chars[j] = alphabetToList().get(resultIndex);
                }
            }
            listResult.add(String.valueOf(chars));
        }
        return listResult;
    }
}










