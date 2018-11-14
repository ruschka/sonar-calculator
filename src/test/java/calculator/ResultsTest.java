package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Vojtech Ruschka
 */
class ResultsTest {

    private Results results;

    @BeforeEach
    void init() {
        results = new Results();
    }

    @Test
    void testGetResults() {
        Assertions.assertEquals(List.of(), results.getResults());
    }

    @Test
    void testSave() {
        results.saveResult();
        Assertions.assertEquals(List.of(0), results.getResults());
    }

    @Test
    void testAdd() {
        results.add(5);
        results.saveResult();
        Assertions.assertEquals(List.of(5), results.getResults());
    }

    @Test
    void testSubtract() {
        results.subtract(5);
        results.saveResult();
        Assertions.assertEquals(List.of(-5), results.getResults());
    }

    @Test
    void testMultiplyBy() {
        results.add(5);
        results.multiplyBy(3);
        results.saveResult();
        Assertions.assertEquals(List.of(15), results.getResults());
    }

    @Test
    void testDivideBy() {
        results.add(5);
        results.divideBy(3);
        results.saveResult();
        Assertions.assertEquals(List.of(1), results.getResults());
    }

    @Test
    void testReturnedListIsImmutable() {
        results.add(5);
        results.saveResult();
        List<Integer> firstResult = this.results.getResults();
        Assertions.assertEquals(List.of(5), firstResult);
        results.add(3);
        results.saveResult();
        List<Integer> secondResult = this.results.getResults();
        Assertions.assertEquals(List.of(5), firstResult);
        Assertions.assertEquals(List.of(5, 8), secondResult);
    }
}
