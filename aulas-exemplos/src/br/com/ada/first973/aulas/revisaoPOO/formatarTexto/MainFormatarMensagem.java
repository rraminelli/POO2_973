package br.com.ada.first973.aulas.revisaoPOO.formatarTexto;

import br.com.ada.first973.aulas.revisaoPOO.abstracao.*;

import java.util.Scanner;

public class MainFormatarMensagem {

    public static void main(String[] args) {

        String mensagem = "mensagem de teste";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o formato:");
        String tipo = scanner.nextLine();

        FormatarMensagem formatador = null;

        if ("MI".equals(tipo)) {
            formatador = new FormatarMensagemMinuscula();
        } else if ("MAI".equals(tipo)) {
            formatador = new FormatarMensagemMaiuscula();
        } else if ("DT".equals(tipo)) {
            formatador = new FormatarMensagemComDataHora();
        }

        String mensagemFormatada = formatador.formatarMensagem(mensagem);

        System.out.println(mensagemFormatada);

    }


}
