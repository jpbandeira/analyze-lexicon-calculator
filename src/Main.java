import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Analyzer analyzer = new Analyzer();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Digite a entrada: ");
        input = scanner.nextLine();
        analyzer.analyzeExpression(input);
    }

}
