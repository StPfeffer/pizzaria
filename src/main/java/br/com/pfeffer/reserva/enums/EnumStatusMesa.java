package br.com.pfeffer.reserva.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumStatusMesa implements IEnum<String> {
    DISPONIVEL("DISPONIVEL", "Mesa Disponível"),
    OCUPADA("OCUPADA", "Mesa Ocupada"),
    RESERVADA("RESERVADA", "Mesa Reservada");

    private final String constante;
    private final String descricao;

    EnumStatusMesa(String constante, String descricao) {
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
