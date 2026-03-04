package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    protected BankAccount account;

    protected abstract BankAccount createBankAccount();

    @BeforeEach
    public void setUp() {
        this.account = createBankAccount();
    }

    @Test
    public void shouldBeInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void shouldDeposit() {
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }
}
