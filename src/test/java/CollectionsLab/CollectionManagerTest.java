package CollectionsLab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectionManagerTest {

    @Test
    public void testDropCourse6_RemovesMatchingSubjects() {
        CollectionManager manager = new CollectionManager();
        manager.addSubject("6.045");
        manager.addSubject("6.005");
        manager.addSubject("8.03");
        manager.addSubject("6.813");
        manager.addSubject("14.03");

        manager.dropCourse6();

        assertEquals(2, manager.getSubjects().size());
        assertEquals("8.03", manager.getSubjects().get(0));
        assertEquals("14.03", manager.getSubjects().get(1));
    }

    @Test
    public void testGetReadOnlySubjects_ThrowsOnAdd() {
        CollectionManager manager = new CollectionManager();
        manager.addSubject("8.03");

        var readOnly = manager.getReadOnlySubjects();
        assertThrows(UnsupportedOperationException.class, () -> readOnly.add("18.06"));
    }
}
