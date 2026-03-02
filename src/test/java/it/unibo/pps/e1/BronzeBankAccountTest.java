package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeBankAccountTest extends BankAccountTest {

    private final CoreBankAccount core = new CoreBankAccount();

    @Override
    protected BankAccount createBankAccount() {
        return new BronzeBankAccount(this.core);
    }

    @Test
    public void testCanWithdrawWithAmountOver100(){
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithAmountBelow100(){
        this.account.deposit(1000);
        this.account.withdraw(50);
        assertEquals(950, this.account.getBalance());
    }
}
