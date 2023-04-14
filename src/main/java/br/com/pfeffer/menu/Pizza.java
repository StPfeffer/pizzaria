package br.com.pfeffer.menu;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.atendimento.Mensagem;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.enums.EnumTamanhoPizza;
import br.com.pfeffer.menu.enums.EnumTipoSabor;
import br.com.pfeffer.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<SaborPizza> sabores = new ArrayList<>();
    private EnumTamanhoPizza tamanho;
    private float valorTotal;

    public Pizza() {
    }

    public Pizza(List<SaborPizza> sabores, EnumTamanhoPizza tamanho, float valorTotal) {
        this.sabores = sabores;
        this.tamanho = tamanho;
        this.valorTotal = valorTotal;
    }

    public static EnumTamanhoPizza escolherTamanho(Pedido pedido) {
        Mensagem.listarTamanhosPizzas();

        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        if (opcao == 0) {
            Mensagem.listarOpcoesMenu();
            Pedido.realizarPedido(pedido.getAtendimento(), pedido);
        }

        return EnumTamanhoPizza.values()[opcao - 1];
    }

    public static Pizza montarPizza(int opcao, Pedido pedido, EnumTamanhoPizza tamanho) {
        Pizza pizza = new Pizza();
        pizza.setTamanho(tamanho);

        SaborPizza saborPizza = new SaborPizza();

        pizza.addSabor(saborPizza.getSabores().get(opcao - 1));

        for (int i = 1; i < pizza.getTamanho().getFatias() / 4; i++) {
            if (Mensagem.adicionarSabor()) {
                Mensagem.listarOpcoesPizzas();

                adicionarSabor(null, pizza, null);
            } else {
                break;
            }
        }

        return pizza;
    }

    public static void adicionarSabor(EnumTipoSabor tipoSabor, Pizza pizza, Integer opcao) {
        if (opcao == null) {
            opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");
        }

        switch (opcao) {
            case 1:
                System.out.println("\n");
                System.out.println("-=-=-=-=-=-=-=-=- PIZZAS SALGADAS -=-=-=-=-=-=-=-=-");
                Menu.listarPizzasSalgadas(pizza);
                break;
            case 2:
                System.out.println("\n");
                System.out.println("-=-=-=-=-=-=-=-=- PIZZAS DOCES -=-=-=-=-=-=-=-=-");
                Menu.listarPizzasDoces(pizza);
                break;
            default:
                adicionarSabor(tipoSabor, pizza, opcao, true);
                break;
        }
    }

    public static void adicionarSabor(EnumTipoSabor tipoSabor, Pizza pizza, Integer opcao, boolean flag) {
        SaborPizza saborPizza = new SaborPizza();

        if (tipoSabor == EnumTipoSabor.DOCE) {
            opcao += 10;
        }

        pizza.addSabor(saborPizza.getSabores().get(opcao - 1));
    }

    public List<SaborPizza> getSabores() {
        return sabores;
    }

    public void addSabor(SaborPizza saborPizza) {
        this.sabores.add(saborPizza);
    }

    public void setSabores(List<SaborPizza> sabores) {
        this.sabores = sabores;
    }

    public EnumTamanhoPizza getTamanho() {
        return tamanho;
    }

    public void setTamanho(EnumTamanhoPizza tamanho) {
        this.tamanho = tamanho;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
