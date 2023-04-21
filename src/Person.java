import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static final List<Person> extent = new ArrayList<>();
    private static int idCounter = 0;
    private int id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.id = calculateId();
        this.firstName = firstName;
        this.lastName = lastName;
        addPerson(this);
    }

    private int calculateId() {
        return idCounter++;
    }

    public static void addPerson(Person person) {
        extent.add(person);
    }

    public static void removePerson(Person person) {
        extent.remove(person);
    }

    public static Person findPerson(int id) {
        for (Person p : extent) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }
}
