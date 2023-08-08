package br.com.pfeffer.pedido.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumStatusPedido implements IEnum<String> {
    CANCELADO("CANCELADO", "Pedido Cancelado"),
    EM_PREPARACAO("EM_PREPARACAO", "Pedido em Preparação"),
    EM_ANDAMENTO("EM_ANDAMENTO", "Pedido em Andamento"),
    ENVIADO("ENVIADO", "Pedido Enviado"),
    CONCLUIDO("CONCLUIDO", "Pedido Concluído");

    private final String constante;
    private final String descricao;

    EnumStatusPedido(String constante, String descricao) {
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
