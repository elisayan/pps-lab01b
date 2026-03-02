package it.unibo.pps.e1;

public class GoldBankAccount extends BankAccount {

    public GoldBankAccount(CoreBankAccount base) {
        super(base);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return getBalance() - amount >= -500;
    }

    @Override
    protected int feeCalculator(final int amount) {
        return 0;
    }
}
