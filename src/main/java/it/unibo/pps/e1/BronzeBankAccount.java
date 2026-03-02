package it.unibo.pps.e1;

public class BronzeBankAccount extends BankAccount {

    public BronzeBankAccount(CoreBankAccount base) {
        super(base);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return getBalance() >= amount;
    }

    @Override
    protected int feeCalculator(final int amount) {
        return amount < 100 ? 0 : 1;
    }
}
