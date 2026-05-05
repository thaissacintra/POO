package avaliacaoFilmes;

import java.util.ArrayList;

public class Avaliacao {

    private int nota;
    private String comentario;
    private Usuario usuario;

    public Avaliacao(int nota, String comentario, Usuario usuario) {
        this.nota = nota;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
