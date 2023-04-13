package br.com.pfeffer.menu;

import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.support.Bebidas;

import java.util.ArrayList;
import java.util.List;

public class Bebida {
    private String nome;
    private String descricao;
    private int sku;
    private float valor;
    private int saldo;

    private List<Bebida> bebidas;

    public Bebida() {
        this.bebidas = new ArrayList<>();

        this.bebidas.addAll(Bebidas.getTodasBebidas());
    }

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

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public void addBebida(Bebida bebida) {
        this.bebidas.add(bebida);
    }

    public void addBebidas() {
        this.bebidas.addAll(Bebidas.getTodasBebidas());
    }
}
