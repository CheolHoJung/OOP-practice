package vending.machine;

public class VendingMachine {

    int changeAmount;
    
    public void putCoin(int coin) {
        this.changeAmount += coin;
    }

    public int getChangeAmount() {
        return this.changeAmount;
    }
}
