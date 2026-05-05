import java.util.HashMap;

public class ColecaoEmail {
    private HashMap<String, String> dados = new HashMap<>();
    // regex para validação do email
    private final String REGEX_ER = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    // verificar a validade do email
    public boolean validarEmail(String email) {
        return email.matches(REGEX_ER);
    }

    // adicionar valores
    public boolean add(String rotulo, String valor) {
        if (dados.containsKey(rotulo)) {
            return false;
        }
        if (!validarEmail(valor)) {
            return false;
        }
        dados.put(rotulo, valor);
        return true;
    }

    public boolean remove(String rotulo) {
        if (dados.containsKey(rotulo)) {
            dados.remove(rotulo);
            return true;
        }
        return false;
    }

    public boolean update(String rotulo, String valor) {
        if (dados.containsKey(rotulo)) {
            dados.put(rotulo, valor);
            return true;
        }
        return false;
    }

    //toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        dados.forEach((rotulo, valor) ->
                sb.append(rotulo)
                        .append(": ")
                        .append(valor)
                        .append("\n"));
        return sb.toString();
    }
}
