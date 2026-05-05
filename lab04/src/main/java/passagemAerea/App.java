package passagemAerea;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class App {

    ArrayList<Passageiro> passageiros = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();
    ArrayList<Voo> voos = new ArrayList<>();

    public void menu() {
        int opcao;
        do {
            opcao = Integer.parseInt(IO.readln("""
                    \nEscolha uma opção:
                    1 - Cadastrar voo
                    2 - Excluir voo
                    3 - Cadastrar passageiro
                    4 - Excluir passageiro
                    5 - Reservar passagem
                    6 - Cancelar reserva
                    7 - Sair\n
                    """));

            switch (opcao) {
                case 1 -> cadastrarVoo();
                case 2 -> excluirVoo();
                case 3 -> cadastrarPassageiro();
                case 4 -> excluirPassageiro();
                case 5 -> reservarPassagem();
                case 6 -> cancelarReserva();
                case 7 -> IO.println("Saindo...");
                default -> IO.println("Opção inválida. Digite novamente.");
            }
        } while (opcao != 7);
    }

    public void cadastrarVoo() {
        int numVoo = Integer.parseInt(IO.readln("Digite o número do voo: "));
        String destino = IO.readln("Digite o destino: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data = LocalDate.parse(IO.readln("Digite a data do voo (dd-mm-aaaa): "));
        LocalTime hora = LocalTime.parse(IO.readln("Digite a hora do voo (hh:mm): "));
        int capacidade = Integer.parseInt(IO.readln("Digite a capacidade máxima do voo: "));

        Voo voo = new Voo(numVoo, destino, data, hora, capacidade);
        voos.add(voo);

        IO.println("Voo cadastrado com sucesso!");
    }

    public void excluirVoo() {
        listarVoos();
        int n = Integer.parseInt(IO.readln("Digite o numero do voo que deseja excluir: "));
        if (n > 0 && n < voos.size()) {
            Voo v = voos.get(n-1);
            voos.remove(v);
        }
    }

    public void cadastrarPassageiro() {
        String nome = IO.readln("Digite o nome do passageiro: ");
        String email = IO.readln("Digite o email: ");
        String telefone = IO.readln("Digite o telefone: ");

        Passageiro p = new Passageiro(nome, email, telefone);
        passageiros.add(p);

        IO.println("Passageiro cadastrado");
    }

    public void excluirPassageiro() {
        listarPassageiros();
        int n = Integer.parseInt(IO.readln("Digite o numero do passageiro que deseja excluir: "));
        if (n > 0 && n < passageiros.size()) {
            Passageiro p = passageiros.get(n - 1);
            passageiros.remove(p);
            reservas.removeIf(r -> r.getPassageiro().equals(p));
            IO.println("Passageiro removido com sucesso!");
        } else {
            IO.println("Passageiro não encontrado");
        }
    }

    public void reservarPassagem() {
        String nomePassageiro = IO.readln("Digite o nome do passageiro: ");
        Passageiro p = null;
        for (Passageiro pass : passageiros) {
            if (p.getNome().equalsIgnoreCase(nomePassageiro)) {
                p = pass;
                break;
            }
        }

        if (p == null) {
            IO.println("Passageiro não encontrado");
            return;
        }

        listarVoos();
        int nVoo = Integer.parseInt(IO.readln("Digite o numero do voo que deseja reserva: "));
        if (nVoo < 1 || nVoo > voos.size()) {
            IO.println("Voo inválido");
            return;
        }

        Voo v = voos.get(nVoo -1);

        int assento = Integer.parseInt(IO.readln("Digite o número do assentos: "));
        Reserva r = new Reserva(assento, v, p);

        if (v.adicionarReserva(r)) {
            reservas.add(r);
            IO.println("Reserva realizada com sucesso!");
        } else {
            IO.println("Voo lotado, não foi possível reservar");
        }
    }

    public void cancelarReserva() {
        listarReservas();
        int n = Integer.parseInt(IO.readln("Digite no número da reserva que deseja cancelar: "));
        if (n > 0 || n < reservas.size()) {
            Reserva r = reservas.get(n - 1);
            r.getVoo().getReservas().remove(r);
            IO.println("Reserva cancelada com sucesso");
        } else {
            IO.println("Reserva não encontrada.");
        }
    }

    private void listarVoos() {
        IO.println("Lista de voos\n");
        int i = 1;
        for (Voo v : voos) {
            IO.println(i++ + " - " + v.getNumVoo());
        }
    }

    private void listarPassageiros() {
        IO.println("Lista de passageiros\n");
        int i = 1;
        for (Passageiro p : passageiros) {
            IO.println(i++ + " - " + p.getNome());
        }
    }

    private void listarReservas() {
        IO.println("Lista de Reservas\n");
        int i = 1;
        for (Reserva r : reservas) {
            IO.println(String.format(""" 
                    %d - Voo %d
                    Passageiro: %s
                    Assento: %d
                    """, i++, r.getVoo().getNumVoo(), r.getPassageiro().getNome(), r.getNumAssento()));
        }
    }

    static void main(String[] args) {
        App app = new App();
        app.menu();
    }

}



