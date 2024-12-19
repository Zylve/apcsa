public class Person {
    // instance variables
    private String name;
    private String surname;
    private String status; // "family" or "BANNED" or money paid

    // constructor
    public Person(String name, String surname, String status) {
        this.name = name;
        this.surname = surname;
        this.status = status;
    }

    // accessor methods
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStatus() {
        return status;
    }

    // modifiers
    public void setStatus(String status) {
        this.status = status;
    }

    // outstanding balance of a guest to the nearest dollar
    public int balancePaid() {
        try {
            return Integer.parseInt(status);
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    // printing a guest's details
    public String toString() {
        String row = "\u2605 \u2606 \u2605 ";

        row += String.format("%-10.10s  %-10.10s  %8s", name, surname, "(" + status + ")");
        row += " \u2605 \u2606 \u2605";

        return row;
    }

} // end of Person
