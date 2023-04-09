package br.com.pfeffer.menu;

import br.com.pfeffer.menu.enums.EnumTipoSabor;

public class SaborPizza {
    private String nome;
    private String descricao;
    private float preco;
    private EnumTipoSabor tipoSabor;

    public SaborPizza(String nome, String descricao, float preco, EnumTipoSabor tipoSabor) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tipoSabor = tipoSabor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
