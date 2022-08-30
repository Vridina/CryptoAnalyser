package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyser.kolesnikova.constants.Strings.alphabetToList;

public class BrutForse implements Action {


    public static final String ROOT = PathFinder.getRoot();
    protected Path sourcePath; // �������� ������������� ����
    protected Path resultPath; // ��������� ���� �������������
    protected int key; // ����������, ����� ��������� � ������� �� �����

    protected static final String regex = "[ .,��\"'!:?+-=&@*()%\\\\]+";


    /// BRUTE_FORSE encoded.txt brutForse.txt


    @Override
    public Result execute(String[] parameters) {
        sourcePath = Path.of(ROOT + parameters[0]);
        resultPath = Path.of(ROOT + parameters[1]);
        readFile10000();


        return new Result(ResultCode.OK, "���� ������� �����������. ����� �����: " + resultPath + ". �������� ����: " + key);

    }


    private void readFile10000() {
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {     // ����� ������� �� ����� � ������, �������� ���������!
            int x = 0;
            while (reader.ready() && x < 10000) {
                char[] chars = reader.readLine().toCharArray();                                           // �������� ���� ������, ����� ������ �����
                x += chars.length;
                key = searcKey(chars);
//                strings.add(reader.readLine() + "\n");                //�������� � ������� + "\n"
            }
        } catch (Exception e) {
            throw new ApplicationExceptions("������ ������ �����. �������� ��� ��� :)");
        }
    }

    private int searcKey(char[] chars) {
        int resultKey = 0;
        for (int checkNewKey = 0; checkNewKey <= alphabetToList().size(); checkNewKey++) {
            int charsSpase = 0;                                                                        // �������� ����
            char[] charsResult = new char[chars.length];
            for (int j = 0; j < chars.length; j++) {                                           // ���� �� �����
                if (alphabetToList().contains(chars[j])) {
                    int sourceIndex = alphabetToList().indexOf(chars[j]);                   // ���� �� �� �������� ������ ����
                    int resultIndex = (sourceIndex - checkNewKey) < 0 ?
                            (alphabetToList().size() + sourceIndex - checkNewKey) % alphabetToList().size() :
                            (Math.abs(sourceIndex - checkNewKey)) % alphabetToList().size();
                    charsResult[j] = alphabetToList().get(resultIndex);                             //�������� �������� ��������� ����
                }
                if (charsResult[j] == ' ') charsSpase++;
            }
            if (charsSpase > 0) {
                var split = List.of(String.valueOf(charsResult).split(regex));
                resultKey = lookForMatch(checkNewKey, split, readFileDictionary());// ����� �����
            }
        }
        return resultKey;
    }


    private static int lookForMatch(int keyForVerification, List<String> split, List<String> dictionary) {
        int matchWithTheDictionary = 0;
        for (String sourseSplit : split    // ����� ����������
        ) {
            for (String wordDictionary : dictionary
            ) {
                boolean contains = sourseSplit.equalsIgnoreCase(wordDictionary);
                if (contains) matchWithTheDictionary++;
            }
        }
        if (matchWithTheDictionary > split.size() / 3) {
            System.out.println(split);
            System.out.printf("���� ������� %d ���������� ���� �� �������� (�� %d ����). ���� ����� %d ", matchWithTheDictionary, split.size(), keyForVerification);
        }
        return keyForVerification;
    }


    private static List<String> readFileDictionary() {
        List<String> dictionary;
        try {
            dictionary = Files.readAllLines(Path.of("D:\\Java\\_workProject\\Testing\\dict.txt"), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new ApplicationExceptions("������ ��� ������ ������� " + e);
        }
        return dictionary;
    }


}
