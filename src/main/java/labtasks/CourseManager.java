package labtasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Lab Task 2: Safe Collection Modification.
 * Demonstrates the ConcurrentModificationException caused by removing
 * from a List with a for-each loop, and the fix using an Iterator.
 */
public class CourseManager {

    private final List<String> subjects =
            new ArrayList<>(Arrays.asList("6.045", "6.005", "8.03", "6.813", "14.03"));

    public List<String> getSubjects() {
        return subjects;
    }

    // BUGGY: removing from a list while iterating it with a for-each loop
    // throws ConcurrentModificationException.
    public void removeCourse6Buggy() {
        for (String subject : subjects) {
            if (subject.startsWith("6.")) {
                subjects.remove(subject);
            }
        }
    }

    // FIXED: use an Iterator and its own remove() method, which safely
    // updates the iterator's internal state.
    public void removeCourse6Fixed() {
        Iterator<String> iter = subjects.iterator();
        while (iter.hasNext()) {
            String subject = iter.next();
            if (subject.startsWith("6.")) {
                iter.remove();
            }
        }
    }
}
