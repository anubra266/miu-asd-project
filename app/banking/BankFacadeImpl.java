package app.banking;

import app.framework.Observer;
import app.framework.Subject;

import java.time.LocalDate;

public class BankFacadeImpl extends Subject implements BankFacade{

    private static BankFacadeImpl instance = new BankFacadeImpl();

    private BankFacadeImpl(){};

    public static BankFacadeImpl getInstance(){
        return BankFacadeImpl.instance;
    }

    @Override
    public void createPersonalAccount(String accNr, String name, String street, String city, String state, String zip, LocalDate birthDate, String email) {

    }

    @Override
    public void createCompanyAccount(String accNr, String name, String street, String city, String state, String zip, int numberOfEmployee, String email) {

    }

    @Override
    public void withDraw(double amount) {

    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void addInterest() {

    }

    @Override
    public void alert() {
        for(Observer o: this.getObserverList()){
            o.callback(null);
        }
    }
}
