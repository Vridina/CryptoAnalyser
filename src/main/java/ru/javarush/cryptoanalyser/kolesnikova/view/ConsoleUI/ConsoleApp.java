package ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI;

import static ru.javarush.cryptoanalyser.kolesnikova.view.ConsoleUI.ActionsMenu.goMainMenu;

/// encode        text.txt             encoded.txt           3
/// DECOdE        encoded.txt           decode.txt           5
/// BRUTE_FORSE   encoded.txt            brutForse.txt
/// stat_analis   exampltext.txt          encode.txt        statanalis.txt

public class ConsoleApp {



    public static void main(String[] args) {
        goMainMenu();
    }

    static void ErrorMessage() {
        System.out.println("ошибка");
    }

    static void ExitMessage() {
        System.out.println("\nВы завершили работу с программой.\nХорошего времени суток!");
        System.exit(0);
    }


    static void statAnalisMessage() {
        /// stat_analis exampltext.txt encode.txt statanalis.txt
        System.out.println("анализ");
    }

    static void bruteForseMessage() {
        /// BRUTE_FORSE encoded.txt brutForse.txt
        System.out.println("брут");
    }

    static void decodeMessage() {
        /// DECOdE encoded.txt decode.txt 5
        System.out.println("декод");
    }

//    private static void encodeMessage() {
//        /// encode text.txt encoded.txt 3
//        String[] args = new String[4];
//        args[0] = "encode";
//        System.out.println("\nВы выбрали пункт меню № 1 - шифрование текста методом Цезаря. \n"); // заполнить массив  encode
//        System.out.println("Укажите полный путь к файлу, который вы хотите зашифровать. Или нажмите Enter для ывбора файла по умолчанию.");
//        System.out.println("---(По умолчанию используется файл проекта \"\\text\\text.txt\")");
//        submenu();
//
//        String pathIn = new Scanner(System.in).nextLine();
//
//        if (!pathIn.matches("(?)")) {
//            if (pathIn.matches(REGEXP_SISTEM_PATH_WINDOWS)) {
//                args[1] = pathIn;
//                System.out.println("Регексп прошла успешно проверка, записали путь к файлу ->" + args[1]);
//                args[1] = pathIn;
//            } else if (pathIn.matches("\\d")) {
//                if (Integer.parseInt(pathIn) == 1) {
//                    goMainMeny();
//                } else if (Integer.parseInt(pathIn) == 2) {
//                    ExitMessage();
//                }
//            } else {
//                ErrorMessage();
//            }
//        } else {
//            args[1] = "text.txt";
//            System.out.println("Записали путь по умолчанию к файлу ->" + args[1]);
//        }
//
//
//        // Проверка на коретность введенных данных
//        // сообщение об ошибке и ввести данные повторно.
//        // Вернуться начаз
//        // или выйти из программы.
//
//        System.out.println("Укажите полный путь к папке для сохранения файла с шифрованием."); // заполнить массив путем
//        System.out.println("---(По умолчанию используется папка проекта \"\\text\\encoded.txt\")");
//        // Проверка на коретность введенных данных
//        // сообщение об ошибке и ввести данные повторно.
//        // Вернуться начаз
//        // или выйти из программы.
//
//        System.out.println("Укажите полный путь к папке для сохранения файла с шифрованием."); // заполнить массив путем
//        System.out.println("---(По умолчанию используется папка проекта \"\\text\\encoded.txt\")");
//        // Проверка на коретность введенных данных
//        // сообщение об ошибке и ввести данные повторно.
//        // Вернуться начаз
//        // или выйти из программы.
//
//        System.out.println("Укажите ключ, диапазон значений от 1 до " +
//                getSizeAlfabet()); // заполнить массив путем
//        // Проверка на коретность введенных данных
//        // сообщение об ошибке и ввести данные повторно.
//        // Вернуться начаз
//        // или выйти из программы.
//
//        System.out.println("енкод");
//        //описание,
//        // запрос ввода данных
//
//
//    }



//    private static void goMainMeny() {
//        System.out.println("""
//                Выберите опцию:
//                1 - шифровка текста
//                2 - дефшифрока текста
//                3 - расшифровка текста методом Взлома(brute force)
//                4 - расшифровка текста методом статистического анализа(в разработке)
//                5 - выход
//                \n Введите номер пункта меню и нажмите Enter:\s"""
//        );
//
//        int numMenu = Integer.parseInt(new Scanner(System.in).nextLine());
//        //      scanner.close(); может давать ошибку, сча вооще перестал СЛОЕ работаать
//
//        if (numMenu == 1) {
//            encodeMessage();
//        } else if (numMenu == 2) {
//            decodeMessage();
//        } else if (numMenu == 3) {
//            bruteForseMessage();
//        } else if (numMenu == 4) {
//            statAnalisMessage();
//        } else if (numMenu == 5) {
//            ExitMessage();
//        }
////        } else {
////            ErrorMessage();
////        }

    }



