import java.util.ArrayList;
import java.util.Arrays;
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
    Pattern patternCaracteresInvalidos = Pattern.compile("[A-Z]|[a-z]");
    String anterior = "";
    StringBuffer stringBufferCaracteresInvalidos = new StringBuffer();

    public void analyzeExpression(String input) throws Exception {
        String noSpaceArray = input.replaceAll("\\s*", "");

        Matcher matchers = pattern.matcher(noSpaceArray);
        Matcher matchersCaracteresInvalidos = patternCaracteresInvalidos.matcher(noSpaceArray);

        if (!matchersCaracteresInvalidos.find()) {
            while (matchers.find()) {
                if (!matchers.group().equals("")) {
                    array.add(matchers.group());
                }
            }
        } else {
            stringBufferCaracteresInvalidos.append("[ ");
            while (matchersCaracteresInvalidos.find()) {
                stringBufferCaracteresInvalidos.append(matchersCaracteresInvalidos.group() + ", ");
            }
            stringBufferCaracteresInvalidos.append("]");
            throw new Exception("Caracteres Invalidos: " + stringBufferCaracteresInvalidos.toString());
        }

        checkAtributes();
        showResults();
    }

    public void checkAtributes() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String value : array) {
            char[] valor = value.toCharArray();
            if (valor.length > 1 && valor[0] == '-' && isNumber(String.valueOf(valor[1])) && !checkValues(anterior)) {
                int i = 1;
                token = new Token(String.valueOf(valor[0]), "operador", "subtracao");
                result.add(token);
                if (isNumber(String.valueOf(valor[i]))) {
                    while (i < valor.length) {
                        char valorChar = valor[i];
                        stringBuffer.append(valorChar);
                        i++;
                    }
                    String valueStringBuffer = stringBuffer.toString();
                    token = new Token(valueStringBuffer, "numero", valueStringBuffer);
                    result.add(token);
                    stringBuffer = new StringBuffer();
                }
            } else {
                anterior = value;
                switch (value) {
                    case "(":
                        token = new Token(value, "pontuação", "parenteseDireito");
                        result.add(token);
                        break;
                    case "+":
                        token = new Token(value, "operador", "soma");
                        result.add(token);
                        break;
                    case "-":
                        token = new Token(value, "operador", "subtracao");
                        result.add(token);
                        break;
                    case "*":
                        token = new Token(value, "operador", "multiplicação");
                        result.add(token);
                        break;
                    case "**":
                        token = new Token(value, "operador", "exponenciação");
                        result.add(token);
                        break;
                    case "/":
                        token = new Token(value, "operador", "divisão");
                        result.add(token);
                        break;
                    case ")":
                        token = new Token(value, "pontuação", "parenteseEsquerdo");
                        result.add(token);
                        break;
                }
                if (isNumber(value) == true) {
                    token = new Token(value, "numero", value);
                    result.add(token);
                }
            }
        }
    }

    public boolean isNumber(String value) {
        boolean number = value.matches("[-]?[0-9]+");
        return number ? true : false;
    }

    public void showResults() {
        for (Token value : result)
            System.out.println(value.toString());
    }

    public boolean checkValues(String value) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("-", "(", ")", "+", "*", "**", "/"));
        for (String valueOfList : list) {
            if (valueOfList.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
