/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:32
 */

package app.framework.facade;

import app.framework.domain.Account;
import app.framework.domain.Entry;

public interface CommonFacade<R extends Account, T extends Entry> {
    R create(String id , R r);

    void withdraw(R r, T t);

    void deposit(R r, T t);

    void addInterest();
}
