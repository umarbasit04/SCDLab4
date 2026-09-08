package homework;

/**
 * Homework 2: Designing Immutable Classes.
 *
 * Fully immutable: the class is declared final (cannot be subclassed to
 * add mutable behavior), both fields are final and set only in the
 * constructor, and there are no setter/mutator methods.
 */
public final class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
