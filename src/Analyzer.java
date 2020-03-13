import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    private String input = "423";
    String noSpaceString = input.replaceAll("\\s*", "");
    private Token token = new Token();
    private List<String> array = new ArrayList<>();

    public boolean isNumber(){

        if(noSpaceString.matches("[0-9]*")){
            return true;
        }


        return false;
    }

    public void getNumber(){
        Pattern pattern = Pattern.compile("[-]?[0-9]*");
        Matcher matcher = pattern.matcher(noSpaceString);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public void analyze(){

        if(isNumber()){
            getNumber();
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
