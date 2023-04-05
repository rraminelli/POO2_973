package br.com.ada.first.appbanco.service.sacar;

import br.com.ada.first.appbanco.entity.Conta;

import java.math.BigDecimal;

public class SacarContaCorrente implements Sacar {

    @Override
    public void sacar(Conta conta, BigDecimal valorSaque) {
        Sacar.super.sacar(conta, valorSaque);
    }

}
