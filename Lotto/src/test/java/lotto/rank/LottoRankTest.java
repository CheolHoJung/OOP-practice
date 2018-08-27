package lotto.rank;

import static org.junit.Assert.*;

import org.junit.Test;

public class LottoRankTest {
    
    @Test
    public void test_1등() throws Exception {
        assertEquals(LottoRank.FIRST, LottoRank.valueOf(6, false));
    }
    
    @Test
    public void test_2등() throws Exception {
        assertEquals(LottoRank.SECOND, LottoRank.valueOf(5, true));
    }
    
    @Test
    public void test_3등() throws Exception {
        assertEquals(LottoRank.THIRD, LottoRank.valueOf(5, false));
    }
    
    @Test
    public void test_4등() throws Exception {
        assertEquals(LottoRank.FOURTH, LottoRank.valueOf(4, false));
    }
    
    @Test
    public void test_5등() throws Exception {
        assertEquals(LottoRank.FIFTH, LottoRank.valueOf(3, false));
    }
    
    @Test
    public void test_결과없음() throws Exception {
        assertEquals(LottoRank.NONE, LottoRank.valueOf(7, false));
    }
}
