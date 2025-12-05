package Mastery;

// Child of parent class UEmployee
// Faculty employee paid annually 
public class Faculty extends UEmployee {

    private double yearlySalary;

    public Faculty(String fn, String ln, double s) {
        super(fn, ln);       // Calls parent constructor (UEmployee)
        yearlySalary = s;
    }

    // Calculates pay by turning yearly salary into weekly and multiplying by the number of weeks
    @Override
    public double pay(double weeks) {
        return (yearlySalary / 52) * weeks;
    }

    // Extends the parent toString with extra info
    @Override
    public String toString() {
        return super.toString() + ", Faculty, Salary: " + yearlySalary;
    }
}
