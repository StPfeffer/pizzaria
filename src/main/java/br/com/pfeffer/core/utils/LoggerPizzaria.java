package br.com.pfeffer.core.utils;

import org.apache.log4j.Logger;

public class LoggerPizzaria {

    private static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }

    private static void log(String mensagem, Class<?> clazz, boolean jumpBefore, boolean jumpAfter, LogLevel logLevel) {
        Logger logger = getLogger(clazz);

        if (jumpBefore) {
            Utils.jumpLine();
        }

        switch (logLevel) {
            case INFO -> logger.info(mensagem);
            case WARN -> logger.warn(mensagem);
            // Add more cases for different log levels if needed
        }

        if (jumpAfter) {
            Utils.jumpLine();
        }
    }

    public static void info(String mensagem, Class<?> clazz, boolean jumpBefore, boolean jumpAfter) {
        log(mensagem, clazz, jumpBefore, jumpAfter, LogLevel.INFO);
    }

    public static void warn(String mensagem, Class<?> clazz, boolean jumpBefore, boolean jumpAfter) {
        log(mensagem, clazz, jumpBefore, jumpAfter, LogLevel.WARN);
    }

    // Add more public methods for other log levels if needed

    private enum LogLevel {
        INFO,
        WARN
    }
}