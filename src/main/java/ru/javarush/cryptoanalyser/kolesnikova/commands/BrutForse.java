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
    public static final int CHARS_READ = 20000;
    protected static final String REGEXP = "[ \n.,«»\"'!:?+-=&@*()%\\\\]+";

    @Override
    public Result execute(String[] parameters) {
        Path resultPath = Path.of(ROOT + parameters[1]);
        Path sorsePart = Path.of(ROOT + parameters[0]);
        List<String> readingParOfTheFile = readingParOfTheFile(sorsePart);
        int resultKey = 0;
        for (int k = 0; k < alphabetToList().size(); k++) {
            System.out.println("Ключ равен - " + k);
            List<String> decodingText = decodingText(k, readingParOfTheFile);
            if (matchWord(decodingText)) {
                resultKey = k;
            }
        }
        if (resultKey == 0) {
            System.out.println("Ключ не найден.");
            throw new ApplicationExceptions("Ключ не найден.");
        }
        List<String> readFile = readFile(sorsePart);
        List<String> encodeText = decodingText(resultKey, readFile);
        writeFile(resultPath, encodeText);
        return new
                Result(ResultCode.OK, "Внимание! Файл успешно декодирован. Адрес файла: " + resultPath + ". Подобран ключ: " + resultKey);

    }

    private boolean matchWord(List<String> decodingText) {
        int numberOfWords = 0;
        int maxMatch = 0;
        int numberOfMatches = 0;
        List<String> dictionary = readFileDict(DICT_FILE_NAME);
        for (String s : decodingText
        ) {
            List<String> split = List.of(s.split(REGEXP));
            for (String sourseSplit : split    // поиск совпадений
            ) {
                numberOfWords++;
                for (String wordDictionary : dictionary
                ) {
                    if (sourseSplit.equalsIgnoreCase(wordDictionary)) {
                        numberOfMatches++;
                    }
                }
            }
            if (maxMatch < numberOfMatches) {
                maxMatch = numberOfMatches;
            }
        }
        System.out.printf("Максимумум матчей %d, а максимум слов %d\n", maxMatch, numberOfWords);
        return (maxMatch > numberOfWords / 10);
    }

    private List<String> readingParOfTheFile(Path sourcePath) {
//        checkingTheFileType(sourcePath); TODO
        List<String> sourceList = new ArrayList<>();
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
        return sourceList;
    }
}
