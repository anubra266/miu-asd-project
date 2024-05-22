package app.creditcard.observers;

import app.framework.domain.Event;
import app.framework.domain.Observable;
import app.framework.domain.Observer;

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

    public void callback(Event event, Object ob){
        System.out.println("Credit Card Account Transaction");
    };
}
