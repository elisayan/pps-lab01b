package it.unibo.pps.e1;

public record SilverBankAccount(CoreBankAccount base) implements BankAccount {

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + 1);
    }
}
