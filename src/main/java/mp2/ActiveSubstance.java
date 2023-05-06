package mp2;

import java.util.*;

public class ActiveSubstance {
    public static final String[] SUBSTANCE_LIST = new String[]{
            "Anadol", "Barbaryna", "Czekaheksymol", "Drożyna", "Epi", "Faktenol", "Giterol",
            "Haminamicyna", "Imienal"
    };
    private static int counter = 0;
    protected static Map<String, ActiveSubstance> allActiveSubstances = new HashMap<>();
    private int id;
    private String name;
    private List<Medicine> medicines = new ArrayList<>();

    public ActiveSubstance(String name) {
        this.id = counter++;
        this.name = name;
        allActiveSubstances.put(name, this);
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public static ActiveSubstance find(String name) {
        if (allActiveSubstances.containsKey(name)) {
            return allActiveSubstances.get(name);
        }
        return null;
    }

    public static void generateActiveSubstances() {
        for (String name : SUBSTANCE_LIST) {
            new ActiveSubstance(name);
        }
    }
}
