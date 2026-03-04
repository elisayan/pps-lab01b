package it.unibo.pps.e1;

public class BronzeBankAccount extends BankAccount {

    public BronzeBankAccount(final CoreBankAccount base) {
        super(base);
    }

    @Override
    protected boolean canWithdraw(final int amount) {
        return getBalance() >= amount;
    }

    @Override
    protected int feeCalculator(final int amount) {
        return amount < 100 ? 0 : 1;
    }
}
