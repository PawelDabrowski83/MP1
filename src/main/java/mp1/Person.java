package mp1;

public class Person extends ObjectPlus {
    private static int idCounter = 0;
    private int id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.id = calculateId();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private int calculateId() {
        return idCounter++;
    }

    @Override
    public String toString() {
        return String.format("id %d: %s %s", id, firstName, lastName);
    }

    public String toOrdinaryList() {
        return String.format("%s %s", firstName, lastName);
    }
}
