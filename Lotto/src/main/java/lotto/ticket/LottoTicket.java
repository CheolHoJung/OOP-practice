package lotto.ticket;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lotto.number.LottoNumber;

public class LottoTicket {

    public static final int MONEY_PER_TICKET = 1000;
    
    Set<LottoNumber> lottoNumbers;
    
    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 용지 한장은 6개의 숫자여야 합니다. 현재 숫자: " + this.lottoNumbers);
        }
    }
    
    @Override
    public String toString() {
        return "Lotto: " + lottoNumbers.toString() + "";
    }

    public static LottoTicket generateByUserInput(String input) {
        
        Set<LottoNumber> lottoNumbers = Arrays.stream(input.replaceAll("[\\s\\[\\]]", "").split(","))
                .map(s -> LottoNumber.valueOf(s))
                .collect(Collectors.toSet());
        return new LottoTicket(lottoNumbers);
    }
    
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
    
    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }
    
    public static boolean hasSmallChange(int money) {
        return money % LottoTicket.MONEY_PER_TICKET != 0;
    }
}
