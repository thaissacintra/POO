package gestaoFrotas;

import java.time.LocalDate;

public class RegistroUso {
    private LocalDate data;
    private double distanciaPercorrida;
    private Veiculo veiculo;
    private Motorista motorista;

    public RegistroUso(LocalDate data, double distanciaPercorrida, Motorista motorista, Veiculo veiculo) {
        this.data = data;
        this.distanciaPercorrida = distanciaPercorrida;
        this.motorista = motorista;
        this.veiculo = veiculo;
    }

    // Getters
    public LocalDate getData() {
        return data;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String toString() {
        return String.format("""
                Data: %s
                Motorista: %s
                Veículo: %s
                Distância Percorrida: %.2f""", data, motorista.getNome(), veiculo.getModelo(), distanciaPercorrida);

    }
}
