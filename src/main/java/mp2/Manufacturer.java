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

    class Department {
        private int id;
        private String name;
    }
}
