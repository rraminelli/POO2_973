package br.com.ada.first.appbanco.factory;

import br.com.ada.first.appbanco.service.transferencia.TransferenciaContaPadrao;

public class TransferenciaContaFactory {

    public static TransferenciaContaPadrao getTransferenciaConta() {

        TransferenciaContaPadrao transferencia = new TransferenciaContaPadrao();

        return transferencia;

    }

}
