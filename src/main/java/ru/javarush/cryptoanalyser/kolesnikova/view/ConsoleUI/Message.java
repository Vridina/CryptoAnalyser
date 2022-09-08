package ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI;

import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.getSizeAlfabet;

public interface Message {

    public static final String REGEXP_SISTEM_PATH_WINDOWS = "([a-zA-Z]:)?(.*)\\\\([a-zA-Z\\d�-��-�]+.txt$)";
    String[][] encodeMessage = new String[][]{
            {"ENCODE",
"""
�� ������� ����� ���� � 1 - ���������� ������ ������� ������.

������� ������ ���� � �����, ������� �� ������ �����������, ��� ������� Enter ��� ������ ����� �� ���������.
---�� ��������� ������������ ���� ������� "\\text\\text.txt\\"
""",
"""
������� ������ ���� � ����� ��� ���������� ����� � �����������." +
---�� ��������� ������������ ����� ������� \\"\\\\text\\\\encoded.txt\\"
""",
"������� ����, �������� �������� �� 1 �� " + getSizeAlfabet(),
"""
���� ������� ����������.
"""}
    };


/// encode        text.txt             encoded.txt           3
/// DECOdE        encoded.txt           decode.txt           5
/// BRUTE_FORSE   encoded.txt            brutForse.txt
/// stat_analis   exampltext.txt          encode.txt        statanalis.txt


    String[][] pathDefaultTxt = new String[][]{
            {"ENCODE", "text.txt", "encoded.txt"},
            {"DECODE", "encoded.txt", "decode.txt"},
            {"BRUTE_FORSE", "encoded.txt", "brutForse.txt"},
            {"STAT_ANALIS", "exampltext.txt", "encode.txt", "statanalis.txt"},
    };


    static void printMainMenu() {
        System.out.println("""
                �������� �����:
                1 - �������� ������
                2 - ���������� ������
                3 - ����������� ������ ������� ������(brute force)
                4 - ����������� ������ ������� ��������������� �������(� ����������)
                5 - �����
                \n ������� ����� ������ ���� � ������� Enter:\s"""
        );
    }

    static void submenu() {
        System.out.println("""
                \n1 - � ������� ����
                2 - �����
                \n"""
        );

    }


}
