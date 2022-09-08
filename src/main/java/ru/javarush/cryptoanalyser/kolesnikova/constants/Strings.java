package ru.javarush.cryptoanalyser.kolesnikova.constants;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    private static final String RU = "��������������������������������";
    private static final String EN = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "1234567890";
    private static final String SYMBOLS = " .,��\"'\\:!?+-=&@*()%";
    private static final String ALPHABET = RU + RU.toUpperCase() + EN + EN.toUpperCase() + NUMBERS + SYMBOLS;

    private static final int sizeAlfabet =  ALPHABET.toCharArray().length;

    private Strings() {
    }

    public static int getSizeAlfabet() {
        return sizeAlfabet;
    }

    public static List<Character> alphabetToList() {
        List<Character> list = new ArrayList<>();
        for (char c : ALPHABET.toCharArray()) list.add(c);
        return list;
    }
}
