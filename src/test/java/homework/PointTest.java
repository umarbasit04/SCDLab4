package homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    @Test
    public void testGetX_ReturnsConstructorValue() {
        Point p = new Point(3, 7);
        assertEquals(3, p.getX());
    }

    @Test
    public void testGetY_ReturnsConstructorValue() {
        Point p = new Point(3, 7);
        assertEquals(7, p.getY());
    }

    @Test
    public void testToString_FormatsCorrectly() {
        Point p = new Point(1, 2);
        assertEquals("Point(1, 2)", p.toString());
    }

    @Test
    public void testTwoInstances_AreIndependent() {
        // Demonstrates immutability: creating a second Point never
        // affects the first, since there is no way to mutate either.
        Point p1 = new Point(1, 1);
        Point p2 = new Point(9, 9);
        assertEquals(1, p1.getX());
        assertEquals(9, p2.getX());
    }
}
