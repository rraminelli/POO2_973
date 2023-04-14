package br.com.ada.first.appbanco.service.transferencia;

import br.com.ada.first.appbanco.entity.Conta;
import br.com.ada.first.appbanco.factory.DepositoContaFactory;
import br.com.ada.first.appbanco.factory.SaqueContaFactory;
import br.com.ada.first.appbanco.service.depositar.Deposito;
import br.com.ada.first.appbanco.service.sacar.Saque;

import java.math.BigDecimal;

public class TransferenciaContaPadrao {

    public void transferir(Conta contaOrigem, Conta contaDestino, BigDecimal valorTransferencia) {

        Saque saque = SaqueContaFactory.getSaqueConta(contaOrigem);
        saque.sacar(contaOrigem, valorTransferencia);

        Deposito deposito = DepositoContaFactory.getDepositoConta(contaDestino);
        deposito.depositar(contaDestino, valorTransferencia);

    }

}
