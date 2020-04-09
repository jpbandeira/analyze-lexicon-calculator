import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
     /*"((-423 + 2) - (-12+ -16)/67 * (2**2)/2)"*/
    private Token token = null;
    private List<String> array = new ArrayList<>();
    private List<Token> result = new ArrayList<>();

    Pattern pattern = Pattern.compile("[/]|[)]|[(]|[-]?[0-9]+|[-]|[+]|[*]*");
    Pattern patternCaracteresInvalidos = Pattern.compile("[A-Z]+|[a-z]+");
    /*Pattern patternPontuacao = Pattern.compile("[(]|[)]");*/

    public void analyzeExpression(String input) throws Exception {
            String noSpaceArray = input.replaceAll("\\s*", "");

            Matcher matchers = pattern.matcher(noSpaceArray);
            Matcher matchersCaracteresInvalidos = patternCaracteresInvalidos.matcher(noSpaceArray);
            /*Matcher matchersPontuacao = patternPontuacao.matcher(noSpaceArray);*/

            if (!matchersCaracteresInvalidos.find()) {
                while (matchers.find()){
                    if (!matchers.group().equals("")) {
                        array.add(matchers.group());
                    }
                }
            }else{
                throw new Exception("Caractere Invalido: " + matchersCaracteresInvalidos.group());
            }

/*            boolean teste = true;

            while(matchers.find()) {

                if (matchersNumeroInteiro.find()) {
                    if (!matchersNumeroInteiro.group().equals(""))
                        array.add(matchersNumeroInteiro.group());
                }if(matchersPontuacao.find()){
                    if (!matchersPontuacao.group().equals(""))
                        array.add(matchersPontuacao.group());
                }

            }*/

            checkAtributes();
            showResults();
    }
    
    public void checkAtributes(){
        for(String value:array) {
            switch (value) {
                case "(":
                    token = new Token();
                    token.setLexama(value);
                    token.setTipo("pontuação");
                    token.setValor("parenteseDireito");
                    result.add(token);
                    break;
                case "+":
                    token = new Token();
                    token.setLexama(value);
                    token.setTipo("operador");
                    token.setValor("soma");
                    result.add(token);
                    break;
                case "-":
                    token = new Token();
                    token.setLexama(value);
                    token.setTipo("operador");
                    token.setValor("subtracao");
                    result.add(token);
                    break;
                case "*":
                    token = new Token();
                    token.setLexama(value);
                    token.setTipo("operador");
                    token.setValor("multiplicação");
                    result.add(token);
                    break;
                case "**":
                    token = new Token();
                    token.setLexama(value);
                    token.setTipo("operador");
                    token.setValor("exponenciação");
                    result.add(token);
                    break;
                case "/":
                    token = new Token();
                    token.setLexama(value);
                    token.setTipo("operador");
                    token.setValor("divisão");
                    result.add(token);
                    break;
                case ")":
                    token = new Token();
                    token.setLexama(value);
                    token.setTipo("pontuação");
                    token.setValor("parenteseEsquerdo");
                    result.add(token);
                    break;
            }
            if (isNumber(value) == true) {
                token = new Token();
                token.setLexama(value);
                token.setTipo("numero");
                token.setValor(value);
                result.add(token);
            }

        }
    }

    public boolean isNumber(String value){
        boolean number = value.matches("[-]?[0-9]+");
        return number ? true : false;
    }

    public void showResults(){
        for(Token value:result)
            System.out.println(value.toString());
    }
}
