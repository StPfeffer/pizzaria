package br.com.pfeffer.reserva;

import br.com.pfeffer.reserva.enums.EnumStatusMesa;

public class Mesa {
    private int numero;
    private int capacidade;
    private EnumStatusMesa statusMesa;

    public Mesa(int numero, int capacidade, EnumStatusMesa statusMesa) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.statusMesa = statusMesa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public EnumStatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(EnumStatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }
}
