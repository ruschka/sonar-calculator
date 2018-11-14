import calculator.Calculator;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vojtech Ruschka
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalStateException("File path is missing.");
        }
        Calculator calculator = new Calculator();
        System.out.println(calculator.run(args[0]));
    }
}
