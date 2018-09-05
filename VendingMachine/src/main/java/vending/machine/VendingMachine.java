package vending.machine;

public class VendingMachine {

    int changeAmount;
    
    public void putCoin(int coin) {
        this.changeAmount += coin;
    }

    public int getChangeAmount() {
        return this.changeAmount;
    }
    
    public void selectDrink(Drink drink) {
        this.changeAmount -= drink.price;
    }
    
    public CoinSet getChangeCoinSet() {
        CoinSet coinSet = new CoinSet();
        
        Coin KRW500 = Coin.KRW500;
        Coin KRW100 = Coin.KRW100;
        Coin KRW50 = Coin.KRW50;
        Coin KRW10 = Coin.KRW10;
        
        while (KRW500.isLessThanOrEqualTo(changeAmount)) {
            changeAmount = KRW500.changeAmount(changeAmount);
            coinSet.add(KRW500);
        }
        
        while (KRW100.isLessThanOrEqualTo(changeAmount)) {
            changeAmount = KRW100.changeAmount(changeAmount);
            coinSet.add(KRW100);
        }
        
        while(KRW50.isLessThanOrEqualTo(changeAmount)) {
            changeAmount = KRW50.changeAmount(changeAmount);
            coinSet.add(KRW50);
        }
        
        while (KRW10.isLessThanOrEqualTo(changeAmount)) {
            changeAmount = KRW10.changeAmount(changeAmount);
            coinSet.add(KRW10);
        }
        
        return coinSet;
    }
}
