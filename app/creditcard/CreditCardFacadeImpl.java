package app.creditcard;

import app.framework.*;

import java.time.LocalDate;

public class CreditCardFacadeImpl extends Subject implements CreditCardFacade{

    private static CreditCardFacadeImpl instance = new CreditCardFacadeImpl();
    private CreditAccountDAO creditCardDatabase;

    private CreditCardFacadeImpl(){
        this.creditCardDatabase = CreditAccountDAO.getInstance();
    };

    public static CreditCardFacadeImpl getInstance(){
        return CreditCardFacadeImpl.instance;
    }

    @Override
    public void createAccount(String name, String street, String city, String state, String zip, String email, String ccNumber, LocalDate exprDate) {
        Customer cust = new Customer(name,email, new Address(street,city,state,zip));

        CreditAccount ca = new CreditAccount("123",cust);
        this.creditCardDatabase.save(ca.getAccNumber(),ca);
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
    public void alert(Event event, Object obj) {
        for(Observer o: this.getObserverList()){
            o.callback(event,obj);
        }
    }

}
