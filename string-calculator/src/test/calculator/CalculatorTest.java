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
    }

    @Test
    public void test_passCommaSeparator() {
        Calculator cal = new Calculator();
        assertEquals(3, cal.add("1,2"));
    }
}
