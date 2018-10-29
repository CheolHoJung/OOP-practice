package test.splitor;

import main.splitor.CustomSplitor;
import main.splitor.DefaultSplitor;
import main.splitor.Splitor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SplitorTest {

    @Test
    public void test_splitUseDefault() {
        Splitor splitor = new DefaultSplitor();
        assertEquals(splitor.split("1:2:3:4:5").length, 5);
        assertEquals(splitor.split("1:2:3:4:5").length, 5);
    }

    @Test
    public void test_splitUseCustomRegex() {
        Splitor splitor = new CustomSplitor();
        assertEquals(splitor.split("//^\n1^2^3^4^5").length, 5);
    }
}
