package avaliacaoFilmes;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Avaliacao avaliarFilme(Filme filme, int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao(nota, comentario, this);
        avaliacoes.add(avaliacao);
        filme.adicionarAvaliacao(avaliacao);
        return avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}
