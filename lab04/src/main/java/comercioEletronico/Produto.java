package comercioEletronico;

public class Produto {

    private String descricao;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String descricao, double preco, int quantidadeEstoque) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void atualizarEstoque(int quantidade){
        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
        } else {
            IO.println("Estoque insuficiente");
        }
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public String toString() {
        return String.format("""
                Produto %s ---- Preço: %.2f
                Quantidade no Estoque: %d""", descricao, preco, quantidadeEstoque);
    }
}
