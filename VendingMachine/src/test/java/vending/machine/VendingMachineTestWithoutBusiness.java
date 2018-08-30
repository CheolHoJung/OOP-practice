package vending.machine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * VendingMachineTest class is module to calculate change.
 * But in order to test it, we need to implement the modules what put coins or select beverage.
 * This class concentrate on only module to calculate change.
 * @author jcho
 * @date 2018. 8. 28.
 */
public class VendingMachineTestWithoutBusiness {

    @Test
    public void testReturnChangeCoinSst_oneCoin_50() throws Exception {
        ChangeModule module = new ChangeModule();
        CoinSet expectedCoinSet = new CoinSet();
        expectedCoinSet.add(50);
        
        assertEquals("700원 투입 후 650원 음료 선택", expectedCoinSet, module.getChangeCoinSet(50));
    }
    
    @Test
    public void testReturnChangeCoinSet_coins_180() throws Exception {
        ChangeModule module = new ChangeModule();
        
        CoinSet expectedCoinSet = new CoinSet();
        expectedCoinSet.add(100);
        expectedCoinSet.add(50);
        expectedCoinSet.add(10);
        expectedCoinSet.add(10);
        expectedCoinSet.add(10);
        
        assertEquals("700원 투입 후 520원 음료 선택", expectedCoinSet, module.getChangeCoinSet(180));
    }
}
