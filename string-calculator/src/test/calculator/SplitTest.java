package test.calculator;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SplitTest {

    @Test
    public void test_splitUsingComma() {
        String input = "1,2,3,4";
        String[] expect = new String[] {
                "1", "2", "3", "4"
        };

        assertArrayEquals(expect, input.split(","));
    }

    @Test
    public void test_splitUsingColon() {
        String input = "1:2:3:4";
        String[] expect = new String[] {
                "1", "2", "3", "4"
        };

        assertArrayEquals(expect, input.split(":"));
    }



    @Test
    public void test_splitUsingCustomSeparator() {
        String input = "//;\n1;2;3;4";
        String[] expect = new String[] {
                "1", "2", "3", "4"
        };

        assertArrayEquals(expect, splitUsingCustomSeparator(input));
    }

    private String[] splitUsingCustomSeparator(String input) {
        Pattern p = Pattern.compile("\\/\\/(.)\n(.*)");
        Matcher m = p.matcher(input);
        if (!m.find()) {
            return new String[] { input };
        }
        return m.group(2).split(m.group(1));
    }
}
