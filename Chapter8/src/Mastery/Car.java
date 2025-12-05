package Mastery;
// Car subclass of Vehicle
public class Car extends Vehicle {
   private int doors; // Specific attribute for cars
   // Constructor calls parent constructor and sets number of doors
   public Car(String make, String model, int year, int doors) {
       super(make, model, year);
       this.doors = doors;
   }
   // Implementation of abstract method from Vehicle
   @Override
   public void displayInfo() {
       System.out.println(toString() + " (Car), Doors: " + doors);
   }
}
