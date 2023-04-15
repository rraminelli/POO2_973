package br.com.ada.simuladorvendas.service.venda;

import br.com.ada.simuladorvendas.entity.ItemVenda;
import br.com.ada.simuladorvendas.entity.Pessoa;
import br.com.ada.simuladorvendas.entity.Produto;
import br.com.ada.simuladorvendas.entity.Venda;
import br.com.ada.simuladorvendas.service.venda.validacao.ValidaVenda;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RealizarVendaService implements VendaService {

    private Map<Integer, ItemVenda> carrinhoCompras = new HashMap<>();

    private List<ValidaVenda> validaVendaList;

    public RealizarVendaService(List<ValidaVenda> validaVendaList) {
        this.validaVendaList = validaVendaList;
    }

    @Override
    public void adicionarProdutoCarrinho(Produto produto) {
        if (carrinhoCompras.containsKey(produto.getCodigo())) {
            ItemVenda itemVenda = carrinhoCompras.get(produto.getCodigo());
            itemVenda.setQtde(itemVenda.getQtde() + 1);
        } else {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(produto);
            itemVenda.setQtde(1);
            carrinhoCompras.put(produto.getCodigo(), itemVenda);
        }
    }

    @Override
    public Venda finalizarVenda(Pessoa cliente) {

        Venda venda = new Venda();
        venda.setDataHoraVenda(LocalDateTime.now());
        venda.setItensVenda(carrinhoCompras.values().stream().toList());
        venda.setCliente(cliente);
        venda.setId(new Random().nextInt(1, 100));

        for (ValidaVenda validaVenda : validaVendaList) {
            validaVenda.validar(venda);
        }

        carrinhoCompras = new HashMap<>();

        return venda;
    }

    @Override
    public void imprimirDadosVenda(Venda venda) {

        String dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(venda.getDataHoraVenda());

        StringBuilder sb = new StringBuilder()
                .append("\n\n")
                .append("Data da venda: ").append(dataFormatada).append("\n")
                .append("Nome cliente: ").append(venda.getCliente().getNome()).append("\n")
                .append("\nItens:\n");

        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ItemVenda itemVenda : venda.getItensVenda()) {

            BigDecimal valorTotalItem = itemVenda.getProduto().getPrecoVenda()
                    .multiply(BigDecimal.valueOf(itemVenda.getQtde()))
                    .setScale(2, RoundingMode.HALF_UP);

                    sb
                    .append(itemVenda.getQtde()).append(" x ")
                    .append(" R$ ").append(itemVenda.getProduto().getPrecoVenda())
                    .append(" - ").append(itemVenda.getProduto().getNome())
                    .append(" R$ ").append(valorTotalItem).append("\n");

            valorTotal = valorTotal.add(valorTotalItem);

        }

        sb.append("\nTotal: R$ ").append(valorTotal).append("\n");

        System.out.println(sb.toString());

    }
}
