package mp2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActiveSubstance {
    private static int counter = 0;
    private static Set<ActiveSubstance> allActiveSubstances = new HashSet<>();
    private int id;
    private String name;
    private List<Medicine> medicines = new ArrayList<>();

    public ActiveSubstance(String name) {
        this.id = counter++;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ActiveSubstance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    protected void addMedicine(Medicine medicine) {
        if (!medicines.contains(medicine)) {
            medicines.add(medicine);
        }
    }

    protected void removeMedicine(Medicine medicine) {
        medicines.remove(medicine);
    }

    public void remove() {
        if (medicines.isEmpty()) {
            allActiveSubstances.remove(this);
        } else {
            throw new IllegalStateException("Cannot remove without removing connected medicines.");
        }
    }
}
