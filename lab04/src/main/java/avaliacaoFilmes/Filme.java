package avaliacaoFilmes;

import java.util.ArrayList;

public class Filme {
    private String titulo;
    private int anoLancamento;
    private String genero;
    private String diretor;
    private ArrayList<Ator> atores;
    private ArrayList<Avaliacao> avaliacoes;

    public Filme (String titulo, int anoLancamento, String genero, String diretor) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarAtor (Ator ator) {
        atores.add(ator);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public double calcularMediaDasAvaliacoes() {
        
        if (avaliacoes.isEmpty()) {
            return 0.0;
        } else {
            double soma = 0;
            for (Avaliacao a : avaliacoes) {
                soma += a.getNota();
            }
            return soma / avaliacoes.size();
        }
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public ArrayList<Ator> getAtores() {
        return atores;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}
