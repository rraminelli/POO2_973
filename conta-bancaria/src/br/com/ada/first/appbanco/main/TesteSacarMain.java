package br.com.ada.first.appbanco.main;

import br.com.ada.first.appbanco.entity.Conta;
import br.com.ada.first.appbanco.entity.Pessoa;
import br.com.ada.first.appbanco.entity.PessoaFisica;
import br.com.ada.first.appbanco.entity.PessoaJuridica;
import br.com.ada.first.appbanco.enums.TipoConta;
import br.com.ada.first.appbanco.factory.AberturaContaFactory;
import br.com.ada.first.appbanco.factory.DepositoContaFactory;
import br.com.ada.first.appbanco.service.abrirconta.AberturaConta;
import br.com.ada.first.appbanco.service.depositar.Deposito;
import br.com.ada.first.appbanco.service.sacar.Saque;
import br.com.ada.first.appbanco.service.sacar.RealizarSaque;

import java.math.BigDecimal;

public class TesteSacarMain {

    public static void main(String[] args) {

        Pessoa cliente = new PessoaFisica();
        cliente.setNome("Rodrigo");

        AberturaConta aberturaConta = AberturaContaFactory.getAberturaConta(TipoConta.CI);

        Conta conta = aberturaConta.abrirConta(cliente, "0002");
        //conta.setSaldo(new BigDecimal(100));

        Deposito deposito = DepositoContaFactory.getDepositoConta(conta);
        deposito.depositar(conta, new BigDecimal(100));

        Saque operacaoSaque = new RealizarSaque();

        operacaoSaque.sacar(conta, new BigDecimal(10));

        System.out.println(conta);
    }

}
