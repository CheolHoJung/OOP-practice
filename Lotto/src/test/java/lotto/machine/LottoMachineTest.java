package lotto.machine;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;

public class LottoMachineTest {
    
    @Test
    public void test_추첨_1등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        int result = machine.raffle(userInputLottoTicket);
        assertEquals(1, result);
    }
    
    @Test
    public void test_추첨_2등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,4,5,10");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        int result = machine.raffle(userInputLottoTicket);
        assertEquals(2, result);
    }
    
    @Test
    public void test_추첨_3등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,4,5,11");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        int result = machine.raffle(userInputLottoTicket);
        assertEquals(3, result);
    }
    
    @Test
    public void test_추첨_4등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,4,20,11");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        int result = machine.raffle(userInputLottoTicket);
        assertEquals(4, result);
    }
    
    @Test
    public void test_추첨_5등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,30,20,11");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        int result = machine.raffle(userInputLottoTicket);
        assertEquals(5, result);
    }
}
