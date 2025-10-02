package Mastery;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts = new HashMap<>();
    private int nextID = 1000;

    public String addAccount(String fName, String lName, double balance) {
        String id = "ACCT" + nextID++;
        Customer c = new Customer(fName, lName);
        Account a = new Account(id, balance, c);
        accounts.put(id, a);
        return id;
    }

    public String transaction(int type, String acctID, double amt) {
        Account a = accounts.get(acctID);
        if (a == null) return "Account not found!";
        if (type == 1) {
            a.deposit(amt);
            return "Deposited $" + amt + " → New balance: " + a.getBalance();
        } else if (type == 2) {
            if (a.withdraw(amt)) {
                return "Withdrew $" + amt + " → New balance: " + a.getBalance();
            } else {
                return "Insufficient funds!";
            }
        }
        return "Invalid transaction type!";
    }

    public String checkBalance(String acctID) {
        Account a = accounts.get(acctID);
        if (a == null) return "Account not found!";
        return "Account " + acctID + " (" + a.getOwnerName() + "): $" + a.getBalance();
    }

    public String deleteAccount(String acctID) {
        if (accounts.remove(acctID) != null) {
            return "Account " + acctID + " deleted.";
        }
        return "Account not found!";
    }
}
