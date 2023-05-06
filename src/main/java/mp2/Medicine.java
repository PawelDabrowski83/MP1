package mp2;

import java.util.*;

public class Medicine {
    protected static final String[] GENERIC_MEDICINE_NAMES = new String[]{
            "Ananix", "Berula", "Cocosan", "Drażynki", "E2", "Fioletowa koronka", "Ginkosan"
    };
    private static int counter = 0;
    protected static Map<String, Medicine> allMedicines = new HashMap<>();

    private final int id;
    private String name;
    protected List<ActiveSubstance> activeSubstances;
    protected List<ProductionHistory> productionHistories;


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

    public static void remove(Medicine medicine) {
        allMedicines.remove(medicine.name);
        List<ActiveSubstance> oldActiveSubstances = medicine.activeSubstances;
        medicine.activeSubstances = null;
        while (oldActiveSubstances.size() > 0) {
            ActiveSubstance removedSubstance = oldActiveSubstances.remove(0);
            try {
                removedSubstance.remove();
            } catch (IllegalStateException ignored) {
            }
        }
        medicine.name = null;
    }

    public void remove(ProductionHistory productionHistory) {
        productionHistories.remove(productionHistory);
    }

    public static Medicine find(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        if (allMedicines.containsKey(name)) {
            return allMedicines.get(name);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (id != medicine.id) return false;
        if (!Objects.equals(name, medicine.name)) return false;
        if (!Objects.equals(activeSubstances, medicine.activeSubstances))
            return false;
        return Objects.equals(productionHistories, medicine.productionHistories);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (activeSubstances != null ? activeSubstances.hashCode() : 0);
        result = 31 * result + (productionHistories != null ? productionHistories.hashCode() : 0);
        return result;
    }

    public void addProductionHistory(ProductionHistory productionHistory) {
        productionHistories.add(productionHistory);
    }
}
