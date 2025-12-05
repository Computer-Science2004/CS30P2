package Mastery;

// Serves as a parent for Staff and Faculty
public abstract class UEmployee {
    
    // Shared attributes for all employees
    private String firstName;
    private String lastName;

    // Constructor used by child classes using "super()"
    public UEmployee(String f, String l) {
        firstName = f;
        lastName = l;
    }

    // Shared toString used by both subclasses
    public String toString() {
        return firstName + " " + lastName;
    }

    // Abstract method subclasses must define
    public abstract double pay(double period);
}
