package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.alphabetToList;

public class BrutForse implements Action {


    public static final String ROOT = PathFinder.getRoot();
    protected Path sourcePath; // входящий зашифрованный файл
    protected Path resultPath; // исходящий файл расшированный
    protected int key; // неизвестен, нужно подобрать и вывести на экран

    protected static final String regex = "[ .,«»\"'!:?+-=&@*()%\\\\]+";


    /// BRUTE_FORSE encoded.txt brutForse.txt


    @Override
    public Result execute(String[] parameters) {
        sourcePath = Path.of(ROOT + parameters[0]);
        resultPath = Path.of(ROOT + parameters[1]);
        readFile10000();


        return new Result(ResultCode.OK, "Файл успешно декодирован. Адрес файла: " + resultPath + ". Подобран ключ: " + key);

    }


    private void readFile10000() {
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {     // делаю вычитку из файла в буффер, указываю КОДИРОВКУ!
            int x = 0;
            while (reader.ready() && x < 10000) {
                char[] chars = reader.readLine().toCharArray();                                           // считываю ОДНУ строку, делаю массив чаров
                x += chars.length;
                key = searcKey(chars);
//                strings.add(reader.readLine() + "\n");                //добавляю в стринги + "\n"
            }
        } catch (Exception e) {
            throw new ApplicationExceptions("Ошибка чтения файла. Попробуй еще раз :)");
        }
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
                var split = List.of(String.valueOf(charsResult).split(regex));
                resultKey = lookForMatch(checkNewKey, split, readFileDictionary());// поиск ключа
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


    private static List<String> readFileDictionary() {
        List<String> dictionary;
        try {
            dictionary = Files.readAllLines(Path.of("D:\\Java\\_workProject\\Testing\\dict.txt"), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new ApplicationExceptions("Ошибка при чтении словаря " + e);
        }
        return dictionary;
    }


}
