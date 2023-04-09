package br.com.pfeffer.pedido;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.cliente.Cliente;
import br.com.pfeffer.pedido.enums.EnumTipoPedido;

import java.util.Scanner;

public class Pedido {
    private EnumTipoPedido tipoPedido;
    private Atendimento atendimento;

    public static EnumTipoPedido getTipoPedidoFromuser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo!");

        for (EnumTipoPedido tipoPedido : EnumTipoPedido.values()) {
            System.out.printf("[ %d ] - %s\n", tipoPedido.getId(), tipoPedido.getDescricao());
        }

        System.out.print("Primeiramente, escolga o tipo de atendimento que deseja: ");

        int opcao = scanner.nextInt();

        switch (Math.abs(opcao)) {
            case 1 -> {
                return EnumTipoPedido.LA_CARTE;
            }
            case 2 -> {
                return EnumTipoPedido.ENTREGA;
            }
            case 3 -> {
                return EnumTipoPedido.BALCAO;
            }
            default -> {
                System.out.println("Desculpe, não foi possível definir o tipo de pedido informado. Tente novamente!");
                getTipoPedidoFromuser();
            }
        }

        scanner.close();

        return EnumTipoPedido.BALCAO;
    }

    public static void realizarPedido() {
        realizarPedido(new Atendimento(null, null));
    }

    public static void realizarPedido(Atendimento atendimento) {
        System.out.println("Realizando o pedido...");
    }

    public EnumTipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(EnumTipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
}
