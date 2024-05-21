package app.banking.observers;

import app.framework.Observable;
import app.framework.Observer;

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
    public void callback(Object ob) {
        System.out.println("Bank Account Transaction");
    }
}
