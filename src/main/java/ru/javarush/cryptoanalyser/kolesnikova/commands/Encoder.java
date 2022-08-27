package ru.javarush.cryptoanalyser.kolesnikova.commands;


import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.ALPHABET;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path pathFirstFile = Action.readPathFirstFile(parameters);
        try {
            List<String> strings = Files.readAllLines(pathFirstFile); // ��������� � ������ ������ �����
            int key = Integer.parseInt(parameters[2]);

//            Path pathResaltFile = Path.of(PathFinder.getRoot() + "dfdf");
//            System.out.println(pathResaltFile);

//            Files.createFile(pathResaltFile);


            for (int i = 0; i < strings.size(); i++) {
                String takeString = strings.get(i);
                System.out.println("������ � " + i + " : " + takeString);
                char[] takeCharAr = takeString.toCharArray();
                for (int j = 0; j < takeCharAr.length; j++) {
                    if (ALPHABET.contains(Character.toLowerCase(takeCharAr[j]))) {  // �������� ������� �� ������� � ��������
                        int IndexSymbol = ALPHABET.indexOf(Character.toLowerCase(takeCharAr[j])); // �������  ������ �������� ������ � ��������
                        int resaltIndex = (IndexSymbol + key) % ALPHABET.size(); // ������� ����� ����� ������� ��� ���������� �������
                        takeCharAr[j] = ALPHABET.get(resaltIndex); // ������� ������������� ������
//                        Files.write(pathResaltFile, takeCharAr.);
                    }
                }

//                Path pathResaltFile = Path.of(parameters[2]);
//                Files.createFile(pathResaltFile);


//                System.out.println(takeCharAr);
            }
        } catch (
                IOException e) {
            throw new ApplicationExceptions("IO error", e);
        }


        return new Result(ResultCode.OK, "���� ������� ��������. ����� �����: " + pathFirstFile);


        // TODO - ���������� ��������� �����, ������ � �� ����� ��� ����������
        // TODO - ���������� ��� ������, ���� ������� ��� � ��������

    }

}
