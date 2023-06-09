package mp2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ActiveSubstance {
    protected static final String[] SUBSTANCE_LIST = new String[]{
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
        if (medicines.size() == 0) {
            allActiveSubstances.remove(this.name);
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

    protected static ActiveSubstance getRandomSubstance() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, SUBSTANCE_LIST.length);
        return new ActiveSubstance(ActiveSubstance.SUBSTANCE_LIST[randomIndex]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActiveSubstance that = (ActiveSubstance) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        return Objects.equals(medicines, that.medicines);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (medicines != null ? medicines.hashCode() : 0);
        return result;
    }
}
