package main.java;

/**
 * This tests all the bank account classes and ensures all methods are being
 * executed at least once.
 */
public class Main {

    /**
     * Runs the test.
     * @param args not used
     * @throws BalanceOverdraftException the exception thrown in any withdrawal error
     */
    public static void main(String[] args) throws BalanceOverdraftException {
        BankAccount user = new BankAccount(1000);
        BankAccount user2 = new BankAccount();

        user.deposit(4500);
        user.withdraw(3.5);
        user.deposit(20);
        user.withdraw(500);
        user.withdraw(200);

        user.transferTo(user2, 300);

        // All filters tested
        System.out.println(user.accountStatement());
        System.out.println();
        System.out.println(user.accStatementFilterToDeposits());
        System.out.println();
        System.out.println(user.accStatementFilterToWithdrawals());
        System.out.println();
        System.out.println(user.accStatementFilterToDate("16/02/2023"));
        System.out.println();
        // To ensure account transactions are unaffected by the filters
        System.out.println(user.accountStatement());
    }

    /**
     * Tests the exception.
     * @param acc the account being tested on
     * @throws BalanceOverdraftException the exception that is being executed
     */
    public static void exceptionTest(BankAccount acc) throws BalanceOverdraftException {
        acc.withdraw(10000);
    }
}
