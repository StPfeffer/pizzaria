package br.com.pfeffer;

public class Pizzaria {
    public static String onlyNumbers(String str) {
        return str.replaceAll("\\D+", "");
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
