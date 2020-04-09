import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Token {
    private String lexama;
    private String tipo;
    private String valor;

    public String getLexama() {
        return lexama;
    }

    public void setLexama(String lexama) {
        this.lexama = lexama;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("lexama='").append(lexama).append('\'');
        sb.append(", tipo='").append(tipo).append('\'');
        sb.append(", valor='").append(valor).append('\'');
        return sb.toString();
    }


}
