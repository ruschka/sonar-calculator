package calculator.operation;

import calculator.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Vojtech Ruschka
 */
class SaveTest {
    @Test
    void testParse() {
        Operation parsed = Save.parse("SAVE");
        Assertions.assertNotNull(parsed);
    }

    @Test
    void testParseUnknownString() {
        Operation parsed = Save.parse("SUBTRACT 5");
        Assertions.assertNull(parsed);
    }

    @Test
    void testProcess() {
        Operation parsed = Save.parse("SAVE");
        Results results = new Results();
        parsed.process(results);
        Assertions.assertEquals(List.of(0), results.getResults());
    }
}
