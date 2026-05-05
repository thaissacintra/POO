package passagemAerea;

public class Reserva {
    private int numAssento;
    private Voo voo;
    private Passageiro passageiro;

    public Reserva(int numAssento, Voo voo, Passageiro passageiro) {
        this.numAssento = numAssento;
        this.voo = voo;
        this.passageiro = passageiro;
    }

    public int getNumAssento() {
        return numAssento;
    }

    public Voo getVoo() {
        return voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }
}
