package br.com.pfeffer.atendimento;

import br.com.pfeffer.atendimento.enums.EnumStatusAtendimento;

import java.util.Date;

public class Atendimento {
    private int numero;
    private Date dataAtendimento;
    private EnumStatusAtendimento statusAtendimento;

    public Atendimento(EnumStatusAtendimento statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    public void iniciarAtendimento() {
    }

    public static void continuarAtendimento() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
