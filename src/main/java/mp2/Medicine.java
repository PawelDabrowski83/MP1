package mp2;

import java.util.*;

public class Medicine {
    private static int counter = 0;
    protected static Map<String, Medicine> allMedicines = new HashMap<>();
    private int id;
    private String name;
    private final List<ActiveSubstance> activeSubstances;
    private final List<Manufacturer> manufacturers = new ArrayList<>();


    public Medicine(String name, List<ActiveSubstance> activeSubstances) {
        this.id = counter++;
        this.name = name;
        this.activeSubstances = activeSubstances;
        registerNewActiveSubstances(activeSubstances);
        allMedicines.put(name, this);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activeSubstances=" + activeSubstances +
                '}';
    }

    private void registerNewActiveSubstances(List<ActiveSubstance> activeSubstances) {
        if (activeSubstances.isEmpty()) {
            return;
        }
        for (ActiveSubstance activeSubstance : activeSubstances) {
            activeSubstance.addMedicine(this);
        }
    }

    public void remove() {
        allMedicines.remove(this);
        if (activeSubstances.isEmpty()) {
            return;
        }
        for (ActiveSubstance activeSubstance : activeSubstances) {
            activeSubstance.removeMedicine(this);
        }
    }

    public static Medicine find(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        if (allMedicines.containsKey(name)) {
            allMedicines.get(name);
        } else {
            return null;
        }
    }
}
