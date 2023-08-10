package br.com.pfeffer.cliente;

import br.com.pfeffer.core.utils.LoggerPizzaria;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.pedido.enums.EnumTipoPedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private final int id;
    private String nome;
    private String telefone;
    private Endereco endereco;
    private List<Integer> pedidos = new ArrayList<>();

    public Cliente(String nome, String telefone, Endereco endereco) {
        this.id = Utils.randomInteger(true);
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public static Cliente cadastrarCliente(EnumTipoPedido tipoPedido, boolean retry) {
        String mensagem = "Iniciando o cadastro do cliente";;

        if (retry) {
            mensagem = "Reiniciando o cadastro do cliente";
        }

        LoggerPizzaria.info(mensagem, Cliente.class, false, true);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Insira seu telefone: ");
        String telefone = Utils.onlyNumbers(scanner.nextLine());

        Endereco endereco = null;

        if (tipoPedido == EnumTipoPedido.ENTREGA) {
            endereco = Endereco.criarNovoEndereco();
        }

        boolean validacao = Cliente.validarCliente(nome, telefone, endereco);

        if (!validacao) {
            cadastrarCliente(tipoPedido, true);
        }

        return new Cliente(nome, telefone, endereco);
    }

    public static boolean validarCliente(String nome, String telefone, Endereco endereco) {
        boolean valido = true;

        if (nome.isEmpty()) {
            LoggerPizzaria.warn("O nome do cliente está vazio!", Cliente.class, true, false);
            valido = false;
        }

        if (telefone.isEmpty()) {
            LoggerPizzaria.warn("O telefone do cliente está vazio!", Cliente.class, false, false);
            valido = false;
        }

        if (endereco.getLogradouro().isEmpty()) {
            LoggerPizzaria.warn("O endereço do cliente está vazio!", Cliente.class, false, true);
            valido = false;
        }

        if (valido) {
            System.out.print("Deseja alterar as informações? [S / N]: ");
            return !Utils.yesOrNo();
        }

        return valido;
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

    public List<Integer> getPedidos() {
        return pedidos;
    }

    public void addPedido(int numeroPedido) {
        this.pedidos.add(numeroPedido);
    }

    public void setPedidos(List<Integer> pedidos) {
        this.pedidos = pedidos;
    }
}
