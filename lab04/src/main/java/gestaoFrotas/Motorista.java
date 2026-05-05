package gestaoFrotas;

import java.util.ArrayList;

public class Motorista {
    private String nome;
    private String cnh;
    private ArrayList<Veiculo> veiculos;

    public Motorista(String nome, String cnh) {
        this.nome = nome;
        this.cnh = cnh;
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo v) {
        veiculos.add(v);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCnh() {
        return cnh;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public String toString() {
        return String.format("""
                Motorista
                Nome: %s
                CNH: %s""", nome, cnh);
    }

}
