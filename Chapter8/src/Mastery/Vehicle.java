package Mastery;
// Abstract parent class for all vehicles
public abstract class Vehicle {
   // Private variables for encapsulation
   private String make;
   private String model;
   private int year;
   // Constructor to initialize common vehicle attributes
   public Vehicle(String make, String model, int year) {
       this.make = make;
       this.model = model;
       this.year = year;
   }
   // Getter methods to allow subclasses to access attributes safely
   public String getMake() {
       return make;
   }
   public String getModel() {
       return model;
   }
   public int getYear() {
       return year;
   }
   // Abstract method: must be implemented by subclasses to display vehicle-specific info
   public abstract void displayInfo();
   // Common toString method for all vehicles
   @Override
   public String toString() {
       return year + " " + make + " " + model;
   }
}
