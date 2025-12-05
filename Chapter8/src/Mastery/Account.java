package Mastery;
// Abstract parent class for all accounts
public abstract class Account {
   // Private balance variable (fully encapsulated)
   private double balance;
   // Constructor to set initial balance
   public Account(double initialBalance) {
       balance = initialBalance;
   }
   // Getter for balance (subclasses and main can read it)
   public double getBalance() {
       return balance;
   }
   // Subclasses update balance via this internal method
   // Not exposed to other unrelated classes
   void updateBalance(double newBalance) {
       balance = newBalance;
   }
   // Abstract method: each subclass defines its own withdrawal rules
   public abstract void withdraw(double amount);
   @Override
   public String toString() {
       return "Account balance: $" + balance;
   }
}
