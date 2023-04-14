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
    private float valorCheio;
    private float valorDesconto;
    private float valorFinal;
    private Date dataPagamento;
    private Cliente cliente;
    private Pedido pedido;
    private Cupom cupom;
    private EnumMetodoPagamento metodoPagamento;
    private EnumStatusPagamento statusPagamento;

    public Pagamento() {
        new Pagamento(0, 0, 0, null, cliente, pedido, null, null, null);
    }

    public Pagamento(float valorTotal, float valorDesconto, float valorFinal, Date dataPagamento, Cliente cliente, Pedido pedido, Cupom cupom, EnumMetodoPagamento metodoPagamento, EnumStatusPagamento statusPagamento) {
        this.valorCheio = valorTotal;
        this.valorDesconto = valorDesconto;
        this.valorFinal = valorFinal;
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
    public static float calcularValor(Pagamento pagamento) {
        final float[] valor = {pagamento.getPedido().getValorPedido()}; // gambiarra

        pagamento.getPedido().getItemPedido().forEach(itemPedido -> {
            if (itemPedido.getBebida() != null) {
                valor[0] += itemPedido.getBebida().getValor();
            } else if (itemPedido.getPizza() != null) {
                valor[0] += Pizza.calcularValorPizza(pagamento.getPedido());
            }
        });

        float desconto = 0f;

        switch (pagamento.getMetodoPagamento()) {
            case CARTAO_CREDITO:
                desconto = 0f;
                break;
            case CARTAO_DEBITO:
                desconto = 0.05f;
                break;
            case PIX:
                desconto = 0.1f;
                break;
            default:
                System.out.println("Método de pagamento inválido!");
                break;
        }

        pagamento.setValorCheio(valor[0]);
        pagamento.setValorFinal(valor[0] - (valor[0] * desconto));
        pagamento.setValorDesconto(pagamento.getValorCheio() - pagamento.getValorDesconto());

        return valor[0];
    }

    public float getValorCheio() {
        return valorCheio;
    }

    public void setValorCheio(float valorCheio) {
        this.valorCheio = valorCheio;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(float valorFinal) {
        this.valorFinal = valorFinal;
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
