package app.banking;

import app.banking.strategies.CheckingPercentageStrategy;
import app.banking.strategies.SavingPercentageStrategy;
import app.framework.domain.*;
import app.framework.exceptions.AccountCreationException;
import app.framework.exceptions.AccountNotFoundException;

public class BankFacadeImpl extends BankFacade {

    private static BankFacadeImpl instance = new BankFacadeImpl();
    private BankAccountDAO bankAccountDatabase;
    PercentageStrategy percentageStrategy;

    private BankFacadeImpl() {
        this.bankAccountDatabase = BankAccountDAO.getInstance();
    };

    public static BankFacadeImpl getInstance() {
        return BankFacadeImpl.instance;
    }

    public void createAccount(Customer customer, String accNr, AccountType accountType)
            throws AccountCreationException {

        if (bankAccountDatabase.isUnique(accNr)) {
            if (accountType.equals(AccountType.CHECKING)) {
                percentageStrategy = new CheckingPercentageStrategy();
            } else {
                percentageStrategy = new SavingPercentageStrategy();
            }

            BankAccount account = new BankAccount(accNr, customer);
            account.setPercentageStrategy(percentageStrategy);
            bankAccountDatabase.save(accNr, account);
            return;
        }
        throw new AccountCreationException("Account with number " + accNr + " already exists");

    }

    @Override
    public void withDraw(String accNumber, double amount) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountDatabase.get(accNumber);
        if (bankAccount != null) {
            bankAccount.withdraw(amount, "Amount withdraw");
            bankAccountDatabase.update(bankAccount.getAccNumber(), bankAccount);
            return;
        }

        throw new AccountNotFoundException("Account with number " + accNumber + " does not exist");
    }

    @Override
    public void deposit(String accNumber, double amount) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountDatabase.get(accNumber);
        if (bankAccount != null) {
            bankAccount.deposit(amount, "Amount deposit");
            bankAccountDatabase.update(bankAccount.getAccNumber(), bankAccount);
            return;
        }
        throw new AccountNotFoundException("Account with number " + accNumber + " does not exist");
    }

    @Override
    public void addInterest(String accNumber) {
        BankAccount bankAccount = bankAccountDatabase.get(accNumber);
        if (bankAccount != null) {
            bankAccount.addInterest();
            bankAccountDatabase.update(bankAccount.getAccNumber(), bankAccount);
        }
    }

    @Override
    public void alert(Event event, Object obj) {
        for (Observer o : this.getObserverList()) {
            o.callback(event, obj);
        }
    }
}