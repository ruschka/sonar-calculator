package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vojtech Ruschka
 */
class CalculatorTest {
    @Test
    void testCalculator() {
        List<String> inputs = Arrays.asList("ADD 5", "SUBTRACT 1", "DIVIDE BY 2", "MULTIPLY BY 10", "SAVE", "ADD 2", "SAVE");
        Calculator calculator = new Calculator();
        List<Integer> result = calculator.run(inputs);
        Assertions.assertEquals(List.of(20, 22), result);
    }
}
