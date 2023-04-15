package br.com.ada.simuladorvendas.service.produto;

import br.com.ada.simuladorvendas.entity.Produto;

import java.util.List;

public interface ProdutoService {

    void cadastrarProduto(Produto produto);

    Produto getProdutoPorCodigo(Integer idProduto);

    List<Produto> getListaProduto();

}
