package mp2;

import java.util.HashSet;
import java.util.Set;

public class Manufacturer {
    private static int counter = 0;
    private Set<Manufacturer> allManufacturers = new HashSet<>();
    private int id;
    private String name;
    private String location;

    public Manufacturer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Manufacturer(String name) {
        new Manufacturer(name, "Warsaw");
    }

    class Department {
        private int id;
        private String name;
    }
}
