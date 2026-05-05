package avaliacaoFilmes;

import java.util.ArrayList;

public class App {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Filme> filmes = new ArrayList<>();

    public void menu() {
        int opcao;
        do {
            opcao = Integer.parseInt(IO.readln("""
                    \nDigite uma opção:
                    1 - Cadastrar Usuário
                    2 - Excluir Usuário
                    3 - Cadastrar Filme
                    4 - Excluir Filme
                    5 - Avaliar Filme
                    6 - Excluir Avaliação
                    7 - Sair\n"""));
            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> excluirUsuario();
                case 3 -> cadastrarFilme();
                case 4 -> excluirFilme();
                case 5 -> avaliarFilme();
                case 6 -> excluirAvaliacao();
                case 7 -> IO.println("Saindo...");
                default -> IO.println("Opção inválida. Digite novamente");
            }
        } while (opcao != 6);
    }

    public void cadastrarUsuario() {
        String nome = IO.readln("Digite o nome: ");
        String email = IO.readln("Digite o email: ");
        String senha = IO.readln("Digite a senha: ");
        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.add(usuario);
        IO.println("Usuário cadastrado com sucesso!");
    }

    public void excluirUsuario() {
        String nome = IO.readln("Qual o nome do usuário que deseja excluir? ");
        Usuario usuarioEncontrado = null;

        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            usuarios.remove(usuarioEncontrado);
            IO.println("Usuário " + nome + " removido");
        } else {
            IO.println("Usuário não encontrado");
        }
    }

    public void cadastrarFilme() {
        String titulo = IO.readln("Digite o título do filme: ");
        int anoLanc = Integer.parseInt(IO.readln("Digite o ano de lançamento do filme: "));
        String genero = IO.readln("Digite o gênero do filme: ");
        String diretor = IO.readln("Digite o nome do diretor do filme: ");
        Filme filme = new Filme(titulo, anoLanc, genero, diretor);
        filmes.add(filme);
        IO.println("Filme cadastrado com sucesso!");
    }

    public void excluirFilme() {
        String titulo = IO.readln("Digite o nome do filme que deseja excluir: ");
        Filme filmeEncontrado = null;
        for (Filme f : filmes) {
            if (f.getTitulo().equalsIgnoreCase(titulo)) {
                filmeEncontrado = f;
                break;
            }
        }

        if (filmeEncontrado != null) {
            filmes.remove(filmeEncontrado);
            IO.println("Filme removido com sucesso");
        } else {
            IO.println("Filma não encontrado");
        }
    }

    public void avaliarFilme() {
        String email = IO.readln("Digite o email do usuário: ");
        String senha = IO.readln("Digite a senha: ");

        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                usuario = u;
                break;
            }
        }

        String titulo = IO.readln("Digite o nome do filme que deseja avaliar: ");
        Filme filme = null;

        for (Filme f : filmes) {
            if (f.getTitulo().equalsIgnoreCase(titulo)) {
                filme = f;
                break;
            }
        }
        if (filme == null) {
            IO.println("Filme nao encontrado");
        }

        int nota;
        do {
            nota = Integer.parseInt(IO.readln("Digite a nota (1 a 5): "));
            if (nota < 1 || nota > 5) {
                IO.println("Nota inválida, digite novamente");
            }
        } while (nota < 1 || nota > 5);

        String comentario = IO.readln("Digite o cometário: ");
        usuario.avaliarFilme(filme, nota, comentario);
        IO.println("Avaliação registrada!");
        IO.println("Media atual do filme: " + filme.calcularMediaDasAvaliacoes());
    }

    public void excluirAvaliacao() {
        String email = IO.readln("Digite o email do usuário: ");
        String senha = IO.readln("Digite a senha: ");

        // autenticação
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            IO.println("Usuário não encontrado ou senha incorreta!");
            return;
        }

        String titulo = IO.readln("Digite o título do filme cuja avaliação deseja excluir: ");
        Filme filme = null;
        for (Filme f : filmes) {
            if (f.getTitulo().equalsIgnoreCase(titulo)) {
                filme = f;
                break;
            }
        }

        if (filme == null) {
            IO.println("Filme não encontrado!");
            return;
        }

        // procurar avaliação do usuário nesse filme
        Avaliacao avaliacaoEncontrada = null;
        for (Avaliacao a : filme.getAvaliacoes()) {
            if (a.getUsuario().equals(usuario)) {
                avaliacaoEncontrada = a;
                break;
            }
        }

        if (avaliacaoEncontrada != null) {
            filme.getAvaliacoes().remove(avaliacaoEncontrada);
            usuario.getAvaliacoes().remove(avaliacaoEncontrada);
            IO.println("Avaliação excluída com sucesso!");
            IO.println("Média atual do filme: " + filme.calcularMediaDasAvaliacoes());
        } else {
            IO.println("Nenhuma avaliação encontrada para este usuário neste filme.");
        }
    }

    public static void main() {
        App app = new App();
        app.menu();

    }
}
