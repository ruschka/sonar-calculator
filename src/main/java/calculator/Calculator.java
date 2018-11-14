package calculator;

import calculator.operation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author Vojtech Ruschka
 */
public class Calculator {
    private Results results = new Results();
    private List<Function<String, Operation>> operationParsers = Arrays.asList(Add::parse, Subtract::parse, DivideBy::parse, MultiplyBy::parse, Save::parse);

    public List<Integer> run(List<String> inputs) {
        inputs.parallelStream()
            .flatMap(input -> operationParsers.parallelStream()
                    .map(parser -> parser.apply(input))
                    .filter(Objects::nonNull))
            .forEachOrdered(operation -> operation.process(results));
        return results.getResults();
    }

}
