package main.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        return sum(parseInts(split(text)));
    }

    private boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher matcher = Pattern.compile("\\/\\/(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        return text.split("[,:]");
    }

    private int[] parseInts(String[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = toPositiveInt(values[i]);
        }
        return result;
    }

    private int toPositiveInt(String value) {
        int result = Integer.parseInt(value);
        if (result < 0) {
            throw new RuntimeException();
        }
        return result;
    }

    private int sum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }
}
