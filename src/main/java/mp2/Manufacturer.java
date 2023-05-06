package mp2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Manufacturer {
    private static int counter = 0;
    protected static Set<Manufacturer> allManufacturers = new HashSet<>();
    private int id;
    private String name;
    private String location;
    private List<ProductionHistory> productionHistories;

    public Manufacturer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Manufacturer(String name) {
        new Manufacturer(name, "Warsaw");
    }

    public void addProductionHistory(ProductionHistory productionHistory) {
        productionHistories.add(productionHistory);
    }

    public void remove(ProductionHistory productionHistory) {
        productionHistories.remove(productionHistory);
    }

//    public static Department createDepartment(String name, Manufacturer manufacturer) {
//        return new Department(name, manufacturer);
//    }

    public class Department {
        private static int counter = 0;
        private int id;
        private String name;
        private Manufacturer manufacturer;

        private Department(String name, Manufacturer manufacturer) {
            this.id = Department.counter++;
            this.name = name;
            this.manufacturer = manufacturer;
        }

//        public static Department createDepartment(String name, Manufacturer manufacturer) {
//            return new Department(name, manufacturer);
//
//        }
    }


}
