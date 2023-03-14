package main.java;

import java.util.ArrayList;

/**
 * All the saved transactions of a given bank account.
 */
public class AccountTransactions {

    private BankAccount account;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>(); // List of account transactions

    /**
     * Sets the empty list of transactions to a given bank account
     * @param acc the given bank account
     */
    public AccountTransactions(BankAccount acc) {
        this.account = acc;
    }

    /**
     * Adds a transaction to the list with a given amount and type.
     * @param amount the amount in the transaction
     * @param type the type of transaction
     */
    public void addTransaction(double amount, String type) {
        transactions.add(new Transaction(type, amount, account.getBalance()));
    }

    /**
     * Constructs an account statement from all the saved account transactions.
     * @param filter the filter for the account statement
     * @return the constructed account statement
     */
    public String toString(String filter) {
        String statement = " ~ Account Statement ~ \n";

        for (int i=0; i < transactions.size(); i++) {
            // Filters to only deposits or withdrawals
            if (transactions.get(i).getType().equals(filter))
                statement += transactions.get(i) + "\n";
            // Filters to a given date
            if (transactions.get(i).getDate().equals(filter))
                statement += transactions.get(i) + "\n";
            // No filter
            if (filter.equals("none"))
                statement += transactions.get(i) + "\n";
        }

        return statement;
    }

}
