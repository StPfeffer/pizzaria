package br.com.pfeffer.core.utils;

import java.util.Random;

public class Utils {
    public static int randomInteger(boolean positive) {
        if (positive) {
            return Math.abs(new Random().nextInt());
        }
        return new Random().nextInt();
    }
}
