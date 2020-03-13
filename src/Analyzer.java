import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    private String input = "((-423 + 2) - (-12+ -16)/67 * (2**2)/2)";
    private Token token = null;
    private List<String> array = new ArrayList<>();
    private List<Token> resultado = new ArrayList<>();

    public void analyze(){
        String noSpaceArray = input.replaceAll("\\s*", "");
        Pattern pattern = Pattern.compile("[/]|[)]|[(]|[-]?[0-9]+|[-]|[+]|[*]*");
        Matcher numbersAndPontuation = pattern.matcher(noSpaceArray);

        while (numbersAndPontuation.find()) {
            if (!numbersAndPontuation.group().equals(""))
                array.add(numbersAndPontuation.group());
        }

        checkAtributes();
        mostrar();
    }
    
    public void checkAtributes(){
        for(String valorDoArray:array) {
            switch (valorDoArray) {
                case "(":
                    token = new Token();
                    token.setLexama(valorDoArray);
                    token.setTipo("pontuação");
                    token.setValor("parenteseDireito");
                    resultado.add(token);
                    break;
                case "+":
                    token = new Token();
                    token.setLexama(valorDoArray);
                    token.setTipo("operador");
                    token.setValor("soma");
                    resultado.add(token);
                    break;
                case "-":
                    token = new Token();
                    token.setLexama(valorDoArray);
                    token.setTipo("operador");
                    token.setValor("subtracao");
                    resultado.add(token);
                    break;
                case "*":
                    token = new Token();
                    token.setLexama(valorDoArray);
                    token.setTipo("operador");
                    token.setValor("multiplicação");
                    resultado.add(token);
                    break;
                case "**":
                    token = new Token();
                    token.setLexama(valorDoArray);
                    token.setTipo("operador");
                    token.setValor("exponenciação");
                    resultado.add(token);
                    break;
                case "/":
                    token = new Token();
                    token.setLexama(valorDoArray);
                    token.setTipo("operador");
                    token.setValor("divisão");
                    resultado.add(token);
                    break;
                case ")":
                    token = new Token();
                    token.setLexama(valorDoArray);
                    token.setTipo("pontuação");
                    token.setValor("parenteseEsquerdo");
                    resultado.add(token);
                    break;
            }
            if (isNumber(valorDoArray) == true) {
                token = new Token();
                token.setLexama(valorDoArray);
                token.setTipo("numero");
                token.setValor(valorDoArray);
                resultado.add(token);
            }

        }
    }

    public boolean isNumber(String value){
        boolean number = value.matches("[-]?[0-9]+");
        return number ? true : false;
    }

    public void mostrar(){
        for(Token valor:resultado)
            System.out.println(valor.toString());
    }
}
