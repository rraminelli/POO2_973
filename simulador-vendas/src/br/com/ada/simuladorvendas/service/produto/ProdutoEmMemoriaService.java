package br.com.ada.simuladorvendas.service.produto;

import br.com.ada.simuladorvendas.entity.Produto;

import java.math.BigDecimal;
import java.util.*;

public class ProdutoEmMemoriaService implements ProdutoService {

    private Map<Integer, Produto> listaProdutos = new HashMap<>();

    @Override
    public void cadastrarProduto(Produto produto) {
        if (produto.getNome() == null) {
            throw new RuntimeException("Nome é obrigatorio");
        }
        if (produto.getPrecoVenda() == null || produto.getPrecoVenda().equals(BigDecimal.ZERO)) {
            throw new RuntimeException("Preço de venda é obrigatorio");
        }
        if (produto.getQtdeEstoque() == null) {
            throw new RuntimeException("Qtde em estoque é obrigatorio");
        }

        listaProdutos.put(produto.getCodigo(), produto);
    }

    @Override
    public Produto getProdutoPorCodigo(Integer idProduto) {
        if (!listaProdutos.containsKey(idProduto)) {
            throw new RuntimeException("Produto nao encontrado");
        }
        return listaProdutos.get(idProduto);
    }

    @Override
    public List<Produto> getListaProduto() {
        return listaProdutos.values().stream().toList();
    }

}
