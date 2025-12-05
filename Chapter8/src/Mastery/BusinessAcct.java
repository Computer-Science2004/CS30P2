package Mastery;
// Business account subclass
// Applies $10 fee if balance falls below $500
public class BusinessAcct extends Account {
   public BusinessAcct(double initialBalance) {
       super(initialBalance);
   }
   @Override
   public void withdraw(double amount) {
       // Calculate new balance
       double newBalance = getBalance() - amount;
       // Apply fee if balance drops below $500
       if (newBalance < 500) {
           newBalance -= 10.0;
           System.out.println("Balance below $500. $10 fee applied.");
       }
       // Update the balance internally
       updateBalance(newBalance);
   }
   @Override
   public String toString() {
       return "Business Account, " + super.toString();
   }
}
