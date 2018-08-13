package lotto.ticket;

import static org.junit.Assert.*;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;

public class LottoTicketTest {

    Logger logger = Logger.getLogger(LottoTicketTest.class.getName());
    
    @Test(expected = IllegalArgumentException.class)
    public void test_로또_생성실패_크기() throws Exception {
        @SuppressWarnings("unused")
        LottoTicket lottoTicket = new LottoTicket(IntStream.of(1, 2, 3, 4, 5, 45, 22)
                .mapToObj(i -> LottoNumber.valueOf(i))
                .collect(Collectors.toSet()));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_로또_셍성실패_최소범위미만() throws Exception {
        @SuppressWarnings("unused")
        LottoTicket lottoTicket = new LottoTicket(IntStream.of(0, 1, 2, 3, 4, 5)
                .mapToObj(i -> LottoNumber.valueOf(i))
                .collect(Collectors.toSet()));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_로또_생성실패_최대범위초과() throws Exception {
        @SuppressWarnings("unused")
        LottoTicket lottoTicket = new LottoTicket(IntStream.of(41, 42, 43, 44, 45, 46)
                .mapToObj(i -> LottoNumber.valueOf(i))
                .collect(Collectors.toSet()));
    }
    
    @Test
    public void test_번호목록출력() throws Exception {
        LottoTicket lottoTicket = new LottoTicket(IntStream.of(41, 42, 43, 44, 45, 1)
                .mapToObj(i -> LottoNumber.valueOf(i))
                .collect(Collectors.toSet()));
        
        logger.info(lottoTicket.toString());
    }
    
    @Test
    public void test_로또_생성_문자열() throws Exception {
        String input = "1,2,3,4,5,6";
        LottoTicket lottoTicket = LottoTicket.generateByUserInput(input);
        assertEquals(6, lottoTicket.lottoNumbers.size());
    }
}
