package br.com.pfeffer.menu;

import br.com.pfeffer.atendimento.Mensagem;
import br.com.pfeffer.core.utils.LoggerPizzaria;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.enums.EnumTamanhoPizza;
import br.com.pfeffer.menu.enums.EnumTipoSabor;
import br.com.pfeffer.pedido.ItemPedido;
import br.com.pfeffer.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static List<ItemMenu> itens;

    public Menu() {
        iniciarMenu();
    }

    private static void iniciarMenu() {
        itens = new ArrayList<>();

        for (SaborPizza saborPizza : new SaborPizza().getSabores()) {
            itens.add(new ItemMenu(saborPizza));
        }

        for (Bebida bebida : new Bebida().getBebidas()) {
            itens.add(new ItemMenu(bebida));
        }
    }

    public static void listarPizzasSalgadas(Pizza pizza) {
        listarPizzas(EnumTipoSabor.SALGADA, pizza);
    }

    public static void listarPizzasDoces(Pizza pizza) {
        listarPizzas(EnumTipoSabor.DOCE, pizza);
    }

    public static void listarPizzas(EnumTipoSabor tipoSabor, Pizza pizza) {
        exibirPizzas(tipoSabor);
        Mensagem.opcoesMenu(tipoSabor, pizza);
    }

    public static void escolherOpcoes(Pedido pedido) {
        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        Menu menu = new Menu();

        switch (Math.abs(opcao)) {
            case 0 -> escolherOpcoes(pedido);
            case 1 -> {
                Utils.jumpLine();
                Utils.showHeader("pizzas salgadas");
                menu.listarPizzasSalgadas(pedido);
            }
            case 2 -> {
                Utils.jumpLine();
                Utils.showHeader("pizzas doces");
                menu.listarPizzasDoces(pedido);
            }
            case 3 -> {
                Utils.jumpLine();
                Utils.showHeader("bebidas");
                menu.listarBebidas(pedido);
            }
            default -> {
                System.out.print("Por favor, escolha uma opção válida: ");
                escolherOpcoes(pedido);
            }
        }
    }

    public static void escolherOpcoes(Pedido pedido, EnumTamanhoPizza tamanhoPizza) {
        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        if (opcao == 0) {
            LoggerPizzaria.info("Opção de voltar ao menu anterior escolhida!", Menu.class, true, false);
            Mensagem.listarOpcoesMenu();
            Pedido.realizarPedido(pedido.getTipoPedido());
        } else {
            if (tamanhoPizza == null) {
                Bebida bebida = Bebida.adicionarBebida(opcao);
                pedido.addItemPedido(new ItemPedido(bebida));
            } else {
                Pizza pizza = Pizza.montarPizza(opcao, tamanhoPizza, pedido);
                pedido.addItemPedido(new ItemPedido(pizza));
            }

            Pedido.finalizarPedido(pedido);
        }
    }

    public static void escolherOpcoes(EnumTipoSabor tipoSabor, Pizza pizza) {
        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        if (opcao == 0) {
            Mensagem.listarOpcoesPizzas();
            int opcao2 = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

            switch (opcao2) {
                case 1, 2 -> Pizza.adicionarSabor(tipoSabor, pizza, opcao2);
                default -> {
                }
                // TODO: Implementar default
            }

            escolherOpcoes(tipoSabor, pizza);
        } else {
            Pizza.adicionarSabor(tipoSabor, pizza, opcao, false);
        }
    }

    public void listarPizzasSalgadas(Pedido pedido) {
        listarPizzas(EnumTipoSabor.SALGADA, pedido);
    }

    public void listarPizzasDoces(Pedido pedido) {
        listarPizzas(EnumTipoSabor.DOCE, pedido);
    }

    public void listarPizzas(EnumTipoSabor tipoSabor, Pedido pedido) {
        EnumTamanhoPizza tamanhoPizza = Pizza.escolherTamanho(pedido);

        LoggerPizzaria.info("Listando os sabores de pizzas " + tipoSabor.toString().toLowerCase(), Menu.class, true, false);

        exibirPizzas(tipoSabor);

        Mensagem.opcoesMenu(pedido, tamanhoPizza);
    }

    private static void exibirPizzas(EnumTipoSabor tipoSabor) {
        System.out.println("\n");

        int itemId = 1;
        for (ItemMenu item : itens) {
            SaborPizza saborPizza = item.getSaborPizza();
            if (saborPizza != null && saborPizza.getTipoSabor() == tipoSabor) {
                System.out.printf("[ %2d ] %-28s - %s\n", itemId, saborPizza.getNome(), saborPizza.getIngredientes());
                itemId++;
            }
        }
    }

    public void listarBebidas(Pedido pedido) {
        exibirBebidas();

        Mensagem.opcoesMenu(pedido);
    }

    public static void listarBebidas(Pizza pizza, Pedido pedido) {
        LoggerPizzaria.info("Listando as bebidas", Menu.class, true, false);

        pedido.addItemPedido(new ItemPedido(pizza));
        exibirBebidas();

        Mensagem.opcoesMenu(pedido);
    }

    private static void exibirBebidas() {
        System.out.println("\n");

        int itemId = 1;
        for (ItemMenu item : itens) {
            Bebida bebida = item.getBebida();
            if (bebida != null) {
                System.out.printf("[ %d ] %-31s - %s\n", itemId, bebida.getNome(), bebida.getDescricao());
                itemId++;
            }
        }
    }

    public static void handleOpcoesMenu(Menu menu, int opcao, Pedido pedido) {
        switch (Math.abs(opcao)) {
            case 1 -> {
                LoggerPizzaria.info("Listando as pizzas salgadas", Menu.class, true, false);
                Utils.jumpLine();

                Utils.showHeader("pizzas salgadas");
                menu.listarPizzasSalgadas(pedido);
            }
            case 2 -> {
                LoggerPizzaria.info("Listando as pizzas doces", Menu.class, true, false);
                Utils.jumpLine();

                Utils.showHeader("pizzas doces");
                menu.listarPizzasDoces(pedido);
            }
            case 3 -> {
                LoggerPizzaria.info("Listando as bebidas", Menu.class, true, false);
                Utils.jumpLine();

                Utils.showHeader("bebidas");
                menu.listarBebidas(pedido);
            }
            default -> {
                LoggerPizzaria.warn("A opção escolhida é inválida!", Menu.class, true, true);
                System.out.print("Por favor, escolha uma opção válida: ");
                Pedido.realizarPedido(pedido.getAtendimento(), pedido.getTipoPedido());
            }
        }
    }

    public List<ItemMenu> getItens() {
        return itens;
    }
}