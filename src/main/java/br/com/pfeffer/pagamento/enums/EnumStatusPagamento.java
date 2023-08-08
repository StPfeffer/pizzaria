package br.com.pfeffer.pagamento.enums;

import br.com.pfeffer.core.interfaces.IEnum;

public enum EnumStatusPagamento implements IEnum<String> {
    AGUARDANDO_PAGAMENTO("AGUARDANDO_PAGAMENTO", "Aguardando Pagamento"),
    PENDENTE("PENDENTE", "Pagamento Pendente"),
    CANCELADO("CANCELADO", "Pagamento Cancelado"),
    REEMBOLSADO("REEMBOLSADO", "Pagamento Reembolsado"),
    FATURADO("FATURADO", "Pagamento Faturado");

    private final String constante;
    private final String descricao;

    EnumStatusPagamento(String constante, String descricao) {
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
