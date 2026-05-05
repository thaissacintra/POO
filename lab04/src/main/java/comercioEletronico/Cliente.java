package comercioEletronico;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String email;
    private ArrayList<Endereco> enderecos;
    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String email, Endereco endereco){
        this.nome = nome;
        this.email = email;
        this.enderecos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        enderecos.add(endereco);
    }

    public void adicionarPedido (Pedido pedido) {
        pedidos.add(pedido);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public String toString() {
        return String.format("""
            Nome: %s;
            Email: %s
            Endereço: %s""", nome, email, enderecos.get(0).toString());
    }

}





