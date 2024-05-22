package app.creditcard;

import app.framework.Observer;
import app.framework.Subject;

import java.time.LocalDate;

public class CreditCardFacadeImpl extends Subject implements CreditCardFacade{

    private static CreditCardFacadeImpl instance = new CreditCardFacadeImpl();

    private CreditCardFacadeImpl(){};

    public static CreditCardFacadeImpl getInstance(){
        return CreditCardFacadeImpl.instance;
    }

    @Override
    public void createAccount(String name, String street, String city, String state, String zip, String Email, String ccNumber, LocalDate exprDate) {

    }

    @Override
    public void generateMonthlyBill() {

    }

    @Override
    public void chargeAmount() {

    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void alert() {
        for(Observer o: this.getObserverList()){
            o.callback(null);
        }
    }
}