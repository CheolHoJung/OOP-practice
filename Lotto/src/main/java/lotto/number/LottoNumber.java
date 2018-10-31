package lotto.number;

public class LottoNumber implements Comparable<LottoNumber> {
    
    final int number;
    
    private LottoNumber(int number) {
        if (isNotBounded(number)) {
            throw new IllegalArgumentException(number + "는 유효하지 않은 로또번호입니다.");
        }

        this.number = number;
    }

    private boolean isNotBounded(int number) {
        return number < 1 || number > 45;
    }

    public static LottoNumber valueOf(int number) {
        return new LottoNumber(number);
    }
    
    public static LottoNumber valueOf(String number) {
        return new LottoNumber(Integer.parseInt(number));
    }
    
    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        
        LottoNumber l = (LottoNumber) o;
        return number == l.number;
    }
    
    @Override
    public int hashCode() {
        return number;
    }
   
}
