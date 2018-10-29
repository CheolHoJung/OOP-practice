package test.calculator;

import main.calculator.Calculator;
import main.calculator.StringCalculator;
import main.splitor.CustomSplitor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void test_passNullAndEmpty() {
        Calculator cal = new StringCalculator();
        assertEquals(0, cal.sum(null));
        assertEquals(0, cal.sum(""));
    }

    @Test
    public void test_passOne() {
        Calculator cal = new StringCalculator();
        assertEquals(10, cal.sum("10"));
    }

    @Test
    public void test_sumUseDefaultSeparator() {
        Calculator cal = new StringCalculator();
        assertEquals(cal.sum("1:2:3:4:5"), 15);
        assertEquals(cal.sum("1,2,3,4,5"), 15);
    }

    @Test
    public void test_sumUseCustomSeparator() {
        Calculator cal = new StringCalculator(new CustomSplitor());
        assertEquals(cal.sum("//^\n1^2^3^4^5"), 15);
    }

    @Test(expected = RuntimeException.class)
    public void test_findNegativeNum() {
        Calculator cal = new StringCalculator();
        cal.sum("1:2:3:4:-5");
    }
}
