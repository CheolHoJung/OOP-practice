package vending.machine;

import java.util.ArrayList;
import java.util.List;

public class CoinSet {

    List<Integer> coinSets = new ArrayList<>();
    
    public void add(int coin) {
        this.coinSets.add(coin);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CoinSet)) {
            return false;
        }
        
        return this.toString().equals(obj.toString());
    }
    
    @Override
    public int hashCode() {
        return this.coinSets.hashCode();
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer coin : this.coinSets) {
            builder.append(coin);
        }
        return builder.toString();
    }
}
