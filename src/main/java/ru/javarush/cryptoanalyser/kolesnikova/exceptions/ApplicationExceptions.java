package ru.javarush.cryptoanalyser.kolesnikova.exceptions;

public class ApplicationExceptions extends RuntimeException{
    public ApplicationExceptions() {
    }

    public ApplicationExceptions(String message) {
        super(message);
    }

    public ApplicationExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationExceptions(Throwable cause) {
        super(cause);
    }
}
