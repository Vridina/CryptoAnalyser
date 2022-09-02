package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.commands.Commands.*;
import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.alphabetToList;


/// DECOdE encoded.txt decode.txt 5
public class Decoder implements Action {
    public static final String ROOT = PathFinder.getRoot();

    @Override
    public Result execute(String[] parameters) {
        Path resultPath = Path.of(ROOT + parameters[1]);
        List<String> readFile = readFile(Path.of(ROOT + parameters[0]));
        List<String> encodeText = decodingText(Integer.parseInt(parameters[2]), readFile);
        writeFile(resultPath, encodeText);
        return new Result(ResultCode.OK, "Файл успешно расшифрован. Адрес файла: " + resultPath);
    }

    public static List<String> decodingText(int key, List<String> strings) {
        List<String> listResult = new ArrayList<>();
        for (String s : strings
        ) {
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (alphabetToList().contains(chars[j])) {
                    int sourceIndex = alphabetToList().indexOf(chars[j]);
                    int resultIndex = (sourceIndex - key) < 0 ?
                            (alphabetToList().size() + sourceIndex - key) % alphabetToList().size() :
                            (Math.abs(sourceIndex - key)) % alphabetToList().size();
                    chars[j] = alphabetToList().get(resultIndex);
                }
            }
            listResult.add(String.valueOf(chars));
        }
        return listResult;
    }
}
