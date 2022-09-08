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
        System.out.println("������");
    }

    static void ExitMessage() {
        System.out.println("\n�� ��������� ������ � ����������.\n�������� ������� �����!");
        System.exit(0);
    }


    static void statAnalisMessage() {
        /// stat_analis exampltext.txt encode.txt statanalis.txt
        System.out.println("������");
    }

    static void bruteForseMessage() {
        /// BRUTE_FORSE encoded.txt brutForse.txt
        System.out.println("����");
    }

    static void decodeMessage() {
        /// DECOdE encoded.txt decode.txt 5
        System.out.println("�����");
    }

//    private static void encodeMessage() {
//        /// encode text.txt encoded.txt 3
//        String[] args = new String[4];
//        args[0] = "encode";
//        System.out.println("\n�� ������� ����� ���� � 1 - ���������� ������ ������� ������. \n"); // ��������� ������  encode
//        System.out.println("������� ������ ���� � �����, ������� �� ������ �����������. ��� ������� Enter ��� ������ ����� �� ���������.");
//        System.out.println("---(�� ��������� ������������ ���� ������� \"\\text\\text.txt\")");
//        submenu();
//
//        String pathIn = new Scanner(System.in).nextLine();
//
//        if (!pathIn.matches("(?)")) {
//            if (pathIn.matches(REGEXP_SISTEM_PATH_WINDOWS)) {
//                args[1] = pathIn;
//                System.out.println("������� ������ ������� ��������, �������� ���� � ����� ->" + args[1]);
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
//            System.out.println("�������� ���� �� ��������� � ����� ->" + args[1]);
//        }
//
//
//        // �������� �� ���������� ��������� ������
//        // ��������� �� ������ � ������ ������ ��������.
//        // ��������� �����
//        // ��� ����� �� ���������.
//
//        System.out.println("������� ������ ���� � ����� ��� ���������� ����� � �����������."); // ��������� ������ �����
//        System.out.println("---(�� ��������� ������������ ����� ������� \"\\text\\encoded.txt\")");
//        // �������� �� ���������� ��������� ������
//        // ��������� �� ������ � ������ ������ ��������.
//        // ��������� �����
//        // ��� ����� �� ���������.
//
//        System.out.println("������� ������ ���� � ����� ��� ���������� ����� � �����������."); // ��������� ������ �����
//        System.out.println("---(�� ��������� ������������ ����� ������� \"\\text\\encoded.txt\")");
//        // �������� �� ���������� ��������� ������
//        // ��������� �� ������ � ������ ������ ��������.
//        // ��������� �����
//        // ��� ����� �� ���������.
//
//        System.out.println("������� ����, �������� �������� �� 1 �� " +
//                getSizeAlfabet()); // ��������� ������ �����
//        // �������� �� ���������� ��������� ������
//        // ��������� �� ������ � ������ ������ ��������.
//        // ��������� �����
//        // ��� ����� �� ���������.
//
//        System.out.println("�����");
//        //��������,
//        // ������ ����� ������
//
//
//    }



//    private static void goMainMeny() {
//        System.out.println("""
//                �������� �����:
//                1 - �������� ������
//                2 - ���������� ������
//                3 - ����������� ������ ������� ������(brute force)
//                4 - ����������� ������ ������� ��������������� �������(� ����������)
//                5 - �����
//                \n ������� ����� ������ ���� � ������� Enter:\s"""
//        );
//
//        int numMenu = Integer.parseInt(new Scanner(System.in).nextLine());
//        //      scanner.close(); ����� ������ ������, ��� ����� �������� ���� ���������
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



