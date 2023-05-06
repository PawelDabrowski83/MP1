package mp2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Medicine {
    private static int counter = 0;
    private static Set<Medicine> allMedicines = new HashSet<>();
    private int id;
    private String name;
    private final List<ActiveSubstance> activeSubstances;
    private final List<Manufacturer> manufacturers = new ArrayList<>();


    public Medicine(String name, List<ActiveSubstance> activeSubstances) {
        this.id = counter++;
        this.name = name;
        this.activeSubstances = activeSubstances;
        registerNewActiveSubstances(activeSubstances);
        allMedicines.add(this);
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
}
