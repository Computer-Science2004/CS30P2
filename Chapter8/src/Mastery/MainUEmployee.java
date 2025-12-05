/*
Program: UEmployee
Java Last Date of this Revision: December 3, 2025
Purpose: A UEmployee class that contains member variables for the university employee name and salary.
The UEmployee class contains member methods for returning the employee name and salary.
There are Faculty and Staff classes that inherit the UEmployee class. The Faculty class includes
members for storing and returning the department name. The Staff class includes members for
storing and returning the job title
Author: Hielan Lee-Tremblay
School: CHHS
Course: Computer Programming 30
*/

package Mastery;

import java.text.NumberFormat;
import java.util.Scanner;

public class MainUEmployee {

    /* Method that receives any UEmployee (Faculty or Staff)
    and calculates their pay using their own pay() method */
    public static void payEmployee(UEmployee emp, double arg) {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double pay = emp.pay(arg); // Calls the correct version using polymorphism (basically can be many different things is what it means)
        System.out.println(money.format(pay));
    }

    public static void main(String[] args) {
        // Create one Faculty and one Staff object
        Faculty emp1 = new Faculty("Alice", "Johnson", 75000);
        Staff emp2 = new Staff("Bob", "Smith", 28.50);

        Scanner input = new Scanner(System.in);

        UEmployee emp = emp1; // Default employee (will change later)
        String action;
        int empNum;
        double payArg;

        do {
            // Menu for user options
            System.out.println("\n(E)Employee  (P)Pay  (Q)Quit");
            System.out.print("Enter choice: ");
            action = input.next();

            if (!action.equalsIgnoreCase("Q")) {

                // Prompt message for which employee the user wants
                System.out.print("Enter employee number (1=Faculty, 2=Staff): ");
                empNum = input.nextInt();

                // Switch to choose which employee object to use
                switch (empNum) {
                    case 1: emp = emp1; break;
                    case 2: emp = emp2; break;
                }

                if (action.equalsIgnoreCase("E")) {
                    // Print the selected employee (uses overridden toString)
                    System.out.println(emp);
                }
                else if (action.equalsIgnoreCase("P")) {
                    System.out.println("Enter hours (Staff) or weeks (Faculty): ");
                    payArg = input.nextDouble();
                    payEmployee(emp, payArg);
                }
            }

        } while (!action.equalsIgnoreCase("Q"));

        System.out.println("Have a nice day!");
        input.close();
    }
}


/*

Test Case 1:

(E)Employee  (P)Pay  (Q)Quit
Enter choice: e
Enter employee number (1=Faculty or 2=Staff): 1
Alice Johnson, Faculty, Salary: 75000.0

(E)Employee  (P)Pay  (Q)Quit
Enter choice: p
Enter employee number (1=Faculty or 2=Staff): 1
Enter hours (Staff) or weeks (Faculty): 
52
$75,000.00

(E)Employee  (P)Pay  (Q)Quit
Enter choice: q
Have a nice day!

Test Case 2:

(E)Employee  (P)Pay  (Q)Quit
Enter choice: e
Enter employee number (1=Faculty or 2=Staff): 2
Bob Smith, Staff, Hourly Rate: 28.5

(E)Employee  (P)Pay  (Q)Quit
Enter choice: p
Enter employee number (1=Faculty or 2=Staff): 2
Enter hours (Staff) or weeks (Faculty): 
3000
$127,680.00

(E)Employee  (P)Pay  (Q)Quit
Enter choice: q
Have a nice day!

Test Case 3:

(E)Employee  (P)Pay  (Q)Quit
Enter choice: p
Enter employee number (1=Faculty or 2=Staff): 1
Enter hours (Staff) or weeks (Faculty): 
56
$80,769.23

(E)Employee  (P)Pay  (Q)Quit
Enter choice: e
Enter employee number (1=Faculty or 2=Staff): 1
Alice Johnson, Faculty, Salary: 75000.0

(E)Employee  (P)Pay  (Q)Quit
Enter choice: q
Have a nice day!

*/
