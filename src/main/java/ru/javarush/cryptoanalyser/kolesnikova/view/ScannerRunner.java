package ru.javarush.cryptoanalyser.kolesnikova.view;

import java.util.Scanner;

public class ScannerRunner {
    public static void main(String[] args) {

        System.out.println("""
                �������� �����:
                1 - �������� ������
                2 - ���������� ������
                3 - ����������� ������ ������� brute force
                4 - ����������� ������ ������� ��������������� �������(� ����������)
                5 - �����
                ������� ����� ������ ����:\s"""
               );
        Scanner scanner = new Scanner(System.in);
        System.out.println("�� ������� ����� ���� � " + Integer.parseInt(scanner.nextLine()) + ", ������� ���� � �����:");
//        int numMenu = Integer.parseInt(scanner.nextLine());
    }

}
