package gestaoFrotas;

public class Veiculo {
    private String modelo;
    private String placa;
    private int anoFabricacao;

    public Veiculo(String modelo, String placa, int anoFabricacao) {
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }

    // Getters
    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public String toString() {
        return String.format("""
                Veículos
                Modelo: %s
                Placa: %s
                Ano de Fabricação: %d
                """, modelo, placa, anoFabricacao);
    }
}
