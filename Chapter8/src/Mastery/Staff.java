
package Mastery;

// Staff = hourly employee
public class Staff extends UEmployee {

    private double hourlyRate;

    public Staff(String fn, String ln, double rate) {
        super(fn, ln);       // Calls parent constructor
        hourlyRate = rate;
    }

    // Calculates pay using regular hourly rate only (no overtime)
    @Override
    public double pay(double hours) {
        return hourlyRate * hours;
    }

    @Override
    public String toString() {
        return super.toString() + ", Staff, Hourly Rate: " + hourlyRate;
    }
}
