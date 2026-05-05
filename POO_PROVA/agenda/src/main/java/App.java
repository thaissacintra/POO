import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class App {

    Agenda agenda = new Agenda();

    public void menu() {
        int opcao;
        do {
            opcao = Integer.parseInt(IO.readln("""
                    \nEntre com uma opção: 
                    1 - Adicionar contato
                    2 - Remover contato
                    3 - Atualizar contato
                    4 - Listar um contato
                    5 - Listar todos contatos
                    6 - Sair\n"""));

            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> removerContato();
                case 3 -> atualizarContato();
                case 4 -> listarUmContato();
                case 5 -> listarTodosContatos();
                case 6 -> IO.println("Saindo...");
                default -> IO.println("Opção inválida. Digite novamente.");
            }
        } while (opcao != 6);
    }

    public void adicionarContato() {
        String nome = IO.readln("Nome: ");
        String sobrenome = IO.readln("Sobrenome: ");
        String data = IO.readln("Data de Nascimento (dd/mm/aaaa): ");
        LocalDate dataNasc = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Contato c = new Contato(nome, sobrenome, dataNasc);

        // Telefones
        String adicionarTel = IO.readln("Deseja adicionar telefone(s)? (s/n): ");
        while (adicionarTel.equalsIgnoreCase("s")) {
            String rotuloTel = IO.readln("Digite o rótulo do telefone (ex: celular, casa): ");
            String numeroTel = IO.readln("Digite o número: ");
            c.addTelefone(rotuloTel, numeroTel);
            adicionarTel = IO.readln("Deseja adicionar outro telefone? (s/n): ");
        }

        // Emails
        String adicionarEmail = IO.readln("Deseja adicionar email(s)? (s/n): ");
        while (adicionarEmail.equalsIgnoreCase("s")) {
            String rotuloEmail = IO.readln("Digite o rótulo do email (ex: pessoal, comercial): ");
            String enderecoEmail = IO.readln("Digite o endereço de email: ");
            c.addEmail(rotuloEmail, enderecoEmail);
            adicionarEmail = IO.readln("Deseja adicionar outro email? (s/n): ");
        }

        if (agenda.addContato(c)) {
            IO.println("Contato adicionado com sucesso!");
        } else {
            IO.println("Erro ao adicionar contato");
        }
    }

    public void removerContato() {
        listarTodosContatos(); // mostra a lista numerada
        int indice = Integer.parseInt(IO.readln("Digite o índice do contato que deseja remover: "));
        if (agenda.removeContato(indice)) {
            IO.println("Contato removido com sucesso");
        } else {
            IO.println("Erro. Índice inválido");
        }
    }

    public void atualizarContato() {
        listarTodosContatos();
        int indice = Integer.parseInt(IO.readln("Digite o índice do contato que deseja atualizar: "));
        String tipo = IO.readln("Deseja atualizar telefone ou email?: ");

        if (tipo.equalsIgnoreCase("telefone")) {
            String rotulo = IO.readln("Digite o rótulo do telefone: ");
            String valor = IO.readln("Digite o número do telefone");
            if (agenda.updateTelefone(rotulo, valor, indice)) {
                IO.println("Telefone atualizado com sucesso");
            } else {
                IO.println("Erro ao atualizar o telefone");
            }
        } else if (tipo.equalsIgnoreCase("email")) {
            String rotulo = IO.readln("Digite o rótulo do email: ");
            String valor = IO.readln("Digite o email: ");
            if (agenda.updateEmail(rotulo, valor, indice)) {
                IO.println("Email atualizado com sucesso");
            } else {
                IO.println("Erro ao atualizar o email");
            }
        } else {
            IO.println("Opção Inválida");
        }
    }

    public void listarUmContato() {
        String nome = IO.readln("Digite o nome: ");
        String sobrenome = IO.readln("Digite o sobrenome: ");
        var find = agenda.findContato(nome, sobrenome);

        if (find.isEmpty()) {
            IO.println("Nenhum contato encontrado");
        } else {
            for (Contato c : find) {
                IO.println(c.toString());
            }
        }
    }

    public void listarTodosContatos() {
        IO.println("Lista de contatos:");
        int i = 0;
        for (Contato c : agenda.getContatos()) {
            IO.println("[" + i + "] " + c.toString());
            i++;
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }
}
