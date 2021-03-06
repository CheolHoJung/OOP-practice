package lotto.rank;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000, "1등"),
    SECOND(5, 30000000, "2등"),
    THIRD(5, 1500000, "3등"),
    FOURTH(4, 50000, "4등"),
    FIFTH(3, 5000, "5등"),
    NONE(0, 0, "미당첨");

    private int matchNumber;
    
    private int price;
    
    private String rankString;
    
    private LottoRank(int matchNumber, int price, String rankString) {
        this.matchNumber = matchNumber;
        this.price = price;
        this.rankString = rankString;
    }
    
    public static LottoRank valueOf(int matchNumber, boolean bonusBall) {
        return Arrays.stream(LottoRank.values())
            .filter(rank -> {
                if (matchNumber == 5) {
                    return bonusBall ? rank == LottoRank.SECOND : rank == LottoRank.THIRD;
                }
                
                return rank.matchNumber == matchNumber; 
            })
            .findFirst()
            .orElse(LottoRank.NONE);
    }
    
    public int getPrice(int count) {
        return price * count;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(rankString);
        sb.append(": ")
          .append(matchNumber)
          .append("개 일치");
        if (this == SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (")
          .append(price)
          .append("원)");
        
        return sb.toString();
    }
}
