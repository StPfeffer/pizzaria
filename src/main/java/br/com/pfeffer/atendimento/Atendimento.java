package br.com.pfeffer.atendimento;

import br.com.pfeffer.atendimento.enums.EnumStatusAtendimento;
import br.com.pfeffer.cliente.Cliente;
import br.com.pfeffer.cliente.Endereco;
import br.com.pfeffer.core.utils.LoggerPizzaria;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.pagamento.Pagamento;
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
        EnumTipoPedido tipoPedido = Pedido.escolherTipoPedido();

        LoggerPizzaria.info("Tipo do pedido escolhido: " + tipoPedido.getDescricao(), Atendimento.class, true, false);

        switch (tipoPedido) {
            case ENTREGA, BALCAO -> Atendimento.continuarAtendimento(tipoPedido);
            case LA_CARTE -> {
                Mensagem.listarOpcoesMenu();
                Pedido.realizarPedido(tipoPedido);
            }
        }
    }

    public static void continuarAtendimento(EnumTipoPedido tipoPedido) {
        Cliente cliente = Cliente.cadastrarCliente(tipoPedido, false);

        Atendimento atendimento = new Atendimento(cliente, EnumStatusAtendimento.ANDAMENTO);

        Mensagem.listarOpcoesMenu();
        Pedido.realizarPedido(atendimento, tipoPedido);
    }

    public static void finalizarAtendimento(Pedido pedido) {
        pedido.getAtendimento().setStatusAtendimento(EnumStatusAtendimento.FINALIZADO);

        LoggerPizzaria.info("Atendimento finalizado", Atendimento.class, false, true);

        System.out.println(pedido);
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
        if (statusAtendimento == EnumStatusAtendimento.FINALIZADO
                || statusAtendimento == EnumStatusAtendimento.CANCELADO) {
            this.setDhFinalAtendimento(new Date());
        }

        this.statusAtendimento = statusAtendimento;
    }
}
