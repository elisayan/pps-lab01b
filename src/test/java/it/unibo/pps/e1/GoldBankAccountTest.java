package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BankAccountTest {

    private final CoreBankAccount core = new CoreBankAccount();

    @Override
    protected BankAccount createBankAccount() {
        return new GoldBankAccount(this.core);
    }

    @Test
    public void testCanWithdraw(){
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCanOverdraftUpto500Units(){
        this.account.deposit(500);
        this.account.withdraw(1000);
        assertEquals(-500, this.account.getBalance());
    }

    @Test
    public void testIfThrowsExceptionWithNegativeBalanceUpto500Units(){
        this.account.deposit(500);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}
