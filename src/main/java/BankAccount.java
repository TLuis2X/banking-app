package main.java;

/**
 * A bank account with a balance where we can deposit, withdraw,
 *  and transfer money, and also print an account statement.
 */
public class BankAccount {

    private double balance;
    private AccountTransactions accountTransactions;

    /**
     * Creates bank account with empty balance.
     */
    public BankAccount(){
        this.balance = 0;
        accountTransactions = new AccountTransactions(this);
    }

    /**
     * Creates bank account with given balance.
     * @param initialBalance the initial balance
     */
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        accountTransactions = new AccountTransactions(this);
    }

    /**
     * Deposits money into bank account.
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        this.balance += amount;
        accountTransactions.addTransaction(amount,"deposit");
    }

    /**
     * Withdraws money from bank account.
     * @param amount the amount withdrawn
     * @throws BalanceOverdraftException the exception thrown if amount is greater than
     * the current balance
     */
    public void withdraw(double amount) throws BalanceOverdraftException {
        if (amount <= balance) {
            this.balance -= amount;
            accountTransactions.addTransaction(amount, "withdraw");
        }
        else {
            throw new BalanceOverdraftException("The amount exceeds balance of the account");
        }
    }

    /**
     * Transfers money to another given bank account.
     * @param otherAcc the bank account being transferred to
     * @param amount the amount being transferred
     * @throws BalanceOverdraftException the exception thrown if amount is greater than
     * the current balance
     */
    public void transferTo(BankAccount otherAcc, double amount) throws BalanceOverdraftException{
        if (amount <= balance) {
            this.balance -= amount;
            otherAcc.deposit(amount);
            accountTransactions.addTransaction(amount, "withdraw");
        }
        else {
            throw new BalanceOverdraftException("The amount exceeds balance of the account");
        }
    }

    /**
     * Gets the current balance of the bank account.
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Gets the account statement from all the saved account transactions with no filter.
     * @return the account statement
     */
    public String accountStatement() {
        return accountTransactions.toString("none");
    }

    /**
     * Gets the account statement from all the saved account transactions with an only deposits filter.
     * @return the account statement with only deposits shown
     */
    public String accStatementFilterToDeposits() {
        return accountTransactions.toString("deposit");
    }

    /**
     * Gets the account statement from all the saved account transactions with an only withdrawals filter.
     * @return the account statement with only withdrawals shown
     */
    public String accStatementFilterToWithdrawals() {
        return accountTransactions.toString("withdraw");
    }

    /**
     * Gets the account statement from all the saved account transactions with given date filter.
     * @param date the given date in strict format dd/mm/yyyy
     * @return the account statement with only the given date transactions
     */
    public String accStatementFilterToDate(String date) {
        return accountTransactions.toString(date);
    }
}
