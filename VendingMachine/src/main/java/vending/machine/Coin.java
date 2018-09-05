package vending.machine;

public enum Coin {

    KRW500(500),
    KRW100(100),
    KRW50(50),
    KRW10(10);
    
    private int amount;
    
    private Coin(int amount) {
        this.amount = amount;
    }
    
    public boolean isLessThanOrEqualTo(int amount) {
        return this.amount <= amount;
    }
    
    public int changeAmount(int amount) {
        return amount - this.amount;
    }
    
}
