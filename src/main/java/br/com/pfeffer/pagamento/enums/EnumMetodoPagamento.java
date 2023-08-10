package br.com.pfeffer.pagamento.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumMetodoPagamento implements IEnum<String> {
    CARTAO_DEBITO("CARTAO_DEBITO", "Cartão de Débito"),
    CARTAO_CREDITO("CARTAO_CREDITO", "Cartão de Crédito"),
    PIX("PIX", "Pix"),
    DINHEIRO("DINHEIRO", "Dinheiro");

    private final String constante;
    private final String descricao;

    EnumMetodoPagamento(String constante, String descricao) {
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
