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
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {  // ����� ������� �� ����� � ������, �������� ���������!
            while (reader.ready()) {
                sourceList.add(reader.readLine() + "\n");
            }
        } catch (Exception e) {
            throw new ApplicationExceptions("����������� ������ ������ �����. ���������� ��� ���.");
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
            throw new ApplicationExceptions("�� ���� ��������� ����. =( ");
        }

    }


    private static void checkingTheFileType(Path sourcePath) {
        String fileName = String.valueOf(sourcePath.getFileName());
        if (!(fileName.contains("\\.txt$"))) {
            throw new ApplicationExceptions("���� ��������� ������� - ��������� .txt ����.");
        }
    }

    private static void checkingTheKey(int key) {
        if (key > Strings.alphabetToList().size() || key < 0) {
            throw new ApplicationExceptions("������� ����, ���� ���� ��� ���� � ����� ���� �� 0 �� " + Strings.alphabetToList().size() + ". ������� ���� ���������.");
        }
    }





}
