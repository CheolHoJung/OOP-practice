package vending.machine;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendingMachineTest {

    @Test // 잔액학인
    public void testGetChangeAmount() throws Exception {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        assertEquals("투입금액 100원", 100, machine.getChangeAmount());
        
        machine.putCoin(500);
        assertEquals("투입금액 500원", 600, machine.getChangeAmount());
    }
    
    @Test // 거스름돈 50원
    public void testReturnChangeCoinSet_oneCoin_50() throws Exception {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        machine.putCoin(100);
        machine.putCoin(500);
        machine.selectDrink(new Drink("Cola", 650));
        
        CoinSet expectedCoinSet = new CoinSet();
        expectedCoinSet.add(Coin.KRW50);
        
        assertEquals("700원 투입 후 650원 음료 선택", expectedCoinSet, machine.getChangeCoinSet());
    }
    
    @Test // 거스름돈 180원
    public void testReturnChangeCoinSet_coins_180() throws Exception {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        machine.putCoin(100);
        machine.putCoin(500);
        machine.selectDrink(new Drink("Soda", 520));
        
        CoinSet expectedCoinSet = new CoinSet();
        expectedCoinSet.add(Coin.KRW100);
        expectedCoinSet.add(Coin.KRW50);
        expectedCoinSet.add(Coin.KRW10);
        expectedCoinSet.add(Coin.KRW10);
        expectedCoinSet.add(Coin.KRW10);
        
        assertEquals("700원 투입 후 520원 음료 선택", expectedCoinSet, machine.getChangeCoinSet());
    }
}
