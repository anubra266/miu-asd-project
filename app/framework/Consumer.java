package app.framework;

public class Consumer {
    private String name;
    private String email;
    private Address address;

    Consumer(String name, String email, Address address){
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
