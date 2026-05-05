package comercioEletronico;

import java.util.ArrayList;

public class App {
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;

    public App() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }


    void menu(){
        int opcao;
        do {
            opcao = Integer.parseInt(IO.readln("""
                    Entre com uma opção: 
                    1 - Cadastrar cliente 
                    2 - Cadastrar produto 
                    3 - Fazer pedido 
                    4 - Cancelar pedido 
                    5 - Sair\n"""));

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarProduto();
                case 3 -> fazerPedido();
                case 4 -> cancelarPedido();
                case 5 -> IO.println("Saindo...");
                default -> IO.println("Opção inválida. Digite novamente.");
            }
        } while (opcao != 5);
    }

    public void cadastrarCliente(){
        String nome = IO.readln("Digite o nome: ");
        String email = IO.readln("Digite o email: ");
        IO.println("Informe seu endereço");
        String rua = IO.readln("Digite a rua: ");
        String bairro = IO.readln("Digite o bairro: ");
        String cidade = IO.readln("Digite a cidade: ");
        String cep = IO.readln("Digite o CEP: ");

        Endereco endereco = new Endereco(rua, bairro, cidade, cep);
        Cliente cliente = new Cliente(nome, email, endereco);
        clientes.add(cliente);

        IO.println("Cliente cadastrado com sucesso!");
        IO.println();
    }

    public void cadastrarProduto(){
        String continuar;
        do {
            String descricao = IO.readln("Digite a descrição do produto: ");
            double preco = Double.parseDouble(IO.readln("Digite o preço do produto: "));
            int quantidade = Integer.parseInt(IO.readln("Digite a quantidade em estoque: "));

            Produto produto = new Produto(descricao, preco, quantidade);
            produtos.add(produto);

            IO.println("Produto cadastrado com sucesso");
            continuar = IO.readln("Deseja continuar cadastrando produto? (s/n): ");
            IO.println();
        } while (continuar.equalsIgnoreCase("s"));

        IO.println();
    }

    private Cliente buscarClientePorNome(String nome){
        for (Cliente c : clientes){
            if (c.getNome().equalsIgnoreCase(nome)){
                return c;
            }
        }
        return null; // se não encontrar
    }

    private Produto buscarProdutoPorNome(String nomeProduto) {
        for (Produto p : produtos) {
            if (p.getDescricao().equalsIgnoreCase(nomeProduto)){
                return p;
            }
        }
        return null;
    }

    public void fazerPedido(){
        if (clientes.isEmpty()) {
            IO.println("Nenhum cliente cadastrado");
            return;
        }

        String nomeCliente = IO.readln("Digite o nome do cliente: ");
        Cliente cliente = buscarClientePorNome(nomeCliente);

        if (cliente == null) {
            IO.println("Cliente não encontrado");
            IO.println();
            return;
        }

        if (produtos.isEmpty()) {
            IO.println("Não há produto cadastrado");
            IO.println();
            return;
        }

        Pedido pedido = new Pedido(java.time.LocalDate.now());

        String continuar;
        do {
            //Mostrar todos os produtos cadastrados
            IO.println("Produtos disponíveis:");

            for (Produto p: produtos) {
                IO.println(p);
            }

            String nomeProduto = IO.readln("Digite o nome do produto: ");
            Produto produto = buscarProdutoPorNome(nomeProduto);

            if (produto != null) {
                int qnt = Integer.parseInt(IO.readln("Digite a quantidade: "));
                pedido.adicionarProduto(produto, qnt);
            } else {
                IO.println("Produto não encontrado");
            }
            continuar = IO.readln("Deseja adicionar mais produtos? (s/n): ");
            IO.println();
        } while (continuar.equalsIgnoreCase("s"));

        cliente.adicionarPedido(pedido);
        IO.println("Pedido realizado com sucesso!");
        // Mostra o resumo do pedido
        IO.println(pedido.toString());
        IO.println();
    }

    public void cancelarPedido() {
        String nomeCliente = IO.readln("Digite o nome do cliente: ");
        Cliente cliente = buscarClientePorNome(nomeCliente);

        if (cliente == null) {
            IO.println("Cliente não encontrado");
            return;
        }
        if (cliente.getPedidos().isEmpty()) {
            IO.println("Esse cliente não possui pedidos");
            return;
        }

        Pedido pedido = cliente.getPedidos().get(cliente.getPedidos().size() - 1);
        pedido.cancelarPedido();

    }

    static void main(String[] args) {
        App app = new App();
        app.menu();

    }
}
