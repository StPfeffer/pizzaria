package br.com.pfeffer.cliente;

import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final int id;
    private String nome;
    private String telefone;
    private Endereco endereco;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String telefone, Endereco endereco) {
        this.id = Utils.randomInteger(true);
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public static boolean validarCliente() {
        System.out.print("Deseja alterar as informações? [S / N]: ");

        return Utils.getYesOrNo();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
