package br.com.pfeffer.atendimento;

import br.com.pfeffer.atendimento.enums.EnumStatusAtendimento;
import br.com.pfeffer.cliente.Cliente;
import br.com.pfeffer.cliente.Endereco;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.pedido.Pedido;
import br.com.pfeffer.pedido.enums.EnumTipoPedido;

import java.util.Date;
import java.util.Scanner;

public class Atendimento {
    private int numero;
    private Cliente cliente;
    private Date dataAtendimento;
    private EnumStatusAtendimento statusAtendimento;

    public Atendimento(Cliente cliente, EnumStatusAtendimento statusAtendimento) {
        this.numero = Utils.randomInteger(true);
        this.cliente = cliente;
        this.dataAtendimento = new Date();
        this.statusAtendimento = statusAtendimento;
    }

    public static void iniciarAtendimento() {
        EnumTipoPedido tipoPedido = Pedido.getTipoPedidoFromuser();

        switch (tipoPedido) {
            case ENTREGA, BALCAO -> Atendimento.continuarAtendimento();
            case LA_CARTE -> Pedido.realizarPedido();
        }
    }

    public static void continuarAtendimento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Insira seu telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Insira o nome da rua/avenida: ");
        String logradouro = scanner.nextLine();

        System.out.print("Insira o número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("(OpcionaL) Complemento: ");
        String complemento = scanner.nextLine();
        complemento = complemento.isEmpty() ? null : complemento;

        System.out.print("(Opcional) Bairro: ");
        String bairro = scanner.nextLine();
        bairro = bairro.isEmpty() ? null : bairro;

        scanner.close();

        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro);
        Cliente cliente = new Cliente(nome, telefone, endereco);
        Atendimento atendimento = new Atendimento(cliente, EnumStatusAtendimento.ANDAMENTO);

        Pedido.realizarPedido(atendimento);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public EnumStatusAtendimento getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setStatusAtendimento(EnumStatusAtendimento statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }
}
