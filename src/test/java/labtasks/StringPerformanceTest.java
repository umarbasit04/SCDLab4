package labtasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringPerformanceTest {

    private final StringPerformance sp = new StringPerformance();

    @Test
    public void testBothMethods_ProduceSameResult_SmallN() {
        // Correctness check on a small n before trusting the timing run
        assertEquals(sp.buildString(50), sp.buildStringBuilder(50));
    }

    @Test
    public void testExecutionTime_N_10000() {
        int n = 10000;

        long startString = System.nanoTime();
        String resultString = sp.buildString(n);
        long endString = System.nanoTime();
        long stringTimeMs = (endString - startString) / 1_000_000;

        long startBuilder = System.nanoTime();
        String resultBuilder = sp.buildStringBuilder(n);
        long endBuilder = System.nanoTime();
        long builderTimeMs = (endBuilder - startBuilder) / 1_000_000;

        // Correctness: both approaches must produce the same final string
        assertEquals(resultString, resultBuilder);

        System.out.println("buildString(" + n + ") time:        " + stringTimeMs + " ms");
        System.out.println("buildStringBuilder(" + n + ") time: " + builderTimeMs + " ms");
        System.out.println("(Expected: buildString is much slower due to O(n^2) copying of immutable Strings; "
                + "buildStringBuilder is close to O(n) thanks to mutable internal buffering.)");

        // NOTE: this is a timing observation printed to the console for the report,
        // not a strict correctness assertion, since exact timings vary by machine/JIT warm-up.
    }
}
