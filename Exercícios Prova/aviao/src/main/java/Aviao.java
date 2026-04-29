import java.util.ArrayList;

public class Aviao {
    private int maxTripulates;
    private int maxPassageiros;
    private double capacidadeCombustivel;
    private ArrayList<Motor> motores;

    public Aviao(int maxTripulates, int maxPassageiros, double capacidadeCombustivel, String tipoMotor, int qtdMotores) {
        this.maxTripulates = maxTripulates;
        this.maxPassageiros = maxPassageiros;
        this.capacidadeCombustivel = capacidadeCombustivel;
        this.motores = new ArrayList<>();
        // Validação da quantidade de motores
        if (qtdMotores < 1 || qtdMotores > 8) {
            qtdMotores = 8;
        }
        // Criar a quantidade de motores solicitadas
        for (int i = 0; i < qtdMotores; i++) {
            this.motores.add(new Motor(tipoMotor));
        }
    }
    // Liga todos os motores
    public void ligarAviao() {
        for (Motor m : motores) {
            m.ligarMotor();
        }
        IO.println("Todos os motores foram ligados\n");
    }

    // Desliga todos os motores
    public void desligarAviao() {
        for (Motor m : motores) {
            m.desligarMotor();
        }
        IO.println("Todos os motores foram desligados\n");
    }

    // Ligar motores individualmente
    public void ligarIndividualmente(int posicao) {
        int indice = posicao - 1; // Transforma "motor 1" em indice 0

        if (indice >= 0 && indice < motores.size()) {
            motores.get(indice).ligarMotor();
            System.out.format("O motor %d foi ligado\n", posicao);
        } else {
            System.out.format("O motor %d não existe\n", posicao);
        }
    }

}

