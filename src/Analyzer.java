import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    private Token token = new Token();

    private String input = "(-423 - -12 - -16 * 2 ** 2 / 2)";
    String noSpaceArray = input.replaceAll("\\s*", "");

    String regexNumber = "[0-9]";
    String regexAllNumber = "[0-9]*";

    private List<String> array = new ArrayList<>();

    Pattern pattern = null;
    Matcher matcher = null;

    public boolean isNumber(String regexNumber, String input){
        pattern = Pattern.compile(regexNumber);
        matcher = pattern.matcher(input);

        while (matcher.find()) {
            return true;
        }
        return false;
    }

    public String getNumber(String regexNumber, String input){
        pattern = Pattern.compile(regexNumber);
        matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
            return matcher.group();
        }
            return "";

    }

    public void analyze(){

        while (true) {
            if (isNumber(regexNumber, noSpaceArray)) {
                String teste = getNumber(regexAllNumber, noSpaceArray);
                System.out.println(teste);
            }
        }
        //mostrar();
    }

    public void mostrar(){
        for(String valor:array){
            System.out.println(valor);
        }
    }

    public void verificarValor(String valor){
        switch (valor){
            case "+":
                token.setValor("soma");
                break;
            case "-":
                token.setValor("subtracao");
                break;
            case "/":
                token.setValor("divisao");
                break;
            case "*":
                token.setValor("multiplicacao");
                break;
            case "**":
                token.setValor("exponenciacao");
                break;
            case "(":
                token.setValor("parenteseEsquerdo");
                break;
            case ")":
                token.setValor("parenteseDireito");
                break;
        }
    }
}
