package mp2;

import java.util.*;

public class Medicine {
    private static int counter = 0;
    protected static Map<String, Medicine> allMedicines = new HashMap<>();
    protected static final String[] GENERIC_MEDICINE_NAMES = new String[]{
            "Ananix", "Berula", "Cocosan", "Drażynki", "E2", "Fioletowa koronka", "Ginkosan"
    };
    private int id;
    private String name;
    private final List<ActiveSubstance> activeSubstances;
    private final List<Manufacturer> manufacturers = new ArrayList<>();


    public Medicine(String name, List<ActiveSubstance> activeSubstances) {
        this.id = counter++;
        this.name = name;
        this.activeSubstances = activeSubstances;
        if (activeSubstances != null) {
            registerNewActiveSubstances(activeSubstances);
        }

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
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (id != medicine.id) return false;
        if (!name.equals(medicine.name)) return false;
        if (!activeSubstances.equals(medicine.activeSubstances)) return false;
        return manufacturers.equals(medicine.manufacturers);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + activeSubstances.hashCode();
        result = 31 * result + manufacturers.hashCode();
        return result;
    }
}
