package br.com.pfeffer.core.utils;

import org.apache.log4j.Logger;

public class LoggerPizzaria {
    private static final Logger logger = Logger.getLogger(LoggerPizzaria.class);

    public static void info(String mensagem) {
        logger.info(mensagem);
    }

    public static void warn(String mensagem) {
        logger.warn(mensagem);
    }

}
