import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    private String input = "((-423 + 2)--12+-16*2**2/2)";
    //private Token tokenPrincipal = new Token();
    private Token token = null;
    private List<String> array = new ArrayList<>();
    private List<Token> resultado = new ArrayList<>();



    public void analyze(){
        String noSpaceArray = input.replaceAll("\\s*", "");
        Pattern pattern = Pattern.compile("[-]?[0-9]+|[-]|[+]|[*]*");
        Matcher matcher = pattern.matcher(noSpaceArray);
        String[] matchers = pattern.split(noSpaceArray);

        while (matcher.find())
            if(!matcher.group().equals(""))
                array.add(matcher.group());

        for(String valor:matchers)
            if(!valor.equals(""))
                array.add(valor);
        verificarValor();
        mostrar();
    }

    public void mostrar(){
        for(Token valor:resultado){
            System.out.println(valor.getLexama()+" "+valor.getTipo()+" "+valor.getValor());
        }
    }

    public void verificarValor(){
        for(String valorDoArray:array) {
            switch (valorDoArray) {
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
                case "(":
                    token = new Token();
                    token.setLexama(valorDoArray);
                    token.setTipo("pontuação");
                    token.setValor("parenteseDireito");
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
        }
    }
}
