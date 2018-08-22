package lotto.machine;

import java.util.Iterator;

import lotto.number.LottoNumber;
import lotto.rank.LottoRank;
import lotto.ticket.LottoTicket;

public class LottoMachine {

    LottoTicket winNumberTicket;
    
    LottoNumber bonusNumber;
    
    public LottoRank raffle(LottoTicket targetLottoTicket) {
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
        
        return LottoRank.valueOf(count, targetLottoTicket.contains(bonusNumber));
    }

    public void setWinNumberTicket(LottoTicket winNumberTicket) {
        this.winNumberTicket = winNumberTicket;
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
