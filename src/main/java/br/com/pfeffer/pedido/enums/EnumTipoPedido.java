package br.com.pfeffer.pedido.enums;

public enum EnumTipoPedido {
    LA_CARTE("LA_CARTE", "Pedido à la carte", 1, 0.0f),
    ENTREGA("ENTREGA", "Pedido para Entrega", 2, 4.0f),
    BALCAO("BALCAO", "Pedido no Balcão", 3, 0.0f);

    private final String descricao;
    private final int id;

    EnumTipoPedido(String key, String descricao, int id, float taxa) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getValue() {
        return descricao;
    }

    public int getId() {
        return id;
    }
}
