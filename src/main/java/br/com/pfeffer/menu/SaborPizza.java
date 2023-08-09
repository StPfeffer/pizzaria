package br.com.pfeffer.menu;

import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.enums.EnumTipoSabor;
import br.com.pfeffer.menu.support.Sabores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaborPizza {
    private String nome;
    private String ingredientes;
    private float preco;
    private EnumTipoSabor tipoSabor;
    private List<SaborPizza> sabores;

    public SaborPizza() {
        this.sabores = new ArrayList<>();

        this.sabores.addAll(Sabores.getTodosSabores());
    }

    public SaborPizza(String nome, String ingredientes, float preco, EnumTipoSabor tipoSabor) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco = preco;
        this.tipoSabor = tipoSabor;
    }

    public void criarNovoSabor() {
        Scanner scanner = new Scanner(System.in);
        SaborPizza saborPizza = new SaborPizza();

        System.out.print("Insira o nome do sabor:");
        String nome = scanner.nextLine();

        System.out.println("Qual o tipo do sabor? (S (Salgado) ou D (Doce)): ");
        char tipoSabor = scanner.nextLine().toUpperCase().trim().charAt(0);

        if (tipoSabor == 'S') {
            saborPizza.setTipoSabor(EnumTipoSabor.SALGADA);
        } else {
            saborPizza.setTipoSabor(EnumTipoSabor.DOCE);
        }

        System.out.print("Insira os ingredientes do sabor: ");
        String ingredientes = scanner.nextLine();

        System.out.print("Insira o preço do sabor: ");
        float preco = Utils.checkScannerInputForFloat("O valor informado é inválido! Tente outro valor: ");

        saborPizza.setNome(nome);
        ;
        saborPizza.setIngredientes(ingredientes);
        saborPizza.setPreco(preco);

        this.sabores.add(saborPizza);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public EnumTipoSabor getTipoSabor() {
        return tipoSabor;
    }

    public void setTipoSabor(EnumTipoSabor tipoSabor) {
        this.tipoSabor = tipoSabor;
    }

    public List<SaborPizza> getSabores() {
        return sabores;
    }

    public void setSabores(List<SaborPizza> sabores) {
        this.sabores = sabores;
    }

    public void addSabore(SaborPizza saborPizza) {
        this.sabores.add(saborPizza);
    }

    public void addSabores() {
        this.sabores.addAll(Sabores.getTodosSabores());
    }

}
