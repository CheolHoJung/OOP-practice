package lotto.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public LottoRank raffle(LottoTicket ticket) {
        int count = winNumberTicket.getRetainLottoNumberCount(ticket);
        LottoRank result = LottoRank.valueOf(count, ticket.contains(bonusNumber));
        statistics.add(result, ticket);
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

        Map<LottoRank, List<LottoTicket>> board = new HashMap<>();
        
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
            int inputMoney = getTicketCount() * LottoTicket.MONEY_PER_TICKET;
            int winMoney = board.keySet()
                    .stream()
                    .reduce(0,
                        (money, rank) -> money + rank.getPrice(getTicketCount(rank)),
                        (result1, result2) -> result1 + result2);
            
            return winMoney / inputMoney * 100;
        }
        
        private int getTicketCount() {
            return (int) board.values()
                    .stream()
                    .filter(ticketOfRank -> ticketOfRank.size() != 0)
                    .flatMap(ticketOfRank -> ticketOfRank.stream())
                    .count();
        }
        
        private int getTicketCount(LottoRank rank) {
            return board.get(rank).size();
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("\n당첨통계\n--------\n");
            sb.append(LottoRank.FIFTH + " - " + size(LottoRank.FIFTH) + "개\n")
              .append(LottoRank.FOURTH + " - " + size(LottoRank.FOURTH) + "개\n")
              .append(LottoRank.THIRD + " - " + size(LottoRank.THIRD) + "개\n")
              .append(LottoRank.SECOND + " - " + size(LottoRank.SECOND) + "개\n")
              .append(LottoRank.FIRST + " - " + size(LottoRank.FIRST) + "개\n")
              .append("총 수익률은 " + rateOfReturn() + "%입니다.");
            return sb.toString();
        }
    }
}
