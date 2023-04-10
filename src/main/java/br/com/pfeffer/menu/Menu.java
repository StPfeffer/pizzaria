package br.com.pfeffer.menu;

import br.com.pfeffer.menu.enums.EnumTipoSabor;

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

    public void listarPizzasSalgadas() {
        listarPizzas(EnumTipoSabor.SALGADA);
    }

    public void listarPizzasDoces() {
        listarPizzas(EnumTipoSabor.DOCE);
    }

    public void listarPizzas(EnumTipoSabor tipoSabor) {
        for (ItemMenu item : itens) {
            if (item.getSaborPizza() != null && item.getSaborPizza().getTipoSabor() == tipoSabor) {
                System.out.printf("%s - %s\n", item.getSaborPizza().getNome(), item.getSaborPizza().getDescricao());
            }
        }
    }

    public void listarBebidas() {
        for (ItemMenu item : itens) {
            if (item.getBebida() != null) {
                System.out.printf("%s - %s\n", item.getBebida().getNome(), item.getBebida().getDescricao());
            }
        }
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

    public void setItens(List<ItemMenu> itens) {
        this.itens = itens;
    }
}
