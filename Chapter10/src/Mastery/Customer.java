package Mastery;

public class Customer {
    private String firstName;
    private String lastName;

    public Customer(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
