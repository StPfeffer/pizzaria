package br.com.pfeffer.pedido;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.Menu;
import br.com.pfeffer.pedido.enums.EnumStatusPedido;
import br.com.pfeffer.pedido.enums.EnumTipoPedido;
import br.com.pfeffer.reserva.Mesa;

public class Pedido {
    private int numero;
    private EnumTipoPedido tipoPedido;
    private EnumStatusPedido statusPedido;
    private Atendimento atendimento;
    private Mesa mesa;

    public Pedido(EnumTipoPedido tipoPedido) {
        this.numero = Utils.randomInteger(true);
        this.tipoPedido = tipoPedido;
        this.statusPedido = EnumStatusPedido.EM_PREPARACAO;
    }

    public static EnumTipoPedido getTipoPedidoUsuario() {
        int opcao = Utils.checkScannerInputForInteger("Escoha o tipo de atendimento baseado nas opções acima: ");

        switch (Math.abs(opcao)) {
            case 1:
                return EnumTipoPedido.LA_CARTE;
            case 2:
                return EnumTipoPedido.ENTREGA;
            case 3:
                return EnumTipoPedido.BALCAO;
            default:
                System.out.print("Desculpe, não foi possível definir o tipo de pedido informado. Tente novamente: ");
                return getTipoPedidoUsuario();
        }
    }

    public static void realizarPedido(EnumTipoPedido tipoPedido) {
        realizarPedido(new Atendimento(null, null), tipoPedido);
    }

    public static void realizarPedido(Atendimento atendimento, EnumTipoPedido tipoPedido) {
        int opcao = Utils.checkScannerInputForInteger("Por favor, escolha uma opção válida: ");

        // debug -> Mapper.writeValueAsString(atendimento);
        Menu menu = new Menu();

        switch (Math.abs(opcao)) {
            case 1:
                System.out.println("\n");
                System.out.println("-=-=-=-=-=-=-=-=- PIZZAS SALGADAS -=-=-=-=-=-=-=-=-");
                menu.listarPizzasSalgadas(atendimento, tipoPedido);
                break;
            case 2:
                System.out.println("\n");
                System.out.println("-=-=-=-=-=-=-=-=- PIZZAS DOCES -=-=-=-=-=-=-=-=-");
                menu.listarPizzasDoces(atendimento, tipoPedido);
                break;
            case 3:
                System.out.println("\n");
                System.out.println("-=-=-=-=-=-=-=-=- BEBIDAS -=-=-=-=-=-=-=-=-");
                menu.listarBebidas(atendimento, tipoPedido);
                break;
            default:
                System.out.print("Por favor, escolha uma opção válida: ");
                realizarPedido(atendimento, tipoPedido);
        }
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

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
