package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.constants.Strings;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.ALPHABET;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path readPathFirstFile = Action.readPathFirstFile(parameters);
        try {
            List<String> strings = Files.readAllLines(readPathFirstFile);
            int key = Integer.parseInt(parameters[2]);
            for (int i = 0; i < strings.size(); i++) {
                String takeString = strings.get(i);
//                System.out.println("������ � " + i + " : " + takeString);
                char[] takeCharAr = takeString.toCharArray();
                for (int j = 0; j < takeCharAr.length; j++) {
                    if (ALPHABET.contains(Character.toLowerCase(takeCharAr[j]))) {
                        int IndexSymbol = ALPHABET.indexOf(Character.toLowerCase(takeCharAr[j]));
                        int resaltIndex = (IndexSymbol + key) % ALPHABET.size();
                        takeCharAr[j] = ALPHABET.get(resaltIndex);
                    }
                }
//                System.out.println(takeCharAr);
            }
        } catch (
                IOException e) {
            throw new ApplicationExceptions("IO error", e);
        }
        return new Result(ResultCode.OK, "���� ������� ��������. ����� �����: " + readPathFirstFile);


//                    ������� �� ���� ��� ����� ������� vvvvv
//                    System.out.println("��� ��� ���� � �������� ->  " + symbols);
//                    System.out.println("������ ������(IndexSymbol) ->" + IndexSymbol);
//                    System.out.println("����� ������(resaltIndex)->" + resaltIndex);
//                    System.out.println("����� ������ ������ ��� --- " + symbols);
//                    System.out.println("_________________");


//            }
        // TODO - ���������� ��������� �����, ������ � �� ����� ��� ����������
        // TODO - ���������� ��� ������, ���� ������� ��� � ��������
        // � ���� ���� ����� � ���� �� ����������������������, �����������������!!! ������ ��� ������)))))
        // � ��� ���� �� ������ ���� �������
        // ��������� ��������� �� ������ � ��������
        // ���� �� �� ��������
        //�������� ��� - ����� ������� ����� ���������� ������� � ��������� � ���� + ���, �� ���� �� ���� � ����
        // ������ ��������� ������ ���� ������������ � ������ � ���������
        // ���� ��� �� ������ �� ������ - ��������.

//
//            System.out.println("\n\n\n_____������� ������ v____");
//            System.out.println(strings.get(0));
//            System.out.println(strings.size());
//            System.out.println("����� �������� " + ALPHABET.size());
////            System.out.println(alfabet);

        /*
        1. ������ ���� ����� - ����� - ��
        2. ����������� �����
        3. ������� ����� ��� ���������


//        String txtfile = parameters[0];
//        String encryptydFile = parameters[0];
//        Path path = Path.of(PathFinder.getRoot() + txtfile);
        */
    }

}
