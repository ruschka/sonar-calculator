package calculator.operation;

import calculator.Results;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vojtech Ruschka
 */
public class Add extends MathOperation {
    private static final String NAME = "ADD";
    private static final Pattern REGEX = Pattern.compile("^" + NAME + " (-?\\d*)$");

    private Add(String argument) {
        super(argument);
    }

    public static Operation parse(String input) {
        Matcher matcher = REGEX.matcher(input);
        if (matcher.matches()) {
            return new Add(matcher.group(1));
        } else {
            return null;
        }
    }

    @Override
    void doMathOperation(Results results, int arg) {
        results.add(arg);
    }
}
