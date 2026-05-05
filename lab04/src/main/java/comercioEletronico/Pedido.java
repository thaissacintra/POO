package comercioEletronico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private LocalDate dataPedido;
    private String situacaoPedido;
    private ArrayList<Produto> produtos;
    private ArrayList<Integer> quantidade;

    public Pedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
        this.situacaoPedido = "PENDENTE";
        this.produtos = new ArrayList<>();
        this.quantidade = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int qtd) {
        if (qtd <= produto.getQuantidadeEstoque()) {
            produto.atualizarEstoque(qtd);
            this.produtos.add(produto);
            this.quantidade.add(qtd);
            IO.println("Produto adicionado ao pedido!");
        } else {
            IO.println("Estoque insuficiente para " + produto.getDescricao());
        }
        this.situacaoPedido = "PAGO";
    }

    public void cancelarPedido() {
        produtos.clear();
        quantidade.clear();
        this.situacaoPedido = "CANCELADO";
    }

    public double valorTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco() * quantidade.get(i);
        }
        return total;
    }

    public String toString() {
        String itens = "";
        int i = 0;
        for (Produto produto : produtos) {
            int qtd = quantidade.get(i); // pega a quantidade correspondente
            double subtotal = produto.getPreco() * qtd;

            itens += String.format("""
                     - Produto: %s  --- Quantidade: %d
                     - Valor Unitario: R$%.2f --- Subtotal: R$%.2f%n""", produto.getDescricao(), qtd, produto.getPreco(), subtotal);
            i++;
        }

        return String.format("""
                RESUMO DO PEDIDO
                Pedido feito em %s
                Situação do pedido: %s
                Itens:
                %s
                Total da compra: R$%.2f""", dataPedido, situacaoPedido, itens, valorTotal());
    }
}
