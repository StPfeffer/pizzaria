package br.com.pfeffer.menu;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.atendimento.Mensagem;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.enums.EnumTamanhoPizza;
import br.com.pfeffer.pedido.Pedido;
import br.com.pfeffer.pedido.enums.EnumTipoPedido;

import java.util.List;

public class Pizza {
    private List<SaborPizza> sabores;
    private EnumTamanhoPizza tamanho;
    private float valorTotal;

    public Pizza() {
    }

    public Pizza(List<SaborPizza> sabores, EnumTamanhoPizza tamanho, float valorTotal) {
        this.sabores = sabores;
        this.tamanho = tamanho;
        this.valorTotal = valorTotal;
    }

    public static EnumTamanhoPizza escolherTamanho(Atendimento atendimento, EnumTipoPedido tipoPedido) {
        Mensagem.listarTamanhosPizzas();

        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        if (opcao == 0) {
            Mensagem.listarOpcoesMenu();
            Pedido.realizarPedido(atendimento, tipoPedido);
        }

        return EnumTamanhoPizza.values()[opcao - 1];
    }

    public static Pizza montarPizza() {
        Pizza pizza = new Pizza();
        System.out.println("montando a pizza...");

        return pizza;
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
