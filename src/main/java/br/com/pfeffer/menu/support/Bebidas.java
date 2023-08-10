package br.com.pfeffer.menu.support;

import br.com.pfeffer.menu.Bebida;

import java.util.Arrays;
import java.util.List;

public class Bebidas {
    public static List<Bebida> getTodasBebidas() {
        Bebida refrigeranteLata = new Bebida("Refrigerante em lata (350ml)", "Coca-Cola, Pepsi, Guaraná Antarctica, Sprite e Fanta", 5f, 35);
        Bebida sucoLaranja = new Bebida("Suco de Laranja Natural (300ml)", "Suco de laranja natural feito na hora, sem adição de açúcar", 6f, 14);
        Bebida refrigerante = new Bebida("Refrigerante (2l)", "Coca-Cola, Guaraná Antarctica, Sprite e Fanta", 11f, 18);
        Bebida caipirinha = new Bebida("Caipirinha (300ml)", "Clássica bebida brasileira feita com cachaça, limão, açúcar e gelo", 10f, 23);
        Bebida chopp = new Bebida("Chopp (500ml)", "Chopp gelado, disponível em opções de Pilsen, IPA, Stout, entre outras", 13f, 6);
        Bebida limonada = new Bebida("Limonada Suíça (500ml)", "Limonada feita com limões frescos, água e açúcar, servida com gelo", 7f, 12);

        Bebida[] bebidas = {
                refrigeranteLata,
                sucoLaranja,
                refrigerante,
                caipirinha,
                chopp,
                limonada
        };

        return Arrays.asList(bebidas);
    }
}
