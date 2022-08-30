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
        readingParOfTheFile(Path.of(ROOT + parameters[0]));
        List<String> dictionary = readFile(DICT_FILE_NAME);


        return new Result(ResultCode.OK, "Внимание! Файл успешно декодирован. Адрес файла: " + resultPath + ". Подобран ключ: ");
    }


    private List<String> readingParOfTheFile(Path sourcePath) {
//        checkingTheFileType(sourcePath);
        List<String> sourceList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {
            int x = 0;
            while (reader.ready() && x < CHARS_READ) {
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
        return sourceList;
    }

    private List<String> allResaltOfcheckingKey_ONE (List<String> patrStrings) {
        List<String> stringListFoCheck = new ArrayList<>();
        for (int checkingKey = 0; checkingKey < alphabetToList().size(); checkingKey++) {
            stringListFoCheck = decodingText(checkingKey, patrStrings);
        }
        return stringListFoCheck;
    }


    private void findSpase (List<String> patrStrings) {

//        return stringListFoCheck;
    }


    private int searcKey(char[] chars) {
        int resultKey = 0;
        for (int checkNewKey = 0; checkNewKey <= alphabetToList().size(); checkNewKey++) {
            int charsSpase = 0;                                                                        // подбираю ключ
            char[] charsResult = new char[chars.length];
            for (int j = 0; j < chars.length; j++) {                                           // цикл по чарам
                if (alphabetToList().contains(chars[j])) {
                    int sourceIndex = alphabetToList().indexOf(chars[j]);                   // если да то получаем индекс чара
                    int resultIndex = (sourceIndex - checkNewKey) < 0 ?
                            (alphabetToList().size() + sourceIndex - checkNewKey) % alphabetToList().size() :
                            (Math.abs(sourceIndex - checkNewKey)) % alphabetToList().size();
                    charsResult[j] = alphabetToList().get(resultIndex);                             //получаем значение итогового чара
                }
                if (charsResult[j] == ' ') charsSpase++;
            }
            if (charsSpase > 0) {
                var split = List.of(String.valueOf(charsResult).split(REGEXP));
//                resultKey = lookForMatch(checkNewKey, split, dictionary);// поиск ключа
            }
        }
        return resultKey;
    }


    private static int lookForMatch(int keyForVerification, List<String> split, List<String> dictionary) {
        int matchWithTheDictionary = 0;
        for (String sourseSplit : split    // поиск совпадений
        ) {
            for (String wordDictionary : dictionary
            ) {
                boolean contains = sourseSplit.equalsIgnoreCase(wordDictionary);
                if (contains) matchWithTheDictionary++;
            }
        }
        if (matchWithTheDictionary > split.size() / 3) {
            System.out.println(split);
            System.out.printf("Было найдено %d совпадений слов со словарем (из %d слов). Ключ равен %d ", matchWithTheDictionary, split.size(), keyForVerification);
        }
        return keyForVerification;
    }


}
