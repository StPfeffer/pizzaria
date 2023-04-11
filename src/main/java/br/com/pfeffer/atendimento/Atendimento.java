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
    private Date dhInicioAtendimento;
    private Date dhFinalAtendimento;
    private EnumStatusAtendimento statusAtendimento;

    public Atendimento(Cliente cliente, EnumStatusAtendimento statusAtendimento) {
        this.numero = Utils.randomInteger(true);
        this.cliente = cliente;
        this.dhInicioAtendimento = new Date();
        this.statusAtendimento = statusAtendimento;
    }

    public static void iniciarAtendimento() {
        EnumTipoPedido tipoPedido = Pedido.getTipoPedidoFromUser();

        switch (tipoPedido) {
            case ENTREGA:
            case BALCAO:
                Atendimento.continuarAtendimento(tipoPedido);
                break;
            case LA_CARTE:
                Mensagem.listarOpcoesMenu();
                Pedido.realizarPedido(tipoPedido);
                break;
        }
    }

    public static void continuarAtendimento(EnumTipoPedido tipoPedido) {
        Scanner scanner = new Scanner(System.in);
        Endereco endereco = null;

        System.out.print("Insira seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Insira seu telefone: ");
        String telefone = Utils.onlyNumbers(scanner.nextLine());

        if (tipoPedido == EnumTipoPedido.ENTREGA) {
            System.out.print("Insira o nome da rua/avenida: ");
            String logradouro = scanner.nextLine();

            System.out.print("Insira o número: ");
            int numero = Utils.checkScannerInputForInteger("Por favor, informe um número: ");

            System.out.print("(Opcional) Complemento: ");
            String complemento = scanner.nextLine().trim();
            complemento = complemento.isEmpty() ? null : complemento;

            System.out.print("(Opcional) Bairro: ");
            String bairro = scanner.nextLine().trim();
            bairro = bairro.isEmpty() ? null : bairro;

            endereco = new Endereco(logradouro, numero, complemento, bairro);
        }

        Cliente cliente = new Cliente(nome, telefone, endereco);

        Atendimento atendimento = new Atendimento(cliente, EnumStatusAtendimento.ANDAMENTO);

        Mensagem.listarOpcoesMenu();
        Pedido.realizarPedido(atendimento, tipoPedido);
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

    public Date getDhInicioAtendimento() {
        return dhInicioAtendimento;
    }

    public void setDhInicioAtendimento(Date dhInicioAtendimento) {
        this.dhInicioAtendimento = dhInicioAtendimento;
    }

    public Date getDhFinalAtendimento() {
        return dhFinalAtendimento;
    }

    public void setDhFinalAtendimento(Date dhFinalAtendimento) {
        this.dhFinalAtendimento = dhFinalAtendimento;
    }

    public EnumStatusAtendimento getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setStatusAtendimento(EnumStatusAtendimento statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }
}
