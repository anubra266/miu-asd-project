package app.creditcard.observers;

import app.framework.Observable;
import app.framework.Observer;

public class CreditCardEmailSender implements Observer {
    private static CreditCardEmailSender instance = new CreditCardEmailSender();

    private CreditCardEmailSender(){}

    public static CreditCardEmailSender getInstance(){
        return CreditCardEmailSender.instance;
    }

    @Override
    public void subscribe(Observable subject) {
        subject.register(this);
    }

    @Override
    public void unsubscribe(Observable subject) {
        subject.unregister(this);
    }

    public void callback(Object ob){
        System.out.println("Credit Card Account Transaction");
    };
}
