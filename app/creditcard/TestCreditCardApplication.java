/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:14:59
 */

package app.creditcard;

import app.banking.domain.BankAccount;
import app.banking.persistence.BankAccountDAO;
import app.banking.domain.BankEntry;
import app.framework.domain.Address;
import app.framework.domain.Customer;
import app.framework.domain.Event;
import app.framework.persistence.DAO;
import app.framework.rules.RuleEngine;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestCreditCardApplication {
    public static void main(String[] args) {
        DAO<CreditAccount, String> bankAccountDAO = CreditAccountDAO.getInstance();
        RuleEngine ruleEngine = new RuleEngine();
        TestFacade facade = new TestFacadeImpl(bankAccountDAO, ruleEngine, new ArrayList<>());

        Customer customer = new Customer("Bayarjargal", "test@test.com", new Address("4th", "Fairfield", "IA", "52556"));
        BankAccount account = new BankAccount("132", customer);
        BankEntry entry = new BankEntry(100, "Deposit", LocalDateTime.now(),Event.DEPOSIT, "Test", "Test");
        // facade.withdraw(account, entry);

        facade.addInterest();
    }
}
