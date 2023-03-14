package main.java;

import java.util.Date;

/**
 * A transaction of a bank account.
 */
public class Transaction {

    // Initializes date object to your regional date using the Date library
    private Date currentDate = new Date();
    private String type; // Transactions can only be a deposit or withdrawal
    private double amount;
    private double currentBalance;

    /**
     * Constructs a transaction.
     * @param type the type which is either deposit or withdraw
     * @param amount the amount in the transaction
     * @param balance the balance after the transaction
     */
    public Transaction(String type, double amount, double balance) {
        this.type = type;
        this.amount = amount;
        this.currentBalance = balance;
    }

    /**
     * Gets the date of the transaction.
     * @return the date in format dd/mm/yyyy
     */
    public String getDate() {
        String day = currentDate.getDate()+"";
        String month = (currentDate.getMonth() + 1)+"";
        String year = (currentDate.getYear() + 1900)+"";
        if (currentDate.getDate() < 10)
            day = "0" + day;
        if (currentDate.getMonth()+1 < 10)
            month = "0" + month;

        return day + "/" + month + "/" + year; // Format dd/mm/yyyy
    }

    /**
     * Gets the type of the transaction which is either deposit or withdrawal.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Converts the transaction into a readable string and returns it.
     * @return the transaction as a string
     */
    public String toString() {
        String transaction = "";
        if (type.equals("deposit"))
            transaction = getDate() + "  Type: Deposit   " + "  Amount:  £" + formatToTwoDP(amount) +
                            "  Balance:  £" + formatToTwoDP(currentBalance);
        else
            transaction = getDate() + "  Type: Withdraw  " + "  Amount: -£" + formatToTwoDP(amount) +
                            "  Balance:  £" + formatToTwoDP(currentBalance);
        return transaction;
    }

    /**
     * Static method that converts a decimal number to 2 decimal places.
     * @param decimal the decimal being converted
     * @return the formatted decimal
     */
    private static String formatToTwoDP(double decimal) {
        return String.format("%10.2f", decimal);
    }
}
