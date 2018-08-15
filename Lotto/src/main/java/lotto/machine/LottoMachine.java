package lotto.machine;

import java.util.Iterator;

import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;

public class LottoMachine {

    LottoTicket winNumberTicket;
    
    LottoNumber bonusNumber;
    
    public int raffle(LottoTicket targetLottoTicket) {
        Iterator<LottoNumber> winNumbersIterator = winNumberTicket.iterator();
        
        int count = 0;
        while (winNumbersIterator.hasNext()) {
            LottoNumber winNumber = winNumbersIterator.next();
            Iterator<LottoNumber> tartgetNumberIterator = targetLottoTicket.iterator();
            while (tartgetNumberIterator.hasNext()) {
                LottoNumber targetNumber = tartgetNumberIterator.next();
                if (winNumber.equals(targetNumber)) {
                    count++;
                    break;
                }
            }
        }
        
        if (count == 6) {
            return 1;
        } else if (count == 5) {
            if (targetLottoTicket.contains(bonusNumber)) {
                return 2;
            }
            return 3;
        } else if (count == 4) {
            return 4;
        } else if (count == 3) {
            return 5;
        }
        
        return 0;
    }

    public void setWinNumberTicket(LottoTicket winNumberTicket) {
        this.winNumberTicket = winNumberTicket;
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
