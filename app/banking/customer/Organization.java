package app.banking.customer;

import app.framework.Address;
import app.framework.Customer;

public class Organization extends Customer {
    private final long numberOfEmployees;

    public Organization(String name, String email, Address address, long numOfEmployees) {
        super(name, email, address);
        this.numberOfEmployees = numOfEmployees;
    }

    public long getNumberOfEmployees() {
        return this.numberOfEmployees;
    }
}
