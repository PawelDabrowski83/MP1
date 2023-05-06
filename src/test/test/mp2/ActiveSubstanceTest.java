package mp2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ActiveSubstanceTest {
    @AfterEach
    public void cleanUp() {
        Map<String, ActiveSubstance> activeSubstanceMap = ActiveSubstance.allActiveSubstances;
        while(activeSubstanceMap.size() > 0) {
            Map.Entry<String, ActiveSubstance> entry = activeSubstanceMap.entrySet().iterator().next();
            entry.getValue().remove();
        }
    }


    @Test
    public void newActiveSubstances() {
        int counter = 0;
        for (String name : ActiveSubstance.SUBSTANCE_LIST) {
            new ActiveSubstance(name);
            counter++;
        }

        for (String name : ActiveSubstance.SUBSTANCE_LIST) {
            ActiveSubstance current = ActiveSubstance.find(name);
            if (current != null) {
                counter--;
                assertEquals(name, current.getName());
            }
        }
        assertEquals(counter, 0);
    }

    @Test
    public void removeTest() {
        ActiveSubstance activeSubstance = ActiveSubstance.getRandomSubstance();
        activeSubstance.remove();

        assertEquals(0, ActiveSubstance.allActiveSubstances.size());
    }
}
