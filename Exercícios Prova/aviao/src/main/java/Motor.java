public class Motor {
    private String tipoMotor; // turbina ou hélice
    private boolean estadoMotor;

    public Motor(String tipoMotor) {
        if ("turbina".equalsIgnoreCase(tipoMotor) || "hélice".equalsIgnoreCase(tipoMotor)) {
            this.tipoMotor = tipoMotor;
        } else {
            this.tipoMotor = "hélice";
        }
        this.estadoMotor = false; // todo motor começa desligado
    }

    public void ligarMotor() {
        this.estadoMotor = true;
    }

    public void desligarMotor() {
        this.estadoMotor = false;
    }

}
