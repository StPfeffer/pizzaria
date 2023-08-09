package br.com.pfeffer.pedido.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumTipoPedido implements IEnum<String> {
    LA_CARTE("LA_CARTE", "Pedido à la carte", 1.5f),
    ENTREGA("ENTREGA", "Pedido para Entrega", 4.0f),
    BALCAO("BALCAO", "Pedido no Balcão", 0.0f);

    private final String constante;
    private final String descricao;
    private final float taxa;

    EnumTipoPedido(String constante, String descricao, float taxa) {
        this.constante = constante;
        this.descricao = descricao;
        this.taxa = taxa;
    }

    @Override
    public String getConstante() {
        return constante;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public float getTaxa() {
        return taxa;
    }
}
