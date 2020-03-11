import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    private String input = "(-423 - -12 - -16 * 2 ** 2 / 2)";
    private Token token = new Token();
    private List<String> array = new ArrayList<>();



    public void analyze(){

        String noSpaceArray = input.replaceAll("\\s*", "");
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(noSpaceArray);



        while (matcher.find())
        System.out.println(matcher.group());
        
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
