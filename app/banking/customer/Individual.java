package app.banking.customer;

import app.framework.Address;
import app.framework.Customer;

import java.time.LocalDate;

public class Individual extends Customer {

    private final LocalDate dateOfBirth;

    public Individual(String name, String email, Address address, LocalDate dob){
        super(name,email,address);
        this.dateOfBirth = dob;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
}
