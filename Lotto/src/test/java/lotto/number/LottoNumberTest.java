package lotto.number;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

public class LottoNumberTest {
    
    Logger logger = Logger.getLogger(LottoNumberTest.class.getName());
    
    @Test(expected = IllegalArgumentException.class)
    public void test_로또번호_생성실패_최소범위미만() throws Exception {
        @SuppressWarnings("unused")
        LottoNumber lottoNumber = LottoNumber.valueOf(0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_로또번호_생성실패_최대범위초과() throws Exception {
        @SuppressWarnings("unused")
        LottoNumber lottoNumber = LottoNumber.valueOf(46);
    }
    
    @Test
    public void test_로또번호_숫자로생성() throws Exception {
        assertNotNull(LottoNumber.valueOf(10));
    }
    
    @Test
    public void test_로또번호_문자열로생성() throws Exception {
        assertNotNull(LottoNumber.valueOf("40"));
    }
    
    @Test
    public void test_번호출력() throws Exception {
        LottoNumber lottoNumber = LottoNumber.valueOf(10);
        logger.info(lottoNumber.toString());
    }
    
    @Test
    public void test_동일성() throws Exception {
        LottoNumber lottoNumberA = LottoNumber.valueOf(10);
        assertEquals(LottoNumber.valueOf(10), lottoNumberA);
    }
    
    @Test
    public void test_동일성_실패() throws Exception {
        LottoNumber lottoNumberA = LottoNumber.valueOf(10);
        assertNotEquals(LottoNumber.valueOf(11), lottoNumberA);
    }
    
    @Test
    public void test_해쉬코드_동일성() throws Exception {
        LottoNumber lottoNumberA = LottoNumber.valueOf(10);
        assertEquals(LottoNumber.valueOf(10).hashCode(), lottoNumberA.hashCode());
    }
    
    @Test
    public void test_해쉬코드_동일성_실패() throws Exception {
        LottoNumber lottoNumberA = LottoNumber.valueOf(10);
        assertNotEquals(LottoNumber.valueOf(11).hashCode(), lottoNumberA.hashCode());
    }
}
