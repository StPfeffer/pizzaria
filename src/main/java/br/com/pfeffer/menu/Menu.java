package br.com.pfeffer.menu;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.atendimento.Mensagem;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.enums.EnumTamanhoPizza;
import br.com.pfeffer.menu.enums.EnumTipoSabor;
import br.com.pfeffer.pedido.Pedido;
import br.com.pfeffer.pedido.enums.EnumTipoPedido;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<ItemMenu> itens;

    public Menu() {
        this.itens = new ArrayList<>();

        for (SaborPizza saborPizza : new SaborPizza().getSabores()) {
            ItemMenu item = new ItemMenu(saborPizza);

            itens.add(item);
        }

        for (Bebida bebida : new Bebida().getBebidas()) {
            ItemMenu item = new ItemMenu(bebida);

            itens.add(item);
        }
    }

    public void listarPizzasSalgadas(Atendimento atendimento, EnumTipoPedido tipoPedido) {
        listarPizzas(EnumTipoSabor.SALGADA, atendimento, tipoPedido);
    }

    public void listarPizzasDoces(Atendimento atendimento, EnumTipoPedido tipoPedido) {
        listarPizzas(EnumTipoSabor.DOCE, atendimento, tipoPedido);
    }

    public void listarPizzas(EnumTipoSabor tipoSabor, Atendimento atendimento, EnumTipoPedido tipoPedido) {
        EnumTamanhoPizza tamanhoPizza = Pizza.escolherTamanho(atendimento, tipoPedido);

        System.out.println("\n");

        int itemId = 1;
        for (ItemMenu item : itens) {
            if (item.getSaborPizza() != null && item.getSaborPizza().getTipoSabor() == tipoSabor) {
                System.out.printf("[ %2d ] %-28s - %s\n", itemId, item.getSaborPizza().getNome(), item.getSaborPizza().getDescricao());
                itemId++;
            }
        }

        Mensagem.opcoesMenu(atendimento, tipoPedido, tamanhoPizza);
    }

    public void listarBebidas(Atendimento atendimento, EnumTipoPedido tipoPedido) {
        int itemId = 1;
        for (ItemMenu item : itens) {
            if (item.getBebida() != null) {
                System.out.printf("[ %d ] %-31s - %s\n", itemId, item.getBebida().getNome(), item.getBebida().getDescricao());
                itemId++;
            }
        }

        Mensagem.opcoesMenu(atendimento, tipoPedido);
    }

    public static void escolherOpcoes(Atendimento atendimento, EnumTipoPedido tipoPedido) {
        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        Menu menu = new Menu();

        switch (Math.abs(opcao)) {
            case 0:
                escolherOpcoes(atendimento, tipoPedido);
                break;
            case 1:
                System.out.println("\n");
                System.out.println("-=-=-=-=-=-=-=-=- PIZZAS SALGADAS -=-=-=-=-=-=-=-=-");
                menu.listarPizzasSalgadas(atendimento, tipoPedido);
                break;
            case 2:
                System.out.println("\n");
                System.out.println("-=-=-=-=-=-=-=-=- PIZZAS DOCES -=-=-=-=-=-=-=-=-");
                menu.listarPizzasDoces(atendimento, tipoPedido);
                break;
            case 3:
                System.out.println("\n");
                System.out.println("-=-=-=-=-=-=-=-=- BEBIDAS -=-=-=-=-=-=-=-=-");
                menu.listarBebidas(atendimento, tipoPedido);
                break;
            default:
                System.out.print("Por favor, escolha uma opção válida: ");
                escolherOpcoes(atendimento, tipoPedido);
        }
    }

    public static void escolherOpcoes(Atendimento atendimento, EnumTipoPedido tipoPedido, boolean flag, EnumTamanhoPizza tamanhoPizza) {
        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        if (opcao == 0) {
            Mensagem.listarOpcoesMenu();
            Pedido.realizarPedido(atendimento, tipoPedido);
        } else {
            Pizza pizza = Pizza.montarPizza();

            System.out.print(pizza);
        }
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

    public void setItens(List<ItemMenu> itens) {
        this.itens = itens;
    }
}
