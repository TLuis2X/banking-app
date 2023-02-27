/**
 * This exception is executed only if the amount given is
 * greater than the current balance of a bank account.
 */
public class BalanceOverdraftException extends Exception{

    /**
     * Constructs the exception.
     * @param message the message displayed
     */
    public BalanceOverdraftException(String message) {
        super(message);
    }
}
