package mp2;

import java.util.*;

public class Manufacturer {
    private static int counter = 0;
    protected static Set<Manufacturer> allManufacturers = new HashSet<>();
    private int id;
    private String name;
    private String location;
    private List<ProductionHistory> productionHistories;
    private Set<Department> departments = new HashSet<>();

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

    protected void add(Department department) {
        departments.add(department);
    }

    protected void remove(Department department) {
        departments.remove(department);
    }
    public class Department {
        private static int counter = 0;
        private int id;
        private String name;
        private Manufacturer manufacturer;
        private static Map<Integer, Department> allDepartments = new HashMap<>();

        private Department(String name, Manufacturer manufacturer) {
            this.id = Department.counter++;
            this.name = name;
            this.manufacturer = manufacturer;
            allDepartments.put(id, this);
        }

        public Department createDepartment(String name, Manufacturer manufacturer) {
            if (name == null || manufacturer == null) {
                throw new IllegalArgumentException("Arguments cannot be null.");
            }
            manufacturer.add(this);
            return new Department(name, manufacturer);
        }

        public void destroyDepartment(int id) {
            allDepartments.remove(id);
            manufacturer.remove(this);
        }

        public static Department findDepartmentById(int id) {
            if (allDepartments.keySet().contains(id)) {
                return allDepartments.get(id);
            }
            return null;
        }
    }


}
