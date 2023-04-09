package br.com.pfeffer.reserva;

import br.com.pfeffer.cliente.Cliente;

import java.util.Date;

public class Reserva {
    private Cliente cliente;
    private Date data;
    private Mesa mesa;

    public Reserva(Cliente cliente, Date data, Mesa mesa) {
        this.cliente = cliente;
        this.data = data;
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
