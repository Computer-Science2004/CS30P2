package Mastery;

public class Account {
    private String acctID;
    private double balance;
    private Customer owner;

    public Account(String acctID, double balance, Customer owner) {
        this.acctID = acctID;
        this.balance = balance;
        this.owner = owner;
    }

    public String getAcctID() {
        return acctID;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public boolean withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            return true;
        }
        return false;
    }

    public String getOwnerName() {
        return owner.getName();
    }
}
