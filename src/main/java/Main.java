import calculator.Calculator;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vojtech Ruschka
 */
public class Main {
    private static final List<String> INPUTS = Arrays.asList("ADD 5", "SUBTRACT 1", "DIVIDE BY 2", "MULTIPLY BY 10", "SAVE", "ADD 2", "SAVE");

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.run(INPUTS));
    }
}
