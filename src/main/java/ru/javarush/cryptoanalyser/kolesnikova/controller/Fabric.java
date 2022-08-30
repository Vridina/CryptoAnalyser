package ru.javarush.cryptoanalyser.kolesnikova.controller;

import ru.javarush.cryptoanalyser.kolesnikova.commands.Action;
import ru.javarush.cryptoanalyser.kolesnikova.commands.BrutForse;
import ru.javarush.cryptoanalyser.kolesnikova.commands.Decoder;
import ru.javarush.cryptoanalyser.kolesnikova.commands.Encoder;

public enum Fabric {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTE_FORSE(new BrutForse());

    private final Action action;
    // не понимаю почему через
    // с точнее в методе файнд, находится переменная енум,и точка акшн
    // я когда создаю енум,используется конструктор файбрики
    // потом я в него передаю наследников интерфейса - ок
    // Я не понимаю почему в методе файнд акшн через точку (( .

    Fabric(Action action) {
        this.action = action;
    }

    // Получается я беру в файнде Фабрик.ДЕКОДЕ.акшин, так как
    //  так как Фабрик.ДЕКОДЕ - это this, а
    //  в конструкторе фабрика переменна Aкшина участвует
    //  и получается что я вызываю консруктор..? который создает
    //  наследника соответсвующего.

    static Action find(String command) {
        return Fabric.valueOf(command.toUpperCase()).action;
    }
}
