package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.constants.Strings;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Commands {

    public static List<String> readFile(Path sourcePath) {
//        checkingTheFileType(sourcePath);
        List<String> sourceList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {  // делаю вычитку из файла в буффер, указываю КОДИРОВКУ!
            while (reader.ready()) {
                sourceList.add(reader.readLine() + "\n");
            }
        } catch (Exception e) {
            throw new ApplicationExceptions("Неизвестная ошибка чтения файла. Попробуйте еще раз.");
        }
        return sourceList;
    }


    public static void writeFile(Path resultPath, List<String> resultString) {
//        checkingTheFileType(resultPath);
        try (BufferedWriter writer = Files.newBufferedWriter(resultPath, StandardCharsets.UTF_8,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE)) {
            for (String s : resultString) {
                writer.write(s);
            }
        } catch (Exception e) {
            throw new ApplicationExceptions("Не могу сохранить файл. =( ");
        }

    }


    private static void checkingTheFileType(Path sourcePath) {
        String fileName = String.valueOf(sourcePath.getFileName());
        if (!(fileName.contains("\\.txt$"))) {
            throw new ApplicationExceptions("Файл неверного формата - необходим .txt файл.");
        }
    }

    private static void checkingTheKey(int key) {
        if (key > Strings.alphabetToList().size() || key < 0) {
            throw new ApplicationExceptions("Дорогой друг, будь добр как бобр и введи ключ от 0 до " + Strings.alphabetToList().size() + ". Шифруем файл правильно.");
        }
    }


    public static List<String> encodeText(int key, List<String> strings) {
        checkingTheKey(key);
        List<String> listResult = new ArrayList<>();
        for (String s : strings
        ) {
//            char[] chars = new char[s.toCharArray().length];
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (Strings.alphabetToList().contains(chars[j])) {
                    int sourceIndex = Strings.alphabetToList().indexOf(chars[j]);
                    int resultIndex = (sourceIndex + key) % Strings.alphabetToList().size();
                    chars[j] = Strings.alphabetToList().get(resultIndex);
                }
//                listResult.add(String.valueOf(chars));
            }
            listResult.add(String.valueOf(chars));
        }
        return listResult;
    }

}
