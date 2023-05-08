package mp2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static mp2.Medicine.remove;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicineTest {

    Map<String, Medicine> expectedMedicines;

    @BeforeEach
    public void init() {
        expectedMedicines = new HashMap<>();
    }

    @AfterEach
    public void cleanUp() {
        Map<String, Medicine> medicineMap = Medicine.allMedicines;
        while(medicineMap.size() > 0) {
            Map.Entry<String, Medicine> entry = medicineMap.entrySet().iterator().next();
            remove(entry.getValue());
        }
    }

    @Test
    public void newMedicines() {
        for (String name : Medicine.GENERIC_MEDICINE_NAMES) {
            expectedMedicines.put(name, new Medicine(name, prepareRandomRecipes()));
        }

        assertEquals(expectedMedicines, Medicine.allMedicines);
    }

    private Map<String, ActiveSubstance> prepareRandomRecipes() {
        int numberOfSubstances = ThreadLocalRandom.current().nextInt(1, 4);
        Map<String, ActiveSubstance> medicineRecipe = new HashMap<>();
        while (numberOfSubstances-- > 0) {
            medicineRecipe.put(ActiveSubstance.getRandomSubstance().getName(), ActiveSubstance.getRandomSubstance());
        }
        return medicineRecipe;
    }

    @Test
    public void simpleTest() {
        ActiveSubstance randomSubstance = ActiveSubstance.getRandomSubstance();
        Map<String, ActiveSubstance> recipe = new HashMap<>();
        recipe.put(randomSubstance.getName(), randomSubstance);
        Medicine panadol = new Medicine("Panadol", recipe);
        expectedMedicines.put("Panadol", panadol);

        Map<String, Medicine> actualExtent = Medicine.allMedicines;

        assertEquals(expectedMedicines, actualExtent);
    }

    @Test
    public void addTrackingSubstanceTest() {
    }

}