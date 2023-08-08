package br.com.pfeffer.menu;

import br.com.pfeffer.atendimento.Mensagem;
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
        itens = new ArrayList<>();

        for (SaborPizza saborPizza : new SaborPizza().getSabores()) {
            ItemMenu item = new ItemMenu(saborPizza);

            itens.add(item);
        }

        for (Bebida bebida : new Bebida().getBebidas()) {
            ItemMenu item = new ItemMenu(bebida);

            itens.add(item);
        }
    }

    public static void listarPizzasSalgadas(Pizza pizza) {
        listarPizzas(EnumTipoSabor.SALGADA, pizza);
    }

    public static void listarPizzasDoces(Pizza pizza) {
        listarPizzas(EnumTipoSabor.DOCE, pizza);
    }

    public void listarPizzasSalgadas(Pedido pedido) {
        listarPizzas(EnumTipoSabor.SALGADA, pedido);
    }

    public void listarPizzasDoces(Pedido pedido) {
        listarPizzas(EnumTipoSabor.DOCE, pedido);
    }

    public void listarPizzas(EnumTipoSabor tipoSabor, Pedido pedido) {
        EnumTamanhoPizza tamanhoPizza = Pizza.escolherTamanho(pedido);

        Utils.jumpLine();

        int itemId = 1;
        for (ItemMenu item : itens) {
            if (item.getSaborPizza() != null && item.getSaborPizza().getTipoSabor() == tipoSabor) {
                System.out.printf("[ %2d ] %-28s - %s\n", itemId, item.getSaborPizza().getNome(), item.getSaborPizza().getDescricao());
                itemId++;
            }
        }

        Mensagem.opcoesMenu(pedido, tamanhoPizza);
    }

    public static void listarPizzas(EnumTipoSabor tipoSabor, Pizza pizza) {
        Utils.jumpLine();

        int itemId = 1;
        for (ItemMenu item : itens) {
            if (item.getSaborPizza() != null && item.getSaborPizza().getTipoSabor() == tipoSabor) {
                System.out.printf("[ %2d ] %-28s - %s\n", itemId, item.getSaborPizza().getNome(), item.getSaborPizza().getDescricao());
                itemId++;
            }
        }

        Mensagem.opcoesMenu(tipoSabor, pizza);
    }

    public void listarBebidas(Pedido pedido) {
        int itemId = 1;
        for (ItemMenu item : itens) {
            if (item.getBebida() != null) {
                System.out.printf("[ %d ] %-31s - %s\n", itemId, item.getBebida().getNome(), item.getBebida().getDescricao());
                itemId++;
            }
        }

        Mensagem.opcoesMenu(pedido);
    }

    public static void escolherOpcoes(Pedido pedido) {
        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        Menu menu = new Menu();

        switch (Math.abs(opcao)) {
            case 0:
                escolherOpcoes(pedido);
                break;
            case 1:
                Utils.jumpLine();
                Utils.showHeader("pizzas salgadas");
                menu.listarPizzasSalgadas(pedido);
                break;
            case 2:
                Utils.jumpLine();
                Utils.showHeader("pizzas doces");
                menu.listarPizzasDoces(pedido);
                break;
            case 3:
                Utils.jumpLine();
                Utils.showHeader("bebidas");
                menu.listarBebidas(pedido);
                break;
            default:
                System.out.print("Por favor, escolha uma opção válida: ");
                escolherOpcoes(pedido);
        }
    }

    public static void escolherOpcoes(Pedido pedido, EnumTamanhoPizza tamanhoPizza) {
        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        if (opcao == 0) {
            Mensagem.listarOpcoesMenu();
            Pedido.realizarPedido(pedido.getTipoPedido());
        } else {
            if (tamanhoPizza == null) {
                Bebida bebida = Bebida.adicionarBebida(opcao, pedido);

                pedido.addItemPedido(new ItemPedido(bebida));
            } else {
                Pizza pizza = Pizza.montarPizza(opcao, tamanhoPizza);

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
                case 1:
                case 2:
                    Pizza.adicionarSabor(tipoSabor, pizza, opcao2);
                    break;
                default:
                    // TODO: Implementar default
            }

            escolherOpcoes(tipoSabor, pizza);
        } else {
            Pizza.adicionarSabor(tipoSabor, pizza, opcao);
        }
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

    public void setItens(List<ItemMenu> itens) {
        itens = itens;
    }
}
