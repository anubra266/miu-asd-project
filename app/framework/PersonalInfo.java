package app.framework;

import java.util.Date;

public class PersonalInfo extends Customer{
    public Date birthDate;

    public PersonalInfo( String name, String email, Address address,Date birthDate) {
        super(name,email,address);
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
