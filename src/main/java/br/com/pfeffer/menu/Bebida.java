package br.com.pfeffer.menu;

import br.com.pfeffer.core.utils.Utils;

public class Bebida {
    private String nome;
    private String descricao;
    private final int sku;
    private float valor;
    private int saldo;

    public Bebida(String nome, String descricao, float valor, int saldo) {
        this.nome = nome;
        this.descricao = descricao;
        this.sku = Utils.randomInteger(true);
        this.valor = valor;
        this.saldo = saldo;
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

    public int getSku() {
        return sku;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
