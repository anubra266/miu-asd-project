package app.framework;

public class CompanyInfo extends Customer{
    public int numberOfEmployee;

    public CompanyInfo( String name, String email, Address address, int numberOfEmployee) {
        super(name,email,address);
        this.numberOfEmployee = numberOfEmployee;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }
}
