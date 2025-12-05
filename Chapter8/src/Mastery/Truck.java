package Mastery;
// Truck subclass of Vehicle
public class Truck extends Vehicle {
   private double towCapacity; // Specific attribute for trucks
   // Constructor calls parent constructor and sets tow capacity
   public Truck(String make, String model, int year, double towCapacity) {
       super(make, model, year);
       this.towCapacity = towCapacity;
   }
   // Implementation of abstract method from Vehicle
   @Override
   public void displayInfo() {
       System.out.println(toString() + " (Truck), Tow Capacity: " + towCapacity + " lbs");
   }
}
