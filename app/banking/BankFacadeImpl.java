package app.banking;

import app.banking.domain.BankAccount;
import app.banking.observers.BankEmailSender;
import app.banking.persistence.BankAccountDAO;
import app.banking.strategies.CheckingPercentageStrategy;
import app.banking.strategies.SavingPercentageStrategy;
import app.framework.domain.*;
import app.framework.exceptions.AccountCreationException;
import app.framework.exceptions.AccountNotFoundException;
import app.framework.exceptions.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.Collection;


public class BankFacadeImpl extends BankFacade {

    private static BankFacadeImpl instance = new BankFacadeImpl();

    public static BankFacadeImpl getInstance() {
        return BankFacadeImpl.instance;
    }

    private BankFacadeImpl() {

        super(BankAccountDAO.getInstance(),null, new ArrayList<Observer>(){
            {
                add(BankEmailSender.getInstance());
            }
        });
    }

    public void createAccount(Customer customer, String accNr, AccountType accountType)
            throws AccountCreationException {
        PercentageStrategy percentageStrategy;

        if (getDatabase().isUnique(accNr)) {
            if (accountType.equals(AccountType.CHECKING)) {
                percentageStrategy = new CheckingPercentageStrategy();
            } else {
                percentageStrategy = new SavingPercentageStrategy();
            }

            BankAccount account = new BankAccount(accNr, customer);
            account.setPercentageStrategy(percentageStrategy);
            getDatabase().save(accNr, account);
            return;
        }
        throw new AccountCreationException("Account with number " + accNr + " already exists");

    }

    @Override
    public void withDraw(String accNumber, double amount) throws AccountNotFoundException {
        BankAccount bankAccount = getDatabase().get(accNumber);

        if (bankAccount != null) {
            if(bankAccount.getBalance() < amount){
                this.alert(Event.INSUFFICIENT_FUND,bankAccount);
            }
            if(bankAccount.getCustomer().getCustomerType().equals("Company")){
                this.alert(Event.WITHDRAW,bankAccount);
            }else{
                if(amount > 500){
                    this.alert(Event.WITHDRAW,bankAccount);
                }
            }

            if (bankAccount.getBalance() < amount) {
                throw new InsufficientBalanceException(
                        "Account with number " + accNumber + " does not have enough balance");
            }
            bankAccount.withdraw(amount, "Amount withdraw");
            getDatabase().update(bankAccount.getAccNumber(), bankAccount);
            return;
        }
        throw new AccountNotFoundException("Account with number " + accNumber + " does not exist");
    }

    @Override
    public void deposit(String accNumber, double amount) throws AccountNotFoundException {
        BankAccount bankAccount = getDatabase().get(accNumber);
        if (bankAccount != null) {
            if(bankAccount.getCustomer().getCustomerType().equals("Company")){
                this.alert(Event.DEPOSIT,bankAccount);
            }else{
                if(amount > 500){
                    this.alert(Event.DEPOSIT,bankAccount);
                }
            }

            bankAccount.deposit(amount, "Amount deposit");
            getDatabase().update(bankAccount.getAccNumber(), bankAccount);

            return;
        }
        throw new AccountNotFoundException("Account with number " + accNumber + " does not exist");
    }

    @Override
    public void addInterest() {
        for (BankAccount bankAccount : this.getDatabase().getAll()) {
            bankAccount.addInterest();
            this.getDatabase().update(bankAccount.getAccNumber(), bankAccount);
        }
    }

    public Collection<BankAccount> getAccounts() {
        return this.getDatabase().getAll();
    }
}