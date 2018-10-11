package lotto.ui;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.logging.Logger;

import org.junit.Test;

import lotto.number.LottoNumberTest;
import lotto.ticket.LottoTicket;
import ui.LottoConsole.Asker;

public class LottoConsoleTest {
    
    Logger logger = Logger.getLogger(LottoNumberTest.class.getName());
    
    @Test(expected = InputMismatchException.class)
    public void test_금액입력_실패_숫자아님() throws Exception {
        InputStream in = new ByteArrayInputStream("5000a".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askMoney();
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_금액입력_실패_1000원단위아님() throws Exception {
        InputStream in = new ByteArrayInputStream("1231".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askMoney();
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_로또번호입력_실패_크기() throws Exception {
        InputStream in = new ByteArrayInputStream("1,2,3,4,5".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askLottoTicketNumber();
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_로또번호입력_실패_범위() throws Exception {
        InputStream in = new ByteArrayInputStream("1,2,3,4,5,46".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askLottoTicketNumber();
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_로또번호입력_실패_컴마구분_아님() throws Exception {
        InputStream in = new ByteArrayInputStream("1 2 3 4 5 6".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askLottoTicketNumber();
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_지난주_당첨번호입력_실패_크기() throws Exception {
        InputStream in = new ByteArrayInputStream("1,2,3,4,5".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askWinNumber();
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_지난주_당첨번호입력_실패_범위() throws Exception {
        InputStream in = new ByteArrayInputStream("1,2,3,4,5,46".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askWinNumber();
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_지난주_당첨번호입력_실패_컴마구분_아님() throws Exception {
        InputStream in = new ByteArrayInputStream("1 2 3 4 5 6".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askWinNumber();
    }
    
    @Test(expected = InputMismatchException.class)
    public void test_지난주_보너스당첨번호입력_실패_숫자아님() throws Exception {
        InputStream in = new ByteArrayInputStream("1,2".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askBonusNumber();
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_지난주_보너스당첨번호입력_실패_범위() throws Exception {
        InputStream in = new ByteArrayInputStream("46".getBytes());
        Asker asker = new Asker(in, System.out);
        asker.askBonusNumber();
    }
    
    @Test
    public void test_로또_구매() throws Exception {
        InputStream moneyIn = new ByteArrayInputStream("5000".getBytes());
        Asker moneyAsker = new Asker(moneyIn, System.out);
        final int money = moneyAsker.askMoney();
        final int count = money / LottoTicket.MONEY_PER_TICKET;
        
        final LottoTicket[] lottos = new LottoTicket[count];
        
        for (int i = 0; i < count; i++) {
            InputStream lottoNumberIn = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
            Asker lottoNumberAsker = new Asker(lottoNumberIn, System.out);
            lottos[i] = lottoNumberAsker.askLottoTicketNumber(i + 1);
        }
        
        for (int i = 0; i < lottos.length; i++) {
            logger.info(lottos[i].toString());
        }
    }
}
