package calculator.operation;

import calculator.Results;

/**
 * @author Vojtech Ruschka
 */
public abstract class MathOperation implements Operation {
    private String argument;

    MathOperation(String argument) {
        this.argument = argument;
    }

    @Override
    public final void process(Results results) {
        int parsed;
        try {
            parsed = Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Input doesn't contain valid argument: " + argument);
        }
        doMathOperation(results, parsed);
    }

    abstract void doMathOperation(Results results, int arg);
}
