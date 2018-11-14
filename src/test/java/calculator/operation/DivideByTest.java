package calculator.operation;

import calculator.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Vojtech Ruschka
 */
class DivideByTest {
    @Test
    void testParse() {
        Operation parsed = DivideBy.parse("DIVIDE BY 5");
        Assertions.assertNotNull(parsed);
    }

    @Test
    void testParseNegativeArgument() {
        Operation parsed = DivideBy.parse("DIVIDE BY -5");
        Assertions.assertNotNull(parsed);
    }

    @Test
    void testParseUnknownString() {
        Operation parsed = DivideBy.parse("SUBTRACT 5");
        Assertions.assertNull(parsed);
    }

    @Test
    void testProcess() {
        Operation parsed = DivideBy.parse("DIVIDE BY -5");
        Results results = new Results();
        parsed.process(results);
        results.saveResult();
        Assertions.assertEquals(List.of(0), results.getResults());
    }

    @Test
    void testDivideByZero() {
        Operation parsed = DivideBy.parse("DIVIDE BY 0");
        Results results = new Results();
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> parsed.process(results));
        Assertions.assertEquals("Impossible to divide by 0.", e.getMessage());
    }
}
