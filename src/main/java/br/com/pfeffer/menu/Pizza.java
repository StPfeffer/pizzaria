package br.com.pfeffer.menu;

import br.com.pfeffer.atendimento.Mensagem;
import br.com.pfeffer.core.utils.LoggerPizzaria;
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

    public static Pizza montarPizza(int opcao, EnumTamanhoPizza tamanho, Pedido pedido) {
        LoggerPizzaria.info("Montando a pizza", Pizza.class, true, false);

        Pizza pizza = new Pizza();
        pizza.setTamanho(tamanho);

        SaborPizza saborPizza = new SaborPizza();

        // Isso aqui não faz validação alguma sobre o limite do array. Por exemplo,
        // caso escolher a opção 11 ao listar as pizzas salgadas será considerado o
        // primeiro sabor doce (opcao - 1). IndexOutOfBounds pode acontecer aqui.
        SaborPizza saborEscolhido = saborPizza.getSabores().get(opcao - 1);

        LoggerPizzaria.info("Sabor escolhido: " + saborEscolhido.getNome(), Pizza.class, false, true);

        pizza.addSabor(saborEscolhido);
        boolean bebidaAdicionada = false;

        for (int i = 1; i < pizza.getTamanho().getFatias() / 4; i++) {
            if (Mensagem.adicionarSabor()) {
                Mensagem.listarOpcoesPizzas();

                adicionarSabor(null, pizza, null);
            } else if (Mensagem.adicionarBebida()) {
                bebidaAdicionada = true;
                Bebida.adicionarBebida(pizza, pedido);
                break;
            } else {
                break;
            }
        }

        if (Mensagem.adicionarBebida() && !bebidaAdicionada) {
            Bebida.adicionarBebida(pizza, pedido);
        }

        return pizza;
    }

    public static void adicionarSabor(EnumTipoSabor tipoSabor, Pizza pizza, Integer opcao) {
        LoggerPizzaria.info("Adicionando um sabor à  pizza", Pizza.class, true, true);

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

    public static void adicionarSabor(EnumTipoSabor tipoSabor, Pizza pizza, Integer opcao, boolean flag) { // isso aqui é gambiarra
        SaborPizza saborPizza = new SaborPizza();

        if (tipoSabor == EnumTipoSabor.DOCE) {
            opcao += 10;
        }

        pizza.addSabor(saborPizza.getSabores().get(opcao - 1));
    }

    public static float calcularValorPizza(Pizza pizza, Pedido pedido) {
        int numSabores = pizza.getSabores().size();
        float precoPorSabor = calcularPrecoPorSabor(pizza);

        float precoTotal = calcularPrecoPorPizza(pizza, precoPorSabor) / numSabores;

        return precoTotal + pedido.getItemPedido().get(0).getPizza().getTamanho().getAcrescimo();
    }

    private static float calcularPrecoPorSabor(Pizza pizza) {
        return (float) pizza.getSabores().stream()
                .mapToDouble(saborPizza -> saborPizza.getPreco() / pizza.getTamanho().getFatias())
                .sum();
    }

    private static float calcularPrecoPorPizza(Pizza pizza, float precoPorSabor) {
        return precoPorSabor * pizza.getTamanho().getFatias();
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