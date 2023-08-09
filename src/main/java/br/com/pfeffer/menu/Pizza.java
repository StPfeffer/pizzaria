package br.com.pfeffer.menu;

import br.com.pfeffer.atendimento.Mensagem;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.enums.EnumTamanhoPizza;
import br.com.pfeffer.menu.enums.EnumTipoSabor;
import br.com.pfeffer.pedido.Pedido;
import br.com.pfeffer.pedido.ItemPedido;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<SaborPizza> sabores = new ArrayList<>();
    private EnumTamanhoPizza tamanho;
    private float valorPizza;

    public Pizza() {
    }

    public Pizza(List<SaborPizza> sabores, EnumTamanhoPizza tamanho, float valorTotal) {
        this.sabores = sabores;
        this.tamanho = tamanho;
        this.valorPizza = valorTotal;
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

    public static Pizza montarPizza(int opcao, EnumTamanhoPizza tamanho) {
        Pizza pizza = new Pizza();
        pizza.setTamanho(tamanho);

        SaborPizza saborPizza = new SaborPizza();

        pizza.addSabor(saborPizza.getSabores().get(opcao - 1));

        for (int i = 1; i < pizza.getTamanho().getFatias() / 4; i++) {
            if (Mensagem.adicionarSabor()) {
                Mensagem.listarOpcoesPizzas();

                adicionarSabor(null, pizza, null);
            } else if (Mensagem.adicionarBebida()) {
                Mensagem.adicionarBebida();
                break;
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
            case 1 -> {
                Utils.jumpLine();
                Utils.showHeader("pizzas salgadas");
                Menu.listarPizzasSalgadas(pizza);
            }
            case 2 -> {
                Utils.jumpLine();
                Utils.showHeader("pizzas doces");
                Menu.listarPizzasDoces(pizza);
            }
            default -> adicionarSabor(tipoSabor, pizza, opcao, true);
        }
    }

    public static void adicionarSabor(EnumTipoSabor tipoSabor, Pizza pizza, Integer opcao, boolean flag) {
        SaborPizza saborPizza = new SaborPizza();

        if (tipoSabor == EnumTipoSabor.DOCE) {
            opcao += 10;
        }

        pizza.addSabor(saborPizza.getSabores().get(opcao - 1));
    }

    public static float calcularValorPizza(Pedido pedido) {
        float precoTotal = 0f;

        for (ItemPedido itemPedido : pedido.getItemPedido()) {
            Pizza pizza = itemPedido.getPizza();
            float precoPorSabor = calcularPrecoPorSabor(pizza);
            float precoPorPizza = precoPorSabor * pizza.getTamanho().getFatias() / pizza.getSabores().size();
            precoTotal += precoPorPizza;
        }

        float acrescimoTamanho = pedido.getItemPedido().get(0).getPizza().getTamanho().getAcrescimo();
        return precoTotal + acrescimoTamanho;
    }

    private static float calcularPrecoPorSabor(Pizza pizza) {
        return calcularPrecoTotalSabores(pizza) / pizza.getTamanho().getFatias();
    }

    private static float calcularPrecoTotalSabores(Pizza pizza) {
        float precoTotal = 0f;

        for (SaborPizza saborPizza : pizza.getSabores()) {
            precoTotal += saborPizza.getPreco();
        }

        return precoTotal;
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

    public float getValorPizza() {
        return valorPizza;
    }

    public void setValorPizza(float valorPizza) {
        this.valorPizza = valorPizza;
    }
}