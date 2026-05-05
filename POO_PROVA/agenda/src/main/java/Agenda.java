import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos;

    // Construtor
    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    // Adicionar contato
    public boolean addContato(Contato c) {
        if (c == null) {
            return false;
        }
        return contatos.add(c);
    }

    // Encontrar contato
    public ArrayList<Contato> findContato(String nome, String sobrenome) {
        ArrayList<Contato> find = new ArrayList<>();
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome) && c.getSobrenome().equalsIgnoreCase(sobrenome)) {
                find.add(c);
            }
        }
        return find;
    }

    // Remover contato
    public boolean removeContato(int indiceContatoNaLista) {
        if (indiceContatoNaLista >= 0 && indiceContatoNaLista < contatos.size()) {
            contatos.remove(indiceContatoNaLista);
            return true;
        }
        return false;
    }

    // Adicionar telefone
    public boolean addTelefone(String rotulo, String valor, int indiceContatoNaLista) {
        if (indiceContatoNaLista >= 0 && indiceContatoNaLista < contatos.size()) {
            Contato c = contatos.get(indiceContatoNaLista);
            return c.addTelefone(rotulo, valor);
        }
        return false;
    }

    // Adicionar email
    public boolean addEmail(String rotulo, String valor, int indiceContatoNaLista) {
        if (indiceContatoNaLista >= 0 && indiceContatoNaLista < contatos.size()) {
            Contato c = contatos.get(indiceContatoNaLista);
            return c.addEmail(rotulo, valor);
        }
        return false;
    }

    // Atualizar telefone
    public boolean updateTelefone(String rotulo, String valor, int indiceContatoNaLista) {
        if (indiceContatoNaLista >= 0 && indiceContatoNaLista < contatos.size()) {
            Contato c = contatos.get(indiceContatoNaLista);
            return c.updateTelefone(rotulo, valor);
        }
        return false;
    }

    // Atualizar email
    public boolean updateEmail(String rotulo, String valor, int indiceContatoNaLista) {
        if (indiceContatoNaLista >= 0 && indiceContatoNaLista < contatos.size()) {
            Contato c = contatos.get(indiceContatoNaLista);
            return c.updateEmail(rotulo, valor);
        }
        return false;
    }

    // Remover telefone
    public boolean removeTelefone(String rotulo, int indiceContatoNaLista) {
        if (indiceContatoNaLista >= 0 && indiceContatoNaLista < contatos.size()) {
            Contato c = contatos.get(indiceContatoNaLista);
            return c.removeTelefone(rotulo);
        }
        return false;
    }

    // Remover email
    public boolean removeEmail(String rotulo, int indiceContatoNaLista) {
        if (indiceContatoNaLista >= 0 && indiceContatoNaLista < contatos.size()) {
            Contato c = contatos.get(indiceContatoNaLista);
            return c.removeEmail(rotulo);
        }
        return false;
    }

    // toString()
    @Override
    public String toString(){
        return contatos.toString();
    }

    // Getter
    public ArrayList<Contato> getContatos() {
        return contatos;
    }
}

