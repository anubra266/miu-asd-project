package app.banking.facade_future;

import app.framework.facade.CommonFacade;

public interface BankFacade<R, T , I> extends CommonFacade<R,I> {

    void withdraw(I accNumber, T amount);

    void deposit(I accNumber, T amount);

    void addInterest();
}