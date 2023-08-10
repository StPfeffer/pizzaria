package br.com.pfeffer.atendimento;

import br.com.pfeffer.core.utils.LoggerPizzaria;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.Menu;
import br.com.pfeffer.menu.Pizza;
import br.com.pfeffer.menu.enums.EnumTamanhoPizza;
import br.com.pfeffer.menu.enums.EnumTipoSabor;
import br.com.pfeffer.pagamento.enums.EnumMetodoPagamento;
import br.com.pfeffer.pedido.Pedido;
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
        LoggerPizzaria.info("Listando as opções do menu", Mensagem.class, true, false);

        Utils.jumpLine();
        Utils.showHeader("menu");

        System.out.println("[ 1 ] - Ver Pizzas Salgadas");
        System.out.println("[ 2 ] - Ver Pizzas Doces");
        System.out.println("[ 3 ] - Ver Bebidas");
        System.out.print("Escolha a opção que deseja ver: ");
    }

    public static void listarOpcoesPizzas() {
        LoggerPizzaria.info("Listando as opções de pizzas", Mensagem.class, true, false);

        Utils.jumpLine();
        Utils.showHeader("menu");

        System.out.println("[ 1 ] - Ver Pizzas Salgadas");
        System.out.println("[ 2 ] - Ver Pizzas Doces");
        System.out.print("Escolha a opção que deseja ver: ");
    }

    public static void listarTamanhosPizzas() {
        for (EnumTamanhoPizza tamanhoPizza : EnumTamanhoPizza.values()) {
            System.out.printf("[ %d ] - %s\n", tamanhoPizza.ordinal() + 1, tamanhoPizza.getDescricao());
        }

        exibirOpcaoRetornar();
        System.out.print("Escolha uma opcão: ");
    }

    public static void opcoesMenu(Pedido pedido) {
        opcoesMenu(pedido, null);
    }

    public static void opcoesMenu(Pedido pedido, EnumTamanhoPizza tamanhoPizza) {
        exibirOpcaoRetornar();
        System.out.print("Escolha uma opcão: ");

        Menu.escolherOpcoes(pedido, tamanhoPizza);
    }

    public static void opcoesMenu(EnumTipoSabor tipoSabor, Pizza pizza) {
        exibirOpcaoRetornar();
        System.out.print("Escolha uma opcão: ");

        Menu.escolherOpcoes(tipoSabor, pizza);
    }

    public static boolean adicionarSabor() {
        System.out.print("Deseja adicionar outro sabor? [S/ N]: ");

        return Utils.yesOrNo();
    }

    public static boolean adicionarBebida() {
        System.out.print("Deseja adicionar uma bebida? [S/ N]: ");

        return Utils.yesOrNo();
    }

    public static void listarMetodosPagamento() {
        Utils.jumpLine();
        Utils.showHeader("pagamento");

        for (EnumMetodoPagamento metodoPagamento : EnumMetodoPagamento.values()) {
            System.out.printf("[ %d ] - %s\n", metodoPagamento.ordinal() + 1, metodoPagamento.getDescricao());
        }

        System.out.print("Escolha o método de pagamento: ");
    }

    private static void exibirOpcaoRetornar() {
        System.out.println("\n[ 0 ] - Voltar para as opções do menu");
    }
}
