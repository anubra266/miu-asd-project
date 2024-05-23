package app.banking.observers;

import app.banking.domain.BankAccount;
import app.framework.domain.Event;
import app.framework.domain.Observable;
import app.framework.domain.Observer;

public class BankEmailSender implements Observer {
    private static BankEmailSender instance = new BankEmailSender();

    private BankEmailSender(){}

    public static BankEmailSender getInstance(){
        return BankEmailSender.instance;
    }

    @Override
    public void subscribe(Observable subject) {
        subject.register(this);
    }

    @Override
    public void unsubscribe(Observable subject) {
        subject.unregister(this);
    }

    @Override
    public void callback(Event event, Object ob) {
        BankAccount acc = (BankAccount) ob;
        System.out.println("[EMAIL]: Event: "+ event +",Account: "+ acc.getCustomer().getCustomerType()  + ", Email: " + acc.getCustomer().getEmail());
    }
}
