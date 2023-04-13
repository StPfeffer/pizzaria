package br.com.pfeffer.atendimento;

import br.com.pfeffer.menu.Menu;
import br.com.pfeffer.menu.Pizza;
import br.com.pfeffer.menu.enums.EnumTamanhoPizza;
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
        System.out.print("Escolha a opção que deseja ver: ");
    }

    public static void listarTamanhosPizzas() {
        for (EnumTamanhoPizza tamanhoPizza : EnumTamanhoPizza.values()) {
            System.out.printf("[ %d ] - %s\n", tamanhoPizza.ordinal() + 1, tamanhoPizza.getDescricao());
        }

        System.out.println("\n[ 0 ] - Voltar para as opções do menu");
        System.out.print("Escolha uma opcão: ");
    }

    public static void opcoesMenu(Atendimento atendimento, EnumTipoPedido tipoPedido) {
        opcoesMenu(atendimento, tipoPedido, null);
    }

    public static void opcoesMenu(Atendimento atendimento, EnumTipoPedido tipoPedido, EnumTamanhoPizza tamanhoPizza) {
        System.out.println("\n[ 0 ] - Voltar para as opções do menu");
        System.out.print("Escolha uma opcão: ");

        Menu.escolherOpcoes(atendimento, tipoPedido, true, tamanhoPizza);
    }
}