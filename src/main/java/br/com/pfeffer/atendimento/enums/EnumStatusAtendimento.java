package br.com.pfeffer.atendimento.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumStatusAtendimento implements IEnum {
    AGUARDANDO("AGUARDANDO", "Aguardando Atendimento"),
    ANDAMENTO("ANDAMENTO", "Atendimento em Andamento"),
    CANCELADO("CANCELADO", "Atendimento Cancelado"),
    FINALIZADO("FINALIZADO", "Atendimento Finalizado");

    private final String key;
    private final String descricao;

    EnumStatusAtendimento(String key, String descricao) {
        this.key = key;
        this.descricao = descricao;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
