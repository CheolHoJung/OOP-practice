package vending.machine;

public class ChangeModule {

    public CoinSet getChangeCoinSet(int changeAmount) {
        CoinSet coinSet = new CoinSet();
        
        int remainChangeAmount = changeAmount;
        for (Coin coin : Coin.values()) {
            remainChangeAmount = addCoinsToCoinSet(remainChangeAmount, coinSet, coin);
        }
        
        return coinSet;
    }

    private int addCoinsToCoinSet(int changeAmount, CoinSet coinSet, Coin coin) {
        while (coin.isLessThanOrEqualTo(changeAmount)) {
            changeAmount = coin.changeAmount(changeAmount);
            coinSet.add(coin);
        }
        return changeAmount;
    }

}
