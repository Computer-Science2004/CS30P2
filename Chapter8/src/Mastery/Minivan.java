package Mastery;
// Minivan subclass of Vehicle
public class Minivan extends Vehicle {
   private int seating; // Specific attribute for minivans
   // Constructor calls parent constructor and sets seating capacity
   public Minivan(String make, String model, int year, int seating) {
       super(make, model, year);
       this.seating = seating;
   }
   // Implementation of abstract method from Vehicle
   @Override
   public void displayInfo() {
       System.out.println(toString() + " (Minivan), Seats: " + seating);
   }
}
