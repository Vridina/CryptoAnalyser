package ru.javarush.cryptoanalyser.kolesnikova.commands;

import ru.javarush.cryptoanalyser.kolesnikova.constants.Strings;
import ru.javarush.cryptoanalyser.kolesnikova.entity.Result;
import ru.javarush.cryptoanalyser.kolesnikova.entity.ResultCode;
import ru.javarush.cryptoanalyser.kolesnikova.exceptions.ApplicationExceptions;
import ru.javarush.cryptoanalyser.kolesnikova.util.PathFinder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/// DECOdE encoded.txt decode.txt 111
public class Decoder implements Action {
    public static final String ROOT = PathFinder.getRoot();
    protected Path sourcePath;
    protected Path resultPath;
    protected int key;

    @Override
    public Result execute(String[] parameters) {
        sourcePath = Path.of(ROOT + parameters[0]);
        resultPath = Path.of(ROOT + parameters[1]);
        key = Integer.parseInt(parameters[2]);
        if (key > Strings.alphabetToList().size() || key < 0) {
            throw new ApplicationExceptions("Дорогой друг, будь добр как бобр и введи ключ от 0 до " + Strings.alphabetToList().size() + ". Шифруем файл правильно.");
        }
        List<String> str = new ArrayList<>();
        readFile(str);
        writeFile(str);

        return new Result(ResultCode.OK, "Файл успешно декодирован. Адрес файла: " + resultPath);
    }

    private void readFile(List<String> str) {
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {  // делаю вычитку из файла в буффер, указываю КОДИРОВКУ!
            while (reader.ready()) {
                char[] chars = reader.readLine().toCharArray(); // считываю ОДНУ строку, делаю массив чаров
                encodeCharAr(chars);
                str.add(String.valueOf(chars)+ "\n");  //добавляю в стринги + "\n"
            }
        } catch (Exception e) {
            throw new ApplicationExceptions("Ошибка чтения файла. Попробуй еще раз :)");
        }
    }

    private void encodeCharAr(char[] chars) {
        for (int j = 0; j < chars.length; j++) {
            if (Strings.alphabetToList().contains(chars[j])) {
                int sourceIndex = Strings.alphabetToList().indexOf(chars[j]);
                int resultIndex = (sourceIndex - key) < 0 ?
                        (Strings.alphabetToList().size() + sourceIndex - key) % Strings.alphabetToList().size() :
                        (Math.abs(sourceIndex - key)) % Strings.alphabetToList().size();
                chars[j] = Strings.alphabetToList().get(resultIndex);
            }
        }
    }


    private void writeFile(List<String> str) {
        try (
                BufferedWriter writer = Files.newBufferedWriter(resultPath, StandardCharsets.UTF_8,
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE)) {
            for (String s : str
            ) {
                writer.write(s);
            }
        } catch (
                Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new ApplicationExceptions("Не могу сохранить файл. =( ");
        }
    }


}
