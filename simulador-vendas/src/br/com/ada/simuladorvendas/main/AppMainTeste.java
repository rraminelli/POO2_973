package br.com.ada.simuladorvendas.main;

import br.com.ada.simuladorvendas.entity.Pessoa;
import br.com.ada.simuladorvendas.entity.PessoaFisica;
import br.com.ada.simuladorvendas.entity.Produto;
import br.com.ada.simuladorvendas.entity.Venda;
import br.com.ada.simuladorvendas.service.produto.ProdutoEmMemoriaService;
import br.com.ada.simuladorvendas.service.produto.ProdutoService;
import br.com.ada.simuladorvendas.service.venda.RealizarVendaService;
import br.com.ada.simuladorvendas.service.venda.VendaService;
import br.com.ada.simuladorvendas.service.venda.validacao.ValidaVenda;
import br.com.ada.simuladorvendas.service.venda.validacao.ValidaVendaEstoque;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppMainTeste {

    public static void main(String[] args) {

        Produto produto = null;

        ProdutoService produtoService = iniciarProdutos();

        VendaService vendaService = getVendaService();

        produto = produtoService.getProdutoPorCodigo(1);
        vendaService.adicionarProdutoCarrinho(produto);

        produto = produtoService.getProdutoPorCodigo(4);
        vendaService.adicionarProdutoCarrinho(produto);

        produto = produtoService.getProdutoPorCodigo(4);
        vendaService.adicionarProdutoCarrinho(produto);

        PessoaFisica cliente = new PessoaFisica();
        cliente.setNome("Rodrigo");
        cliente.setCpf("121212121");

        Venda venda = vendaService.finalizarVenda(cliente);

        vendaService.imprimirDadosVenda(venda);

    }

    static VendaService getVendaService() {
        List<ValidaVenda> validaVendaList = new ArrayList<>();
        validaVendaList.add(new ValidaVendaEstoque());
        return new RealizarVendaService(validaVendaList);
    }

    static ProdutoService iniciarProdutos() {
        ProdutoService produtoService = new ProdutoEmMemoriaService();

        Produto produto = null;

        produto = new Produto();
        produto.setCodigo(1);
        produto.setNome("iPhone 12");
        produto.setQtdeEstoque(10);
        produto.setPrecoVenda(new BigDecimal(2300));

        produtoService.cadastrarProduto(produto);

        produto = new Produto();
        produto.setCodigo(2);
        produto.setNome("iPhone 13");
        produto.setQtdeEstoque(5);
        produto.setPrecoVenda(new BigDecimal(3500));

        produtoService.cadastrarProduto(produto);

        produto = new Produto();
        produto.setCodigo(3);
        produto.setNome("Samsung Android 12");
        produto.setQtdeEstoque(10);
        produto.setPrecoVenda(new BigDecimal(3200));

        produtoService.cadastrarProduto(produto);

        produto = new Produto();
        produto.setCodigo(4);
        produto.setNome("Console PS5");
        produto.setQtdeEstoque(2);
        produto.setPrecoVenda(new BigDecimal(4300));

        produtoService.cadastrarProduto(produto);

        return produtoService;

    }

}
