package avaliacaoFilmes;

import java.time.LocalDate;

public class Ator {
    private String nome;
    private LocalDate dataNasc;

    public Ator (String nome, LocalDate dataNasc) {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }
}
