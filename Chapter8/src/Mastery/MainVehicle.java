/*
Program: Vehicle, Car, truck, Minivan
Java Last Date of this Revision: December 5, 2025
Purpose: A Vehicle class that is an abstract class defining the general details and actions associated with
a vehicle. Create Car, Truck, and Minivan classes that inherit the Vehicle class. The Car, Truck, and
Minivan classes should include additional members specific to the type of vehicle being represented.
Create client code to test the classes.
Author: Hielan Lee-Tremblay
School: CHHS
Course: Computer Programming 30
*/

package Mastery;
import java.util.Scanner;
public class MainVehicle {
   /* Helper method to display vehicle info
      Demonstrates polymorphism: accepts any Vehicle subclass */
   public static void showVehicle(Vehicle vehicle) {
       vehicle.displayInfo();
   }
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       // Create instances of vehicles
       Car car = new Car("Honda", "Civic", 2020, 4);
       Truck truck = new Truck("Ford", "F-150", 2018, 8000);
       Minivan van = new Minivan("Toyota", "Sienna", 2022, 7);
       boolean running = true;
       // Menu loop
       while (running) {
           System.out.println("\n--- Vehicle Menu ---");
           System.out.println("1 = Car");
           System.out.println("2 = Truck");
           System.out.println("3 = Minivan");
           System.out.println("0 = Quit");
           System.out.print("Choose a vehicle to view: ");
           int choice = scanner.nextInt();
           // Handle menu selection
           switch (choice) {
               case 0:
                   running = false;
                   System.out.println("Have a nice day!");
                   break;
               case 1:
                   showVehicle(car);   // Display car info
                   break;
               case 2:
                   showVehicle(truck); // Display truck info
                   break;
               case 3:
                   showVehicle(van);   // Display minivan info
                   break;
               default:
                   System.out.println("Invalid choice. Try again.");
                   break;
           }
       }
       // Close the scanner to prevent resource leaks
       scanner.close();
   }
}

/*

Test Case 1:


--- Vehicle Menu ---
1 = Car
2 = Truck
3 = Minivan
0 = Quit
Choose a vehicle to view: 1
2020 Honda Civic (Car), Doors: 4

--- Vehicle Menu ---
1 = Car
2 = Truck
3 = Minivan
0 = Quit
Choose a vehicle to view: 2
2018 Ford F-150 (Truck), Tow Capacity: 8000.0 lbs

--- Vehicle Menu ---
1 = Car
2 = Truck
3 = Minivan
0 = Quit
Choose a vehicle to view: 3
2022 Toyota Sienna (Minivan), Seats: 7

--- Vehicle Menu ---
1 = Car
2 = Truck
3 = Minivan
0 = Quit
Choose a vehicle to view: 0
Have a nice day!


Test Case 2:

--- Vehicle Menu ---
1 = Car
2 = Truck
3 = Minivan
0 = Quit
Choose a vehicle to view: 3
2022 Toyota Sienna (Minivan), Seats: 7

--- Vehicle Menu ---
1 = Car
2 = Truck
3 = Minivan
0 = Quit
Choose a vehicle to view: 2
2018 Ford F-150 (Truck), Tow Capacity: 8000.0 lbs

--- Vehicle Menu ---
1 = Car
2 = Truck
3 = Minivan
0 = Quit
Choose a vehicle to view: 0
Have a nice day!

*/
