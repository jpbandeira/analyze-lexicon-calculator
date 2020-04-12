import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Analyzer analyzer = new Analyzer();
        Scanner scanner = new Scanner(System.in);
        //String input="((-423 + 2) - (-12+ -16)/67 * (2**2)/2)";
        //String input="(42 + (2 - 295))";
        String input="( (42-2) - (2-2) + (32-25874) )";

        //System.out.println("Digite a entrada: ");
        //input = scanner.nextLine();
        System.out.println(input);
        analyzer.analyzeExpression(input);
    }

}
