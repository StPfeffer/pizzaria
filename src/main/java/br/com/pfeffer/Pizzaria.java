package br.com.pfeffer;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.atendimento.Mensagem;
import br.com.pfeffer.core.utils.LoggerPizzaria;

public class Pizzaria {
    public static void main(String[] args) {
        LoggerPizzaria.info("Iniciando o atendimento", Pizzaria.class, true, true);

        Mensagem.bemVindo();

        Atendimento.iniciarAtendimento();
    }
}
