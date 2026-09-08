package labtasks;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ZooTest {

    @Test
    public void testGetAnimals_ReturnsExpectedAnimals() {
        Zoo zoo = new Zoo();
        List<String> animals = zoo.getAnimals();
        assertEquals(3, animals.size());
        assertEquals("lion", animals.get(0));
    }

    @Test
    public void testGetAnimals_AddThrowsUnsupportedOperationException() {
        Zoo zoo = new Zoo();
        List<String> animals = zoo.getAnimals();
        assertThrows(UnsupportedOperationException.class, () -> animals.add("flamingo"));
    }
}
