package lotto.rank;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000, "1등"),
    SECOND(5, 30000000, "2등"),
    THIRD(5, 1500000, "3등"),
    FOURTH(4, 50000, "4등"),
    FIFTH(3, 5000, "5등");

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
            .filter(v -> {
                if (matchNumber == 5) {
                    return bonusBall ? v == LottoRank.SECOND : v == LottoRank.THIRD;
                }
                
                return v.matchNumber == matchNumber; 
            })
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(matchNumber + "를 찾을 수 없습니다."));
    }
    
    @Override
    public String toString() {
        return rankString + ": " + matchNumber + "개 일치" +
                (this == LottoRank.SECOND ? ", 보너스 볼 일치" : "") +
                " (" + price + "원)";
    }
}
