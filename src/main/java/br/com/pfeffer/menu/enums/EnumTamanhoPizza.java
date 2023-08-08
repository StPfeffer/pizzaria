package br.com.pfeffer.menu.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumTamanhoPizza implements IEnum<String> {
    PEQUENA("PEQUENA", "Pequena - 4 fatias (1 sabor)", 4, 0f),
    MEDIA("MEDIA", "Media - 8 fatias (até 2 sabores)", 8, 10f),
    GRANDE("GRANDE", "Grande - 12 fatias (até 3 sabores)", 12, 15f),
    GIGANTE("GIGANTE", "Gigante - 16 fatias (até 4 sabores)", 16, 20f);

    private final String constante;
    private final String descricao;
    private final int fatias;
    private final float acrescimo;

    EnumTamanhoPizza(String constante, String descricao, int fatias, float acrescimo) {
        this.constante = constante;
        this.descricao = descricao;
        this.fatias = fatias;
        this.acrescimo = acrescimo;
    }

    @Override
    public String getConstante() {
        return constante;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public int getFatias() {
        return fatias;
    }

    public float getAcrescimo() {
        return acrescimo;
    }
}
