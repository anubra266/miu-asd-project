package app.banking.customer;

import app.framework.domain.Address;
import app.framework.domain.Customer;

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
