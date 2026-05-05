public class App {
    public static void main(String[] args) {

        Aviao tecoteco = new Aviao(2,2,85,"hélice", 2);

        tecoteco.ligarIndividualmente(1);
        tecoteco.ligarIndividualmente(3);

        tecoteco.ligarAviao();


        Aviao boeing747 = new Aviao(15, 420, 200000, "TURBINA", 4);
        boeing747.ligarAviao();
        boeing747.desligarAviao();
        boeing747.ligarIndividualmente(4);

    }
}
