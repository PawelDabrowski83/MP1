public class Person {
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
}
