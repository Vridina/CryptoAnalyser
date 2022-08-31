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
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {
            while (reader.ready()) {
                sourceList.add(reader.readLine() + "\n");
            }
        } catch (Exception e) {
            throw new ApplicationExceptions("Неизвестная ошибка чтения файла. Попробуйте еще раз.");
        }
        return sourceList;
    }


    public static List<String> readFileDict(Path sourcePath) {
//        checkingTheFileType(sourcePath);
        List<String> sourceList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {
            while (reader.ready()) {
                sourceList.add(reader.readLine());
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





}
