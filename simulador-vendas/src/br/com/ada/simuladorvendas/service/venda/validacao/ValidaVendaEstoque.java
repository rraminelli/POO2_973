package br.com.ada.simuladorvendas.service.venda.validacao;

import br.com.ada.simuladorvendas.entity.ItemVenda;
import br.com.ada.simuladorvendas.entity.Produto;
import br.com.ada.simuladorvendas.entity.Venda;

public class ValidaVendaEstoque implements ValidaVenda {

    @Override
    public void validar(Venda venda) {

        for (ItemVenda itemVenda : venda.getItensVenda()) {

            Produto produto = itemVenda.getProduto();

            if (itemVenda.getQtde().compareTo(produto.getQtdeEstoque()) == 1) {

                throw new RuntimeException("Produto " + produto.getNome() + " nao possui qtde em estoque");
            }

        }

    }

}
