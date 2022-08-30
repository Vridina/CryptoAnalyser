package ru.javarush.cryptoanalyser.kolesnikova.commands;


import ru.javarush.cryptoanalyser.kolesnikova.constants.Strings;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.commands.Commands.*;


//encode text.txt encoded.txt 111
public class Encoder implements Action {

    public static final String ROOT = PathFinder.getRoot();
    protected Path sourcePath;
    protected Path resultPath;
    protected int key;

    /// encode text.txt encoded.txt 111


    @Override
    public Result execute(String[] parameters) {
//        Path sourcePath = Path.of(ROOT + parameters[0]);
//        Path resultPath = Path.of(ROOT + parameters[1]);
//        int key = Integer.parseInt(parameters[2]);

        List<String> readFile = readFile(Path.of(ROOT + parameters[0]));
        List<String> encodeText = encodeText(Integer.parseInt(parameters[2]), readFile);
        writeFile(Path.of(ROOT + parameters[1]),encodeText);


//        List<String> str = new ArrayList<>();
////        readFile(str);
//        writeFile(str);
        return new Result(ResultCode.OK, "���� ������� ����������. ����� �����: " + sourcePath);
    }

//    private void readFile(List<String> str) {
//        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {  // ����� ������� �� ����� � ������, �������� ���������!
//            while (reader.ready()) {
//                char[] chars = reader.readLine().toCharArray(); // �������� ���� ������, ����� ������ �����
//                encodeCharAr(chars);
//                str.add(String.valueOf(chars) + "\n");  //�������� � �������  + "\n"
//            }
//        } catch (Exception e) {
//            throw new ApplicationExceptions("������ ������ �����. �������� ��� ��� :)");
//        }
//    }

//    private void writeFile(List<String> str) {
//        try (BufferedWriter writer = Files.newBufferedWriter(resultPath, StandardCharsets.UTF_8,
//                StandardOpenOption.WRITE,
//                StandardOpenOption.CREATE)) {
//            for (String s : str) {
//                writer.write(s);
//            }
//        } catch (Exception e) {
//            throw new ApplicationExceptions("�� ���� ��������� ����. =( ");
//        }
//    }

//    private void encodeCharAr(char[] chars) {
//        for (int j = 0; j < chars.length; j++) {
//            if (Strings.alphabetToList().contains(chars[j])) {
//                int sourceIndex = Strings.alphabetToList().indexOf(chars[j]);
//                int resultIndex = (sourceIndex + key) % Strings.alphabetToList().size();
//                chars[j] = Strings.alphabetToList().get(resultIndex);
//            }
//        }
//    }


}

