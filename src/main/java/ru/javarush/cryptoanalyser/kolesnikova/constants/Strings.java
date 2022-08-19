package ru.javarush.cryptoanalyser.kolesnikova.constants;

public class Strings {
    private static final String RU = "אבגדהו¸זחטיךכלםמןנסעףפץצקרשתûü‎‏ÿ";
    private static final String EN = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = ".,«»\"'\\:!? +-=&@*() ";
    public static final String ALPHABET = RU + RU.toUpperCase() + EN + EN.toUpperCase() + SYMBOLS + NUMBERS;


}
