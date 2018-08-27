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
}
