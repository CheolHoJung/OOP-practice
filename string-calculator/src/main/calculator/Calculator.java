package main.calculator;

public class Calculator {

    public int add(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        String[] nums = text.split(",");
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }

        return result;
    }

    private boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
