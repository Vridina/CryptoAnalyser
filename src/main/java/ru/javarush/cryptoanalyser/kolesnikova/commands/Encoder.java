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

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path readPathFirstFile = Action.readPathFirstFile(parameters);
        try {
            List<String> strings = Files.readAllLines(readPathFirstFile);
            String takeString = strings.get(0);
            char takeChar = takeString.charAt(0);
            int key = Integer.parseInt(parameters[2]);
            char[] alfabet = Strings.ALPHABET.toCharArray();



            // ��������� ��������� �� ������ � ��������
            // ���� �� �� ��������
            //�������� ��� - ����� ������� ����� ���������� ������� � ��������� � ���� + ���, �� ���� �� ���� � ����
            // ������ ��������� ������ ���� ������������ � ������ � ���������
            // ���� ��� �� ������ �� ������ - ��������.


            System.out.println("\n\n\n_____������� ������ v____");
            System.out.println(strings.get(0));
            System.out.println(strings.size());
            System.out.println(alfabet);


        } catch (
                IOException e) {
            throw new ApplicationExceptions("IO error", e);
        }
        return new Result(ResultCode.OK, "���� ������� ��������. ����� �����: " + readPathFirstFile);




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
