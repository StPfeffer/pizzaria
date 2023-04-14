package br.com.pfeffer.pedido;

import br.com.pfeffer.menu.Bebida;
import br.com.pfeffer.menu.Pizza;

public class ItemPedido {
    private Pizza pizza;
    private Bebida bebida;

    public ItemPedido(Pizza pizza) {
        this.pizza = pizza;
    }

    public ItemPedido(Bebida bebida) {
        this.bebida = bebida;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
}
