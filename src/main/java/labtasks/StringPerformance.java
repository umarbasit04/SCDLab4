package labtasks;

/**
 * Lab Task 1: Mutability & Performance (String vs StringBuilder).
 */
public class StringPerformance {

    // Concatenates numbers 0..n-1 using an immutable String (s = s + i)
    public String buildString(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + i;
        }
        return s;
    }

    // Concatenates numbers 0..n-1 using a mutable StringBuilder
    public String buildStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}
