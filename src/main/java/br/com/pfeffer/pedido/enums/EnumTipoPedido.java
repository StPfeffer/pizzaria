package br.com.pfeffer.pedido.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumTipoPedido implements IEnum {
    LA_CARTE("LA_CARTE", "Pedido à la carte", 1, 0.0f),
    ENTREGA("ENTREGA", "Pedido para Entrega", 2, 4.0f),
    BALCAO("BALCAO", "Pedido no Balcão", 3, 0.0f);

    private final String key;
    private final String descricao;
    private final int id;
    private final float taxa;

    EnumTipoPedido(String key, String descricao, int id, float taxa) {
        this.key = key;
        this.id = id;
        this.descricao = descricao;
        this.taxa = taxa;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public float getTaxa() {
        return taxa;
    }
}
