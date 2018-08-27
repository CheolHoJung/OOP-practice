package lotto.machine;

import static org.junit.Assert.*;

import org.junit.Test;

import lotto.machine.LottoMachine.LottoStatistics;
import lotto.number.LottoNumber;
import lotto.rank.LottoRank;
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
        LottoRank result = machine.raffle(userInputLottoTicket);
        assertEquals(LottoRank.FIRST, result);
    }
    
    @Test
    public void test_추첨_2등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,4,5,10");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        LottoRank result = machine.raffle(userInputLottoTicket);
        assertEquals(LottoRank.SECOND, result);
    }
    
    @Test
    public void test_추첨_3등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,4,5,11");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        LottoRank result = machine.raffle(userInputLottoTicket);
        assertEquals(LottoRank.THIRD, result);
    }
    
    @Test
    public void test_추첨_4등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,4,20,11");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        LottoRank result = machine.raffle(userInputLottoTicket);
        assertEquals(LottoRank.FOURTH, result);
    }
    
    @Test
    public void test_추첨_5등() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("1,2,3,30,20,11");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        LottoRank result = machine.raffle(userInputLottoTicket);
        assertEquals(LottoRank.FIFTH, result);
    }
    
    @Test
    public void test_추첨_미당첨() throws Exception {
        LottoTicket winNumberTicket = LottoTicket.generateByUserInput("1,2,3,4,5,6");
        LottoTicket userInputLottoTicket = LottoTicket.generateByUserInput("7,8,9,10,11,12");
        LottoNumber bonusNumber = LottoNumber.valueOf("10");
        LottoMachine machine = new LottoMachine();
        machine.setWinNumberTicket(winNumberTicket);
        machine.setBonusNumber(bonusNumber);
        LottoRank result = machine.raffle(userInputLottoTicket);
        assertEquals(LottoRank.NONE, result);
    }
}
