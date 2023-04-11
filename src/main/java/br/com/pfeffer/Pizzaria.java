package br.com.pfeffer;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.atendimento.Mensagem;

public class Pizzaria {
    public static void main(String[] args) {
        Mensagem.bemVindo();

        Atendimento.iniciarAtendimento();
    }
}
