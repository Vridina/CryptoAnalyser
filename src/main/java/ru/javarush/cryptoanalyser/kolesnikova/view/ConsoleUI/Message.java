package ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI;

import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.getSizeAlfabet;

public interface Message {

    public static final String REGEXP_SISTEM_PATH_WINDOWS = "([a-zA-Z]:)?(.*)\\\\([a-zA-Z\\dа-яА-Я]+.txt$)";
    String[][] encodeMessage = new String[][]{
            {"ENCODE",
"""
Вы выбрали пункт меню № 1 - шифрование текста методом Цезаря.

Укажите полный путь к файлу, который вы хотите зашифровать, или нажмите Enter для выбора файла по умолчанию.
---по умолчанию используется файл проекта "\\text\\text.txt\\"
""",
"""
Укажите полный путь к папке для сохранения файла с шифрованием." +
---по умолчанию используется папка проекта \\"\\\\text\\\\encoded.txt\\"
""",
"Укажите ключ, диапазон значений от 1 до " + getSizeAlfabet(),
"""
Файл успешно зашифрован.
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
                Выберите опцию:
                1 - шифровка текста
                2 - дефшифрока текста
                3 - расшифровка текста методом Взлома(brute force)
                4 - расшифровка текста методом статистического анализа(в разработке)
                5 - выход
                \n Введите номер пункта меню и нажмите Enter:\s"""
        );
    }

    static void submenu() {
        System.out.println("""
                \n1 - в главное меню
                2 - выход
                \n"""
        );

    }


}
