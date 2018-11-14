package calculator.operation;

import calculator.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Vojtech Ruschka
 */
class SubtractTest {
    @Test
    void testParse() {
        Operation parsed = Subtract.parse("SUBTRACT 5");
        Assertions.assertNotNull(parsed);
    }

    @Test
    void testParseNegativeArgument() {
        Operation parsed = Subtract.parse("SUBTRACT -5");
        Assertions.assertNotNull(parsed);
    }

    @Test
    void testParseUnknownString() {
        Operation parsed = Subtract.parse("ADD 5");
        Assertions.assertNull(parsed);
    }

    @Test
    void testProcess() {
        Operation parsed = Subtract.parse("SUBTRACT 5");
        Results results = new Results();
        parsed.process(results);
        results.saveResult();
        Assertions.assertEquals(List.of(-5), results.getResults());
    }
}
