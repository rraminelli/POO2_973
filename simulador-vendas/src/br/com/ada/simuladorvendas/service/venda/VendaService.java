package br.com.ada.simuladorvendas.service.venda;

import br.com.ada.simuladorvendas.entity.Pessoa;
import br.com.ada.simuladorvendas.entity.Produto;
import br.com.ada.simuladorvendas.entity.Venda;

public interface VendaService {

    void adicionarProdutoCarrinho(Produto produto);

    Venda finalizarVenda(Pessoa cliente);

    void imprimirDadosVenda(Venda venda);

}
