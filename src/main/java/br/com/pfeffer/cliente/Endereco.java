package br.com.pfeffer.cliente;

import br.com.pfeffer.atendimento.Atendimento;
import br.com.pfeffer.core.utils.LoggerPizzaria;
import br.com.pfeffer.core.utils.Utils;

import java.util.Scanner;

public class Endereco {
    private final int id;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;

    public Endereco(String logradouro, int numero, String complemento, String bairro) {
        this.id = Utils.randomInteger(true);
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
    }

    public static Endereco criarNovoEndereco() {
        LoggerPizzaria.info("Iniciando o cadastro do endereço do cliente", Endereco.class, true, true);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o nome da rua/avenida: ");
        String logradouro = scanner.nextLine();

        System.out.print("Insira o número: ");
        int numero = Utils.checkScannerInputForInteger("Por favor, informe um número: ");

        System.out.print("(Opcional) Complemento: ");
        String complemento = scanner.nextLine().trim();
        complemento = complemento.isEmpty() ? null : complemento;

        System.out.print("(Opcional) Bairro: ");
        String bairro = scanner.nextLine().trim();
        bairro = bairro.isEmpty() ? null : bairro;

        return new Endereco(logradouro, numero, complemento, bairro);
    }

    public int getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
