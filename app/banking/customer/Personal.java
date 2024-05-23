package app.banking.customer;

import app.framework.domain.Address;
import app.framework.domain.Customer;

import java.time.LocalDate;

public class Personal extends Customer {

    private final LocalDate dateOfBirth;

    public Personal(String name, String email, Address address, LocalDate dob) {
        super(name, email, address);
        this.dateOfBirth = dob;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public String getCustomerType() {
        return "Personal";
    };
}