package passagemAerea;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Voo {
    private int numVoo;
    private String destino;
    private LocalDate data;
    private LocalTime hora;
    private int capacidadeMax;
    private ArrayList<Reserva> reservas;

    public Voo(int numVoo, String destino, LocalDate data, LocalTime hora, int capacidadeMax) {
        this.numVoo = numVoo;
        this.destino = destino;
        this.data = data;
        this.hora = hora;
        this.capacidadeMax = capacidadeMax;
        this.reservas = new ArrayList<>();
    }

    public boolean adicionarReserva(Reserva r) {
        if (reservas.size() < capacidadeMax) {
            reservas.add(r);
            return true;
        }
        return false;
    }

    public int lugaresDisponiveis() {
        return capacidadeMax - reservas.size();
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public int getNumVoo() {
        return numVoo;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

}





