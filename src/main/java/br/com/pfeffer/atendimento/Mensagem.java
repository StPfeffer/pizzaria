package br.com.pfeffer.atendimento;

import br.com.pfeffer.pedido.enums.EnumTipoPedido;

public class Mensagem {
    public static void bemVindo() {
        System.out.println("Bem-vindo!\n");

        for (EnumTipoPedido tipoPedido : EnumTipoPedido.values()) {
            System.out.printf("[ %d ] - %s\n", tipoPedido.ordinal() + 1, tipoPedido.getDescricao());
        }

        System.out.print("Primeiramente, escolha o tipo de atendimento que deseja: ");
    }

    public static void listarOpcoesMenu() {
        System.out.println("\n");
        System.out.println("-=-=-=-=-=-=-=-=- MENU -=-=-=-=-=-=-=-=-");
        System.out.println("[ 1 ] - Ver Pizzas Salgadas");
        System.out.println("[ 2 ] - Ver Pizzas Doces");
        System.out.println("[ 3 ] - Ver Bebidas");
        System.out.printf("Escolha a opção que deseja ver: ");
    }

    public static void opcoesMenu() {
        System.out.printf("Escolha um sabor: ");
    }
}
