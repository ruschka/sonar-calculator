package calculator.operation;

import calculator.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Vojtech Ruschka
 */
class AddTest {
    @Test
    void testParse() {
        Operation parsed = Add.parse("ADD 5");
        Assertions.assertNotNull(parsed);
    }

    @Test
    void testParseNegativeArgument() {
        Operation parsed = Add.parse("ADD -5");
        Assertions.assertNotNull(parsed);
    }

    @Test
    void testParseUnknownString() {
        Operation parsed = Add.parse("SUBTRACT 5");
        Assertions.assertNull(parsed);
    }

    @Test
    void testProcess() {
        Operation parsed = Add.parse("ADD -5");
        Results results = new Results();
        parsed.process(results);
        results.saveResult();
        Assertions.assertEquals(List.of(-5), results.getResults());
    }
}
