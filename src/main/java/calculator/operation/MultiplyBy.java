package calculator.operation;

import calculator.Results;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vojtech Ruschka
 */
public class MultiplyBy extends MathOperation {
    private static final String NAME = "MULTIPLY BY";
    private static final Pattern REGEX = Pattern.compile("^" + NAME + " (-?\\d*)$");

    private MultiplyBy(String argument) {
        super(argument);
    }

    public static Operation parse(String input) {
        Matcher matcher = REGEX.matcher(input);
        if (matcher.matches()) {
            return new MultiplyBy(matcher.group(1));
        } else {
            return null;
        }
    }

    @Override
    void doMathOperation(Results results, int arg) {
        results.multiplyBy(arg);
    }
}
