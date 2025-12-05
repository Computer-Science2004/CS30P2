package Mastery;
// Personal account subclass
// Applies $2 fee if balance falls below $100
public class PersonalAcct extends Account {
   public PersonalAcct(double initialBalance) {
       super(initialBalance);
   }
   @Override
   public void withdraw(double amount) {
       // Calculate new balance
       double newBalance = getBalance() - amount;
       // Apply fee if balance drops below $100
       if (newBalance < 100) {
           newBalance -= 2.0;
           System.out.println("Balance below $100. $2 fee applied.");
       }
       // Update the balance internally
       updateBalance(newBalance);
   }
   @Override
   public String toString() {
       return "Personal Account, " + super.toString();
   }
}
