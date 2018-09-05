package vending.machine;

import java.util.ArrayList;
import java.util.List;

public class CoinSet {

    List<Coin> coinSets = new ArrayList<>();
    
    public void add(Coin coin) {
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
        for (Coin coin : this.coinSets) {
            builder.append(coin);
        }
        return builder.toString();
    }
}
