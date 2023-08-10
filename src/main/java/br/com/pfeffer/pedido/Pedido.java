package br.com.pfeffer.pedido;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.atendimento.enums.EnumStatusAtendimento;
import br.com.pfeffer.cliente.Cliente;
import br.com.pfeffer.core.utils.LoggerPizzaria;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.Menu;
import br.com.pfeffer.menu.Pizza;
import br.com.pfeffer.pagamento.Pagamento;
import br.com.pfeffer.pedido.enums.EnumStatusPedido;
import br.com.pfeffer.pedido.enums.EnumTipoPedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private EnumTipoPedido tipoPedido;
    private EnumStatusPedido statusPedido;
    private Atendimento atendimento;
    private List<ItemPedido> itemPedido = new ArrayList<>();
    private float valorPedido;

    public Pedido() {
    }

    public Pedido(EnumTipoPedido tipoPedido) {
        this.numero = Utils.randomInteger(true);
        this.tipoPedido = tipoPedido;
        this.statusPedido = EnumStatusPedido.EM_PREPARACAO;
    }

    public static EnumTipoPedido escolherTipoPedido() {
        int opcao = Utils.checkScannerInputForInteger("Escoha o tipo de atendimento baseado nas opções acima: ");

        return switch (Math.abs(opcao)) {
            case 1 -> EnumTipoPedido.LA_CARTE;
            case 2 -> EnumTipoPedido.ENTREGA;
            case 3 -> EnumTipoPedido.BALCAO;
            default -> {
                LoggerPizzaria.warn("Desculpe, não foi possível definir o tipo de pedido informado.", Pedido.class, true, true);
                System.out.print("Tente novamente: ");
                yield escolherTipoPedido();
            }
        };
    }

    public static void realizarPedido(EnumTipoPedido tipoPedido) {
        realizarPedido(new Atendimento(null, null), tipoPedido);
    }

    public static void realizarPedido(Atendimento atendimento, EnumTipoPedido tipoPedido) {
        atendimento.setStatusAtendimento(EnumStatusAtendimento.ANDAMENTO);

        realizarPedido(atendimento, new Pedido(tipoPedido));
    }

    public static void realizarPedido(Atendimento atendimento, Pedido pedido) {
        pedido.setStatusPedido(EnumStatusPedido.EM_ANDAMENTO);

        if (pedido.getAtendimento() == null) {
            pedido.setAtendimento(atendimento);
        }

        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        Menu menu = new Menu();

        Menu.handleOpcoesMenu(menu, opcao, pedido);
    }

    public static void finalizarPedido(Pedido pedido) {
        LoggerPizzaria.info("Finalizando o pedido...", Pedido.class, true, false);

        pedido.setStatusPedido(EnumStatusPedido.CONCLUIDO);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LoggerPizzaria.info("Pedido finalizado", Pedido.class, false, false);

        Cliente cliente = pedido.getAtendimento().getCliente();

        if (cliente != null) {
            cliente.addPedido(pedido.getNumero());
        }

        Pagamento pagamento = new Pagamento();

        pagamento.setPedido(pedido);
        pagamento.setMetodoPagamento(Pagamento.escolherMetodoPagamento());
        pagamento.setValorCheio(Pagamento.calcularValor(pagamento));

        Atendimento.finalizarAtendimento(pedido);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EnumTipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(EnumTipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public EnumStatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(EnumStatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public void addItemPedido(ItemPedido itemPedido) {
        this.itemPedido.add(itemPedido);
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    public float getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(float valorPedido) {
        this.valorPedido = valorPedido;
    }
}