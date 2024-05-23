/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:11:55
 */

package app.framework.exceptions;

public class FraudTransactionException extends RuntimeException{
    public FraudTransactionException(String message) {
        super(message);
    }
}
