package app.framework;

import java.util.Date;

public interface AccountService {
    void createCompanyAccount(String accountNumber,String name, String email, Address address,int numberOfEmployee,PercentageStrategy type);
    void createPersonalAccount(String accountNumber,String name, String email, Address address,Date birthDate,PercentageStrategy type);
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest(String accountNumber);
    void addInterestAllAccounts();
}
