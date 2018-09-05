package lotto.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.math3.geometry.partitioning.Side;

import lotto.number.LottoNumber;
import lotto.rank.LottoRank;
import lotto.ticket.LottoTicket;

public class LottoMachine {

    LottoTicket winNumberTicket;
    
    LottoNumber bonusNumber;
    
    LottoStatistics statistics;
    
    public LottoMachine() {
        statistics = new LottoStatistics();
    }
    
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
        
        LottoRank result = LottoRank.valueOf(count, targetLottoTicket.contains(bonusNumber));
        statistics.add(result, targetLottoTicket);
        return result;
    }

    public void setWinNumberTicket(LottoTicket winNumberTicket) {
        this.winNumberTicket = winNumberTicket;
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoStatistics statistics() {
        return this.statistics;
    }
    
    public static class LottoStatistics {

        Map<LottoRank, List<LottoTicket>> board;
        
        public LottoStatistics() {
            board = new HashMap<>();
            board.put(LottoRank.FIRST, new ArrayList<>());
            board.put(LottoRank.SECOND, new ArrayList<>());
            board.put(LottoRank.THIRD, new ArrayList<>());
            board.put(LottoRank.FOURTH, new ArrayList<>());
            board.put(LottoRank.FIFTH, new ArrayList<>());
            board.put(LottoRank.NONE, new ArrayList<>());
        }
        
        int size(LottoRank rank) {
            return board.get(rank).size();
        }
        
        void add(LottoRank rank, LottoTicket ticket) {
            board.get(rank).add(ticket);
        }

        int rateOfReturn() {
            int inputMoney = (int) (board.values()
                    .stream()
                    .filter(l -> l.size() != 0)
                    .flatMap(l -> l.stream())
                    .count()) * LottoTicket.MONEY_PER_TICKET;
            
            int winMoney = board.keySet()
                    .stream()
                    .reduce(0,
                        (acc, cur) -> acc + (cur.getPrice() * board.get(cur).size()),
                        (i1, i2) -> i1 + i2);
            
            return winMoney / inputMoney * 100;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(LottoRank.FIFTH + " - " + size(LottoRank.FIFTH) + "개\n");
            sb.append(LottoRank.FOURTH + " - " + size(LottoRank.FOURTH) + "개\n");
            sb.append(LottoRank.THIRD + " - " + size(LottoRank.THIRD) + "개\n");
            sb.append(LottoRank.SECOND + " - " + size(LottoRank.SECOND) + "개\n");
            sb.append(LottoRank.FIRST + " - " + size(LottoRank.FIRST) + "개\n");
            sb.append("총 수익률은 " + rateOfReturn() + "%입니다.");
            return sb.toString();
        }
    }
}
