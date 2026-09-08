package labtasks;

import org.junit.jupiter.api.Test;
import java.util.ConcurrentModificationException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseManagerTest {

    @Test
    public void testRemoveCourse6Buggy_ThrowsConcurrentModificationException() {
        CourseManager manager = new CourseManager();
        assertThrows(ConcurrentModificationException.class, manager::removeCourse6Buggy);
    }

    @Test
    public void testRemoveCourse6Fixed_LeavesOnlyExpectedCourses() {
        CourseManager manager = new CourseManager();
        manager.removeCourse6Fixed();

        List<String> remaining = manager.getSubjects();
        assertEquals(2, remaining.size());
        assertEquals("8.03", remaining.get(0));
        assertEquals("14.03", remaining.get(1));
    }
}
