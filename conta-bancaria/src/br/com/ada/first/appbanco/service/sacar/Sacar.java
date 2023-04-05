package br.com.ada.first.appbanco.service.sacar;

import br.com.ada.first.appbanco.entity.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Sacar {

    BigDecimal TAXA_SAQUE_PJ = new BigDecimal(0.005);

    default void sacar(Conta conta, BigDecimal valorSaque) {

        //recuperar o tipo da pessoa (PF/PJ)
        Pessoa pessoa = null;

        if (conta instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) conta;
            pessoa = contaCorrente.getCliente();
        } else if (conta instanceof ContaPoupanca) {
            ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
            pessoa = contaPoupanca.getCliente();
        } else if (conta instanceof ContaInvestimento) {
            ContaInvestimento contaInvestimento = (ContaInvestimento) conta;
            pessoa = contaInvestimento.getCliente();
        }

        if (pessoa instanceof PessoaJuridica) {
            BigDecimal taxa = valorSaque.multiply(TAXA_SAQUE_PJ);
            valorSaque = valorSaque.add(taxa);
        }

        if (valorSaque.compareTo(conta.getSaldo()) == 1) {
            throw new RuntimeException("Valor do saque maior que o saldo disponivel");
        }

        BigDecimal saldoRestante = conta.getSaldo()
                .subtract(valorSaque)
                .setScale(4, RoundingMode.CEILING);

        conta.setSaldo(saldoRestante);

    }

}
