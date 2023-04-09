package br.com.pfeffer.atendimento;

import br.com.pfeffer.atendimento.enums.EnumStatusAtendimento;
import br.com.pfeffer.cliente.Cliente;
import br.com.pfeffer.core.utils.Utils;

import java.util.Date;

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
    }

    public static void continuarAtendimento() {
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
