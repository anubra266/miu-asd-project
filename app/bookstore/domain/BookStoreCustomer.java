/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:18
 */

package app.bookstore.domain;

import app.framework.domain.Address;
import app.framework.domain.Customer;

public class BookStoreCustomer extends Customer {
    public BookStoreCustomer(String name, String email, Address address) {
        super(name, email, address);
    }
}
