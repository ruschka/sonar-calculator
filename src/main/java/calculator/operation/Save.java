package calculator.operation;

import calculator.Results;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vojtech Ruschka
 */
public class Save implements Operation {
    private static final String NAME = "SAVE";
    private static final Pattern REGEX = Pattern.compile("^" + NAME + "$");

    private Save() {}

    public static Operation parse(String input) {
        Matcher matcher = REGEX.matcher(input);
        if (matcher.matches()) {
            return new Save();
        } else {
            return null;
        }
    }

    @Override
    public void process(Results results) {
        results.saveResult();
    }
}
