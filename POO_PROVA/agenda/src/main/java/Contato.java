import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Contato {
    private String nome;
    private String sobrenome;
    private LocalDate dataNasc;
    private ColecaoTelefone telefones;
    private ColecaoEmail emails;

    // Construtor
    public Contato(String nome, String sobrenome, LocalDate dataNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.telefones = new ColecaoTelefone();
        this.emails = new ColecaoEmail();
    }

    // Adicionar Telefone
    public boolean addTelefone(String rotulo, String valor) {
        return telefones.add(rotulo, valor);
    }

    // Adicionar Email
    public boolean addEmail(String rotulo, String valor) {
        return emails.add(rotulo, valor);
    }

    // Remover Telefone
    public boolean removeTelefone(String rotulo) {
        return telefones.remove(rotulo);
    }

    // Remover Email
    public boolean removeEmail(String rotulo) {
        return emails.remove(rotulo);
    }

    // Atualizar Telefone
    public boolean updateTelefone(String rotulo, String valor) {
        return telefones.update(rotulo, valor);
    }

    // Atualizar Email
    public boolean updateEmail(String rotulo, String valor) {
        return emails.update(rotulo, valor);
    }
    // Formato da data
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //toString()
    @Override
    public String toString() {
        return String.format("""
            Nome Completo: %s %s
            Data de Nascimento: %s
            Telefone(s): 
            %sEmail(s): 
            %s""", nome, sobrenome, dataNasc.format(formato), telefones.toString(), emails.toString());
    }

    // Getters

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}
