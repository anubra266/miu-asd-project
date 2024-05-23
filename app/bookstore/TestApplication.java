/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:23
 */

package app.bookstore;

import app.bookstore.domain.Book;
import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;
import app.bookstore.rules.ChristmasDiscountRule;
import app.bookstore.rules.LoyalCustomerDiscountRule;
import app.bookstore.service.AccountFacade;
import app.bookstore.service.AccountFacadeImpl;
import app.bookstore.service.BookFacade;
import app.bookstore.service.BookFacadeImpl;
import app.framework.domain.Address;
import app.framework.domain.Customer;
import app.framework.domain.Observer;
import app.framework.persistence.DAO;
import app.framework.rules.RuleEngine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestApplication {
    public static void main(String[] args) {
        RuleEngine ruleEngine = new RuleEngine();
        List<Observer> observerList = new ArrayList<>();

        ruleEngine.addRule(new ChristmasDiscountRule());
        ruleEngine.addRule(new LoyalCustomerDiscountRule());
        
        DAO<BookStoreAccount, String> accountDAO = new DAO<>("book-store-accounts.store");
        DAO<Book, String> bookDAO = new DAO<>("books.store");

        AccountFacade facade = new AccountFacadeImpl(accountDAO);
        Customer customer = new Customer("Bayarjargal", "test@test.com", new Address("4th", "Fairfield", "IA", "52556"));
        BookStoreAccount account = new BookStoreAccount("123", customer);
        facade.create("123" , account);
        facade.create("124" , account);

        BookFacade bookFacade = new BookFacadeImpl(bookDAO);
        // Example Book 1
        Book book1 = new Book(
                "1",
                "J.K. Rowling",
                "Harry Potter and the Philosopher's Stone",
                "A young boy discovers he is a wizard and attends Hogwarts School of Witchcraft and Wizardry.",
                "978-0747532699",
                19.99,
                LocalDate.of(1997, 6, 26)
        );

        // Example Book 2
        Book book2 = new Book(
                "2",
                "George Orwell",
                "1984",
                "A dystopian social science fiction novel and cautionary tale about the dangers of totalitarianism.",
                "978-0451524935",
                14.99,
                LocalDate.of(1949, 6, 8)
        );

        // Example Book 3
        Book book3 = new Book(
                "3",
                "J.R.R. Tolkien",
                "The Hobbit",
                "A fantasy novel about the journey of hobbit Bilbo Baggins, who is swept into an epic quest.",
                "978-0547928227",
                10.99,
                LocalDate.of(1937, 9, 21)
        );

        // Example Book 4
        Book book4 = new Book(
                "4",
                "Harper Lee",
                "To Kill a Mockingbird",
                "A novel about the serious issues of rape and racial inequality told through the eyes of a young girl.",
                "978-0060935467",
                7.99,
                LocalDate.of(1960, 7, 11)
        );

        // Example Book 5
        Book book5 = new Book(
                "5",
                "F. Scott Fitzgerald",
                "The Great Gatsby",
                "A novel that explores themes of wealth, class, and the American Dream in the Jazz Age.",
                "978-0743273565",
                10.99,
                LocalDate.of(1925, 4, 10)
        );

        bookFacade.create("1", book1);
        bookFacade.create("2", book2);
        bookFacade.create("3", book3);
        bookFacade.create("4", book4);
        bookFacade.create("5", book5);




    }
}
