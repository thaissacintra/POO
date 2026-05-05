package comercioEletronico;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;

    public Endereco (String rua, String bairro, String cidade, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String toString(){
        return String.format("""
                Rua: %s
                Bairro: %s
                Cidade: %s
                CEP: %s""", rua, bairro, cidade, cep);
    }

}
