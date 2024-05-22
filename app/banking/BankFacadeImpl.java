package app.banking;

import app.banking.customer.Individual;
import app.banking.customer.Organization;
import app.banking.strategies.CheckingPercentageStrategy;
import app.banking.strategies.SavingPercentageStrategy;
import app.framework.*;
import app.framework.exceptions.AccountAlreadyExistsException;
import app.framework.exceptions.AccountNotFoundException;


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
    public void createPersonalAccount(String accNr, String name, String street, String city, String state, String zip, LocalDate birthDate, String email,String accountType) throws AccountAlreadyExistsException {
        if (bankAccountDatabase.isUnique(accNr)) {
            if (accountType.equals("checking")) {
                percentageStrategy = new CheckingPercentageStrategy();
            } else {
                percentageStrategy = new SavingPercentageStrategy();
            }

            Address address = new Address(street, state, city, zip);
            Customer customer = new Individual(name, email, address, birthDate);
            BankAccount account = new BankAccount(accNr, customer);
            account.setPercentageStrategy(percentageStrategy);
            bankAccountDatabase.save(accNr, account);
            return;
        }
        throw new AccountAlreadyExistsException("Account with number " + accNr + " already exists");
    }

    @Override
    public void createCompanyAccount(String accNr, String name, String street, String city, String state, String zip, int numberOfEmployee, String email,String accountType) throws AccountAlreadyExistsException {
        if (accountType.equals("checking")) {
            if (accountType.equals("checking")) {
                percentageStrategy = new CheckingPercentageStrategy();
            } else {
                percentageStrategy = new SavingPercentageStrategy();
            }

            Address address = new Address(street, state, city, zip);
            Customer customer = new Organization(name, email, address, numberOfEmployee);
            BankAccount account = new BankAccount(accNr, customer);
            account.setPercentageStrategy(percentageStrategy);
            bankAccountDatabase.save(accNr, account);
            return;
        }
        throw new AccountAlreadyExistsException("Account with number " + accNr + " already exists");
    }

    @Override
    public void withDraw(String accNumber,double amount) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountDatabase.get(accNumber);
        if(bankAccount != null) {
            bankAccount.withdraw(amount, "Amount withdraw");
            bankAccountDatabase.update(bankAccount.getAccNumber(), bankAccount);
            return;
        }

        throw new AccountNotFoundException("Account with number "+ accNumber + " does not exist");
    }

    @Override
    public void deposit(String accNumber,double amount) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountDatabase.get(accNumber);
        if(bankAccount != null) {
            bankAccount.deposit(amount, "Amount deposit");
            bankAccountDatabase.update(bankAccount.getAccNumber(), bankAccount);
            return;
        }
        throw new AccountNotFoundException("Account with number "+ accNumber + " does not exist");
    }

    @Override
    public void addInterest(String accNumber) {
        BankAccount bankAccount = bankAccountDatabase.get(accNumber);
        if(bankAccount != null) {
            bankAccount.addInterest();
            bankAccountDatabase.update(bankAccount.getAccNumber(), bankAccount);
        }
    }

    @Override
    public void alert(Event event, Object obj) {
        for(Observer o: this.getObserverList()){
            o.callback(event,obj);
        }
    }
}
