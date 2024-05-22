/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:10:48
 */

package app.framework.exceptions;

public  class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}