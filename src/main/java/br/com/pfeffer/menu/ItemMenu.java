package br.com.pfeffer.menu;

public class ItemMenu {
    private SaborPizza saborPizza;
    private Bebida bebida;

    public ItemMenu(SaborPizza saborPizza) {
        this.saborPizza = saborPizza;
    }

    public ItemMenu(Bebida bebida) {
        this.bebida = bebida;
    }

    public SaborPizza getSaborPizza() {
        return saborPizza;
    }

    public void setSaborPizza(SaborPizza saborPizza) {
        this.saborPizza = saborPizza;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
}
