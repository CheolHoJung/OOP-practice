package main.calculator;

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

    private int sum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }

    private int[] parseInts(String[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = Integer.parseInt(values[i]);
        }
        return result;
    }

    private String[] split(String text) {
        return text.split("[,:]");
    }
}
