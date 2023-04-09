package br.com.pfeffer.atendimento.enums;

public enum EnumStatusAtendimento {
    AGUARDANDO("AGUARDANDO", "Aguardando Atendimento"),
    ANDAMENTO("ANDAMENTO", "Atendimento em Andamento"),
    CANCELADO("CANCELADO", "Atendimento Cancelado"),
    FINALIZADO("FINALIZADO", "Atendimento Finalizado");

    EnumStatusAtendimento(String key, String value) {
    }
}
