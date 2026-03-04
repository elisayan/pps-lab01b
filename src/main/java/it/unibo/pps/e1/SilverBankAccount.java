package it.unibo.pps.e1;

public class SilverBankAccount extends BankAccount {

    private static final int FEE_AMOUNT = 1;

    public SilverBankAccount(final CoreBankAccount base) {
        super(base);
    }

    @Override
    protected boolean canWithdraw(final int amount) {
        return getBalance() >= amount;
    }

    @Override
    protected int feeCalculator(final int amount) {
        return FEE_AMOUNT;
    }
}
