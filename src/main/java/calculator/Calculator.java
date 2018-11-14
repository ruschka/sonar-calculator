package calculator;

import calculator.operation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Vojtech Ruschka
 */
public class Calculator {
    private Results results = new Results();
    private List<Function<String, Operation>> operationParsers = Arrays.asList(Add::parse, Subtract::parse, DivideBy::parse, MultiplyBy::parse, Save::parse);

    public List<Integer> run(String inputPath) {
        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {
            return runInternal(stream);
        } catch (IOException e) {
            throw new IllegalStateException("Reading provided input has failed.", e);
        }
    }

    public List<Integer> run(List<String> inputs) {
        return runInternal(inputs.parallelStream());
    }

    private List<Integer> runInternal(Stream<String> inputStream) {
        inputStream
                .flatMap(input -> operationParsers.parallelStream()
                        .map(parser -> parser.apply(input))
                        .filter(Objects::nonNull))
                .forEachOrdered(operation -> operation.process(results));
        return results.getResults();
    }

}
