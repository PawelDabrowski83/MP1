package mp2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class MedicineTest {

    @Test
    public void newMedicines() {
        Map<String, Medicine> expectedMedicines = new HashMap<>();
        for (String name : Medicine.GENERIC_MEDICINE_NAMES) {
            expectedMedicines.put(name, new Medicine(name, prepareRandomRecipes()));
        }

        assertEquals(expectedMedicines, Medicine.allMedicines);
    }

    private List<ActiveSubstance> prepareRandomRecipes() {
        int numberOfSubstances = ThreadLocalRandom.current().nextInt(1, 4);
        List<ActiveSubstance> medicineRecipe = new ArrayList<>();
        while (numberOfSubstances-- > 0) {
            medicineRecipe.add(ActiveSubstance.getRandomSubstance());
        }
        return medicineRecipe;
    }

    @Test
    public void simpleTest() {
        Map<String, Medicine> expectedMedicines = new HashMap<>();
        Medicine panadol = new Medicine("Panadol", List.of(ActiveSubstance.getRandomSubstance()));
        expectedMedicines.put("Panadol", panadol);

        Map<String, Medicine> actualExtent = Medicine.allMedicines;

        assertEquals(expectedMedicines, actualExtent);
    }

}