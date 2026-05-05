import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.HashMap;

public class ColecaoTelefone {
    private HashMap<String, String> dados = new HashMap<>();

    // adicionar valor
    public boolean add(String rotulo, String valor) {
        if (dados.containsKey(rotulo)) {
            return false;
        } else {
            String numeroFormatado = formata("(##) #####-####", valor);
            dados.put(rotulo, numeroFormatado);
            return true;
        }
    }

    // remover valor
    public boolean remove(String rotulo) {
        if (dados.containsKey(rotulo)) {
            dados.remove(rotulo);
            return true;
        }
        return false;
    }

    // atualizar valor
    public boolean update(String rotulo, String valor) {
        if (!dados.containsKey(rotulo)) {
            return false;
        } else {
            String numeroFormatado = formata("(##) #####-####", valor);
            dados.put(rotulo, numeroFormatado);
            return true;
        }
    }

    // formatação do telefone
    public String formata(String mascara, String valor){
        MaskFormatter mask = null;
        String resultado = "";
        try {
            mask = new MaskFormatter(mascara);
            mask.setValueContainsLiteralCharacters(false);
            mask.setPlaceholderCharacter('_');
            resultado = mask.valueToString(valor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    // toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        dados.forEach((rotulo, valor) ->
                sb.append(rotulo)
                        .append(": ")
                        .append(valor)
                        .append("\n")
        );
        return sb.toString();
    }

}
