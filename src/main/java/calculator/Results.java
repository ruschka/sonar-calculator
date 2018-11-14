package calculator;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Vojtech Ruschka
 */
public class Results {
    private int counter = 0;
    private List<Integer> result = new LinkedList<>();

    public List<Integer> getResults() {
        return List.copyOf(result);
    }

    public void saveResult() {
        result.add(counter);
    }

    public void add(int arg) {
        counter += arg;
    }

    public void subtract(int arg) {
        counter -= arg;
    }

    public void multiplyBy(int arg) {
        counter *= arg;
    }

    public void divideBy(int arg) {
        counter /= arg;
    }
}
