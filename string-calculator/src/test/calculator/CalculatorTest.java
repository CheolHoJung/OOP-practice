package test.calculator;

import main.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void test_passNullOrEmpty() {
        Calculator cal = new Calculator();
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
        assertEquals(3, cal.add("3"));
    }

    @Test
    public void test_passCommaSeparator() {
        Calculator cal = new Calculator();
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void test_passColonSeparator() {
        Calculator cal = new Calculator();
        assertEquals(3, cal.add("1:2"));
    }

    @Test
    public void test_passCustomSeparator() {
        Calculator cal = new Calculator();
        assertEquals(3, cal.add("//;\n1;2"));
    }
}
