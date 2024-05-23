package app.framework.domain;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = -891292834814574888L;

    private final String name;
    private final String email;
    private final Address address;

    public Customer(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Address getAddress() {
        return this.address;
    }

    public String getCustomerType() {
        return "Customer";
    };
}
