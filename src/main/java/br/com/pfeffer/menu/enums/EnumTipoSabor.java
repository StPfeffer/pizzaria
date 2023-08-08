package br.com.pfeffer.menu.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumTipoSabor implements IEnum<String> {
    SALGADA("SALGADA", "Pizzas Salgadas"),
    DOCE("DOCE", "Pizzas Doces");

    private final String constante;
    private final String descricao;

    EnumTipoSabor(String constante, String descricao) {
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
