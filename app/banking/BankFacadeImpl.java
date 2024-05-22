package app.banking;

import app.banking.strategies.CheckingPercentageStrategy;
import app.banking.strategies.SavingPercentageStrategy;
import app.framework.domain.*;
import app.framework.exceptions.AccountCreationException;
import app.framework.exceptions.AccountNotFoundException;
import app.framework.exceptions.InsufficientBalanceException;

import java.util.Collection;

public class BankFacadeImpl extends BankFacade {

    private static BankFacadeImpl instance = new BankFacadeImpl();

    public static BankFacadeImpl getInstance() {
        return BankFacadeImpl.instance;
    }

    private BankAccountDAO bankAccountDatabase;

    PercentageStrategy percentageStrategy;;

    private BankFacadeImpl() {
        this.bankAccountDatabase = BankAccountDAO.getInstance();
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
            if (bankAccount.getBalance() < amount) {
                throw new InsufficientBalanceException(
                        "Account with number " + accNumber + " does not have enough balance");
            }
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
    public void addInterest() {
        for (BankAccount bankAccount : bankAccountDatabase.getAll()) {
            bankAccount.addInterest();
            bankAccountDatabase.update(bankAccount.getAccNumber(), bankAccount);
        }
    }

    public Collection<BankAccount> getAccounts() {
        return this.bankAccountDatabase.getAll();
    }

    @Override
    public void alert(Event event, Object obj) {
        for (Observer o : this.getObserverList()) {
            o.callback(event, obj);
        }
    }
}