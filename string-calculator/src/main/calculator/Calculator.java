package main.calculator;

public class Calculator {

    public int add(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        if (text.contains(",")) {
            String[] nums = text.split(",");
            return sum(nums);
        }

        return Integer.parseInt(text);
    }

    private boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private int sum(String[] nums) {
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }
        return result;
    }
}
