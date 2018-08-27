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
        
        while (changeAmount >= 500) {
            changeAmount -= 500;
            coinSet.add(500);
        }
        
        while (changeAmount >= 100) {
            changeAmount -= 100;
            coinSet.add(100);
        }
        
        while(changeAmount >= 50) {
            changeAmount -= 50;
            coinSet.add(50);
        }
        
        while (changeAmount >= 10) {
            changeAmount -= 10;
            coinSet.add(10);
        }
        
        return coinSet;
    }
}
