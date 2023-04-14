package br.com.pfeffer.pagamento;

import java.util.Date;

public class Cupom {
    private String codigo;
    private String descricao;
    private Date validade;

    public Cupom(String codigo, String descricao, Date validade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.validade = validade;
    }

    public static void aplicarCupom(Cupom cupom) {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}
