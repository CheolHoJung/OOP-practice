package lotto.ticket;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lotto.number.LottoNumber;

public class LottoTicket {

    public static final int MONEY_PER_TICKET = 1000;
    public static final int MAX_SIZE = 6; 
    
    private static final String REGEX_TO_LOTTO_NUMBERS = "[\\[\\]]";
    private static final String REGEX_TO_SPLIT = "[\\s,]+";
    
    Set<LottoNumber> lottoNumbers;
    
    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        if (lottoNumbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 용지 한장은 " + MAX_SIZE + "개의 숫자여야 합니다. 현재 숫자: " + this.lottoNumbers);
        }
    }
    
    @Override
    public String toString() {
        return "Lotto: " + lottoNumbers.toString() + "";
    }

    public static LottoTicket generateByUserInput(String input) {
        String replace = input.replaceAll(REGEX_TO_LOTTO_NUMBERS, "");
        String[] numbers = replace.split(REGEX_TO_SPLIT);
        Set<LottoNumber> generatedLottoNumbers = Arrays.stream(numbers)
                .map(number -> LottoNumber.valueOf(number))
                .collect(Collectors.toSet());
        return new LottoTicket(generatedLottoNumbers);
    }
    
    public static boolean hasSmallChange(int money) {
        return money % LottoTicket.MONEY_PER_TICKET != 0;
    }

    public static int count(int money) {
        return money / LottoTicket.MONEY_PER_TICKET;
    }
    
    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }
    
    public int getRetainLottoNumberCount(LottoTicket ticket) {
        Set<LottoNumber> copy = new HashSet<>(lottoNumbers);
        copy.retainAll(ticket.lottoNumbers);
        return copy.size();
    }
}
