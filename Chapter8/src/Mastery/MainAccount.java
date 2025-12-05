/*
Program: Account, PersonalAcct, BusinessAcct
Java Last Date of this Revision: December 5, 2025
Purpose: Create PersonalAcct and BusinessAcct classes that inherit the Account class presented in Chapter 8.
A personal account requires a minimum balance of $100. If the balance falls below this amount, then
$2.00 is charged (withdrawn) to the account. A business account requires a minimum balance of $500,
otherwise the account is charged $10. Create client code to test the classes.
Author: Hielan Lee-Tremblay
School: CHHS
Course: Computer Programming 30
*/

package Mastery;
import java.util.Scanner;
// Client program to test PersonalAcct and BusinessAcct
public class MainAccount {
   /* Method to process withdrawal for any Account
      Uses polymorphism to call the correct withdraw() method */
   public static void processWithdrawal(Account acc, double amount) {
       acc.withdraw(amount); // Calls correct subclass version
       System.out.println("Balance after withdrawal: $" + acc.getBalance());
   }
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       boolean running = true;
       while (running) {
           // Display menu
           System.out.println("\n--- Account Menu ---");
           System.out.println("1 = Personal Account");
           System.out.println("2 = Business Account");
           System.out.println("0 = Quit");
           System.out.print("Choose an option: ");
           int choice = input.nextInt();
           if (choice == 0) {
               running = false;
               System.out.println("Have a nice day!");
               break;
           }
           // Ask for initial balance
           System.out.print("Enter initial balance: ");
           double initialBalance = input.nextDouble();
           Account account;
           if (choice == 1) {
               account = new PersonalAcct(initialBalance);
           } else if (choice == 2) {
               account = new BusinessAcct(initialBalance);
           } else {
               System.out.println("Invalid choice. Try again.");
               continue; // restart loop
           }
           // Ask for withdrawal amount
           System.out.print("Enter amount to withdraw: ");
           double amount = input.nextDouble();
           // Process the withdrawal using helper method
           processWithdrawal(account, amount);
       }
       input.close();
   }
}

/*

Test Case 1:


--- Account Menu ---
1 = Personal Account
2 = Business Account
0 = Quit
Choose an option: 1
Enter initial balance: 400
Enter amount to withdraw: 390
Balance below $100. $2 fee applied.
Balance after withdrawal: $8.0

--- Account Menu ---
1 = Personal Account
2 = Business Account
0 = Quit
Choose an option: 2
Enter initial balance: 498
Enter amount to withdraw: 60
Balance below $500. $10 fee applied.
Balance after withdrawal: $428.0

--- Account Menu ---
1 = Personal Account
2 = Business Account
0 = Quit
Choose an option: 0
Have a nice day!

Test Case 2:


--- Account Menu ---
1 = Personal Account
2 = Business Account
0 = Quit
Choose an option: 1
Enter initial balance: 200
Enter amount to withdraw: 60
Balance after withdrawal: $140.0

--- Account Menu ---
1 = Personal Account
2 = Business Account
0 = Quit
Choose an option: 2
Enter initial balance: 1000
Enter amount to withdraw: 400
Balance after withdrawal: $600.0

--- Account Menu ---
1 = Personal Account
2 = Business Account
0 = Quit
Choose an option: 0
Have a nice day!


*/