package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.commands.Commands.*;
import static ru.javarush.cryptoanalyser.kolesnikova.commands.Decoder.decodingText;
import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.alphabetToList;

/// BRUTE_FORSE encoded.txt brutForse.txt
public class BrutForse implements Action {

    public static final String ROOT = PathFinder.getRoot();
    public static final Path DICT_FILE_NAME = Path.of(ROOT + "dict.txt");
    public static final int CHARS_READ = 10000;
    protected static final String REGEXP = "[ .,«»\"'!:?+-=&@*()%\\\\]+";

    @Override
    public Result execute(String[] parameters) {
        Path resultPath = Path.of(ROOT + parameters[1]);
        Path sorsePart = Path.of(ROOT + parameters[0]);

        List<String> readingParOfTheFile = readingParOfTheFile(sorsePart);
        int resultKey = 1;
        for (int k = 0; k < alphabetToList().size(); k++) {
            List<String> withSpaseList = decodingTexWithSpase(k, readingParOfTheFile);
            resultKey = matchWord(k, withSpaseList);
        }

        List<String> readFile = readFile(sorsePart);
        List<String> encodeText = decodingText(resultKey, readFile);
        writeFile(resultPath, encodeText);


        return new Result(ResultCode.OK, "Внимание! Файл успешно декодирован. Адрес файла: " + resultPath + ". Подобран ключ: " + resultKey);
    }

    private int matchWord(int k, List<String> withSpaseList) {
        System.out.println("проверка ключа ->>>>" + k);
        int resultKey = 0;
        List<String> dictionary = readFileDict(DICT_FILE_NAME);
        List<String> split = new ArrayList<>();
        int matchWithTheDictionary = 0;
        int allSizeString = 0;
        for (String s : withSpaseList
        ) {
            split = List.of(s.split(REGEXP));
//            System.out.println(split);
            for (String sourseSplit : split    // поиск совпадений
            ) {
                allSizeString = allSizeString + split.size();
                for (String wordDictionary : dictionary
                ) {
                    boolean contains = sourseSplit.equalsIgnoreCase(wordDictionary);
                    if (contains) matchWithTheDictionary++;
                }
                allSizeString = allSizeString + sourseSplit.length();
            }

        }
//        System.out.println("сумма совпадений " + matchWithTheDictionary + "слов всего " + allSizeString);

        System.out.println(allSizeString);

        if (matchWithTheDictionary > allSizeString / 3) {
            System.out.println(split);
            System.out.printf("Было найдено %d совпадений слов со словарем (из %d слов). Ключ равен %d ", matchWithTheDictionary, split.size(), k);
            resultKey = k;
            System.out.println("мач норм -> " + resultKey);
        } else {
            resultKey = -1;
//            System.out.println("плохо! -> " + resultKey);
        }


        return resultKey;
    }

    private List<String> readingParOfTheFile(Path sourcePath) {
//        checkingTheFileType(sourcePath); TODO
        List<String> sourceList = new ArrayList<>();


//        try {
//           Files.readString(sourcePath, StandardCharsets.UTF_8).filter(x -> )



        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {
            int x = 0;
            while (reader.ready() && x < CHARS_READ) { //
                sourceList.add(reader.readLine() + "\n");
                for (String s : sourceList
                ) {
                    char[] chars = s.toCharArray();
                    x += chars.length;
                }
            }
        } catch (Exception e) {
            throw new ApplicationExceptions("Ошибка чтения файла для подбора ключа. Попробуйте еще разок.");
        }
        System.out.println(sourceList);
        return sourceList;
    }


    private static List<String> decodingTexWithSpase(int key, List<String> strings) {
        List<String> listResult = new ArrayList<>();
        int charsSpase = 0;


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
                    if (chars[j] == ' ') charsSpase++;
                }
            }
            if (charsSpase > 0) listResult.add(String.valueOf(chars));
        }
        return listResult;
    }


}
