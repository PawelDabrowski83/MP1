package mp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ActiveSubstanceTest {



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
}
