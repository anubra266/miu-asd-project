package app.framework;

public class Address {
    private String zip;
    private String state;
    private String street;
    private String city;


    public Address(String street, String city, String state, String zip){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getAddress(){
        return this.street + "," + this.city + ", " + this.state + ", zip: " + this.zip;
    }
}
