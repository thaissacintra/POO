package gestaoFrotas;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {
    private ArrayList<Veiculo> frota;
    private ArrayList<Motorista> motoristas;
    private ArrayList<RegistroUso> registros;

    public void cadastrarVeiculos(Veiculo v) {
        frota.add(v);
    }

    public void cadastrarMotorista(Motorista m) {
        motoristas.add(m);
    }

    public void registrarUso (Veiculo v, Motorista m, LocalDate data, double distancia) {
        registros.add(new RegistroUso(data, distancia, m, v));
    }

    public void listarUso() {
        for (RegistroUso u : registros) {
            IO.println(u);
        }
    }

    public double calcularDistanciaTotal(Veiculo v) {
        double soma = 0;
        for (RegistroUso u : registros) {
            if (u.getVeiculo().equals(v)) {
                soma += u.getDistanciaPercorrida();
            }
        }
        return soma;
    }
}
