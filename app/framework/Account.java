package app.framework;

public abstract class  Account {
    public String AccountNumber;
    public double balance;

    public abstract void deposite(String accountNumber,double amount,String message);
    public abstract  void withdraw(String accountNumber,double amount,String message);
    public abstract void addInterest(String accountNumber,double amount,String message);

}
