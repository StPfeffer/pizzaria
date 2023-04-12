package br.com.pfeffer.cliente;

import br.com.pfeffer.core.utils.Utils;

import java.util.Scanner;

public class EnderecoImpl extends Endereco {
    public EnderecoImpl(String logradouro, int numero, String complemento, String bairro) {
        super(logradouro, numero, complemento, bairro);
    }

    public static Endereco criarNovoEndereco() {
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
}
