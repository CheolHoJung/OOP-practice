package main.calculator;

public class Calculator {

    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] nums = text.split(",");
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }

        return result;
    }
}
