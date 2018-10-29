package main.calculator;

import main.splitor.DefaultSplitor;
import main.splitor.Splitor;

public class StringCalculator implements Calculator {

    private Splitor splitor;

    public StringCalculator() {
        this(new DefaultSplitor());
    }

    public StringCalculator(Splitor splitor) {
        this.splitor = splitor;
    }

    @Override
    public int sum(String input) {
        int result = 0;
        for (int num : splitor.split(input)) {
            if (num < 0) {
                throw new RuntimeException();
            }
            result += num;
        }
        return result;
    }
}
