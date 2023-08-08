package br.com.pfeffer.atendimento.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumStatusAtendimento implements IEnum<String> {
    AGUARDANDO("AGUARDANDO", "Aguardando Atendimento"),
    ANDAMENTO("ANDAMENTO", "Atendimento em Andamento"),
    CANCELADO("CANCELADO", "Atendimento Cancelado"),
    FINALIZADO("FINALIZADO", "Atendimento Finalizado");

    private final String constante;
    private final String descricao;

    EnumStatusAtendimento(String constante, String descricao) {
        this.constante = constante;
        this.descricao = descricao;
    }

    @Override
    public String getConstante() {
        return constante;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
