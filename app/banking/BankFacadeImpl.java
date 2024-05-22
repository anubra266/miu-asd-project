package app.banking;

import app.banking.customer.Organization;
import app.banking.strategy.CheckingPercentageStrategy;
import app.banking.strategy.SavingPercentageStrategy;
import app.framework.*;

import java.time.LocalDate;

public class BankFacadeImpl extends Subject implements BankFacade{

    private static BankFacadeImpl instance = new BankFacadeImpl();
    private BankAccountDAO bankAccountDatabase;
    PercentageStrategy percentageStrategy ;

    private BankFacadeImpl(){
        this.bankAccountDatabase = BankAccountDAO.getInstance();
    };

    public static BankFacadeImpl getInstance(){
        return BankFacadeImpl.instance;
    }

    @Override
    public void createPersonalAccount(String accNr, String name, String street, String city, String state, String zip, LocalDate birthDate, String email,String accountType) {

    }

    @Override
    public void createCompanyAccount(String accNr, String name, String street, String city, String state, String zip, int numberOfEmployee, String email,String accountType) {
       if(accountType.equals("checking")){
             percentageStrategy = new CheckingPercentageStrategy();
       }else{
            percentageStrategy = new SavingPercentageStrategy();
       }

        Address address = new Address(street,state,city,zip);
        Customer customer = new Organization(name,email,address,numberOfEmployee);
        BankAccount account = new BankAccount(accNr,customer);
        account.setPercentageStrategy(percentageStrategy);
        bankAccountDatabase.save(accNr,account);
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
    public void alert(Event event, Object obj) {
        for(Observer o: this.getObserverList()){
            o.callback(event,obj);
        }
    }
}
