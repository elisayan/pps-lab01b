package it.unibo.pps.e1;

public abstract class BankAccount {

    private final CoreBankAccount base;

    public BankAccount(CoreBankAccount base) {
        this.base = base;
    }

    public int getBalance() {
        return this.base.getBalance();
    }

    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (!this.canWithdraw(amount)) {
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + feeCalculator(amount));
    }

    protected abstract boolean canWithdraw(int amount);

    protected abstract int feeCalculator(int amount);
}