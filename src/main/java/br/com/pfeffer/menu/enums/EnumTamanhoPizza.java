package br.com.pfeffer.menu.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumTamanhoPizza implements IEnum {
    PEQUENA("PEQUENA", "Pequena - 4 fatias (1 sabor)", 4),
    MEDIA("MEDIA", "Media - 8 fatias (até 2 sabores)", 8),
    GRANDE("GRANDE", "Grande - 12 fatias (até 3 sabores)", 12),
    GIGANTE("GIGANTE", "Gigante - 16 fatias (até 4 sabores)", 16);

    private final String constante;
    private final String descricao;
    private final int fatias;

    EnumTamanhoPizza(String constante, String descricao, int fatias) {
        this.constante = constante;
        this.descricao = descricao;
        this.fatias = fatias;
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
}
