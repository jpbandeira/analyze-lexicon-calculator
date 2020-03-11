import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Token {
    private String lexama;
    private String tipo;
    private String valor;
    private ArrayList<String> operador = new ArrayList<>();
    private ArrayList<String> pontuacao = new ArrayList<>();

    private ArrayList<Token> resultado = new ArrayList<>();

    public Token(){
        operador.addAll(Arrays.asList("+","-", "*", "**", "/"));
        pontuacao.addAll(Arrays.asList("(",")"));
    }

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

    public ArrayList<String> getOperador() {
        return operador;
    }

    public void setOperador(ArrayList<String> operador) {
        this.operador = operador;
    }

    public ArrayList<String> getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(ArrayList<String> pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ArrayList<Token> getResultado() {
        return resultado;
    }

    public void setResultado(ArrayList<Token> resultado) {
        this.resultado = resultado;
    }
}
