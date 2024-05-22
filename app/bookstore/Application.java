/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:23
 */

package app.bookstore;

import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;
import app.bookstore.rules.ChristmasDiscountRule;
import app.bookstore.rules.LoyalCustomerDiscountRule;
import app.bookstore.service.BookStoreFacade;
import app.bookstore.service.BookStoreFacadeImpl;
import app.framework.domain.Address;
import app.framework.domain.Customer;
import app.framework.domain.Observer;
import app.framework.persistence.DAO;
import app.framework.persistence.Database;
import app.framework.rules.RuleEngine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RuleEngine ruleEngine = new RuleEngine();
        List<Observer> observerList = new ArrayList<>();



        ruleEngine.addRule(new ChristmasDiscountRule());
        ruleEngine.addRule(new LoyalCustomerDiscountRule());

//        Database<BookStoreAccount> = new Datab
        DAO<BookStoreAccount> accountDAO = new DAO<>("book-store-accounts.store");

        BookStoreFacade facade = new BookStoreFacadeImpl(accountDAO, ruleEngine, observerList);
        Customer customer = new Customer("Bayarjargal", "test@test.com", new Address("4th", "Fairfield", "IA", "52556"));
        BookStoreAccount account = new BookStoreAccount("123", customer);

        facade.deposit(account, new PurchaseEntry(100, LocalDateTime.now(), "Harry Potter"));

    }
}
