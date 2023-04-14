package br.com.pfeffer.pagamento;

import br.com.pfeffer.atendimento.Mensagem;
import br.com.pfeffer.cliente.Cliente;
import br.com.pfeffer.core.utils.Utils;
import br.com.pfeffer.menu.Pizza;
import br.com.pfeffer.pagamento.enums.EnumMetodoPagamento;
import br.com.pfeffer.pagamento.enums.EnumStatusPagamento;
import br.com.pfeffer.pedido.Pedido;

import java.util.Date;

public class Pagamento {
    private float valorTotal;
    private Date dataPagamento;
    private Cliente cliente;
    private Pedido pedido;
    private Cupom cupom;
    private EnumMetodoPagamento metodoPagamento;
    private EnumStatusPagamento statusPagamento;

    public Pagamento(float valorTotal, Date dataPagamento, Cliente cliente, Pedido pedido, Cupom cupom, EnumMetodoPagamento metodoPagamento, EnumStatusPagamento statusPagamento) {
        this.valorTotal = valorTotal;
        this.dataPagamento = dataPagamento;
        this.cliente = cliente;
        this.pedido = pedido;
        this.cupom = cupom;
        this.metodoPagamento = metodoPagamento;
        this.statusPagamento = statusPagamento;
    }

    public static EnumMetodoPagamento escolherMetodoPagamento() {
        Mensagem.listarMetodosPagamento();
        int opcao = Utils.checkScannerInputForInteger("Por favor, digite uma opção válida: ");

        return EnumMetodoPagamento.values()[opcao - 1];
    }

    // TODO: Desconto/acréscimo/parcela dependendo do metodoPagamento
    public static float calcularValor(Pedido pedido, EnumMetodoPagamento metodoPagamento) {
        System.out.println(pedido.getItemPedido());

        final float[] valor = {pedido.getValorPedido()}; // gambiarra

        pedido.getItemPedido().forEach(itemPedido -> {
            if (itemPedido.getBebida() != null) {
                valor[0] += itemPedido.getBebida().getValor();
            } else if (itemPedido.getPizza() != null) {
                valor[0] += Pizza.calcularValorTotal(pedido);
            }
        });

        return valor[0];
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public EnumMetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(EnumMetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public EnumStatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(EnumStatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
