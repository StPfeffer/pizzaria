package br.com.pfeffer.core.utils;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static String onlyNumbers(String str) {
        return str.replaceAll("\\D+", "");
    }

    public static int randomInteger(boolean positive) {
        if (positive) {
            return Math.abs(new Random().nextInt());
        }
        return new Random().nextInt();
    }

    public static boolean getYesOrNo() {
        Scanner scanner = new Scanner(System.in);

        char opcao = scanner.nextLine().trim().toUpperCase().charAt(0);

        return opcao == 'S';
    }

    public static void showHeader(String title) {
        System.out.printf("-=-=-=-=-=-=-=-=- %s -=-=-=-=-=-=-=-=-\n", title.toUpperCase());
    }

    public static int checkScannerInputForInteger(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            String temp = scanner.nextLine();

            if (temp.isEmpty()) {
                System.out.print(mensagem);
                input = Integer.MIN_VALUE;
            } else {
                try {
                    input = Integer.parseInt(temp);
                } catch (NumberFormatException e) {
                    input = Integer.MIN_VALUE;
                    System.out.print(mensagem);
                }
            }
        } while (input == Integer.MIN_VALUE);

        return input;
    }
}
