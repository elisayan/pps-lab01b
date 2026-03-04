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
    public void shouldWithdraw(){
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void shouldAllowOverdraftUpTo500(){
        this.account.deposit(500);
        this.account.withdraw(1000);
        assertEquals(-500, this.account.getBalance());
    }

    @Test
    public void shouldThrowWhenOverdraftExceeds500(){
        this.account.deposit(500);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}
