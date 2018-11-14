package calculator.operation;

import calculator.Results;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vojtech Ruschka
 */
public class DivideBy extends MathOperation {
    private static final String NAME = "DIVIDE BY";
    private static final Pattern REGEX = Pattern.compile("^" + NAME + " (-?\\d*)$");

    private DivideBy(String argument) {
        super(argument);
    }

    public static Operation parse(String input) {
        Matcher matcher = REGEX.matcher(input);
        if (matcher.matches()) {
            return new DivideBy(matcher.group(1));
        } else {
            return null;
        }
    }

    @Override
    void doMathOperation(Results results, int arg) {
        if (arg == 0) {
            throw new IllegalStateException("Impossible to divide by 0.");
        }
        results.divideBy(arg);
    }
}
