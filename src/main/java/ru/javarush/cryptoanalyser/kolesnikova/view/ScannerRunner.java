package ru.javarush.cryptoanalyser.kolesnikova.view;

import java.util.Scanner;

public class ScannerRunner {
    public static void main(String[] args) {

        System.out.println("""
                Выберите опцию:
                1 - шифровка текста
                2 - дефшифрока текста
                3 - расшифровка текста методом brute force
                4 - расшифровка текста методом статистического анализа(в разработке)
                5 - выход
                Введите номер пункта меню:\s"""
               );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы выбрали пункт меню № " + Integer.parseInt(scanner.nextLine()) + ", укажите путь к файлу:");
//        int numMenu = Integer.parseInt(scanner.nextLine());
    }

}
