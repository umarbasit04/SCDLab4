package homework;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDirectoryTest {

    @Test
    public void testAddStudent_AndRetrieveByID() {
        StudentDirectory dir = new StudentDirectory();
        dir.addStudent(1, "Ayesha");
        dir.addStudent(2, "Bilal");

        assertEquals("Ayesha", dir.getStudent(1));
        assertEquals("Bilal", dir.getStudent(2));
    }

    @Test
    public void testGetAllIDs_ContainsAllAddedIDs() {
        StudentDirectory dir = new StudentDirectory();
        dir.addStudent(1, "Ayesha");
        dir.addStudent(2, "Bilal");
        dir.addStudent(3, "Sara");

        Set<Integer> ids = dir.getAllIDs();
        assertEquals(3, ids.size());
        assertTrue(ids.contains(1));
        assertTrue(ids.contains(2));
        assertTrue(ids.contains(3));
    }

    @Test
    public void testGetAllIDs_AddThrowsUnsupportedOperationException() {
        StudentDirectory dir = new StudentDirectory();
        dir.addStudent(1, "Ayesha");

        Set<Integer> ids = dir.getAllIDs();
        assertThrows(UnsupportedOperationException.class, () -> ids.add(99));
    }

    @Test
    public void testGetAllIDs_RemoveThrowsUnsupportedOperationException() {
        StudentDirectory dir = new StudentDirectory();
        dir.addStudent(1, "Ayesha");

        Set<Integer> ids = dir.getAllIDs();
        assertThrows(UnsupportedOperationException.class, () -> ids.remove(1));
    }
}
