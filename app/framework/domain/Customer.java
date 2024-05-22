package app.framework.domain;

public class Customer {
    private final String name;
    private final String email;
    private final Address address;

    public Customer(String name, String email, Address address){
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
}
