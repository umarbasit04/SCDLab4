package homework;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Homework 1: Enhanced Map Tracking.
 * Tracks unique student records with a Map<Integer, String> keyed by ID.
 */
public class StudentDirectory {

    private final Map<Integer, String> students = new HashMap<>();

    public void addStudent(int id, String name) {
        students.put(id, name);
    }

    public String getStudent(int id) {
        return students.get(id);
    }

    // Returns the key set (student IDs) as a read-only view, so callers
    // cannot add/remove IDs through the returned Set.
    public Set<Integer> getAllIDs() {
        return Collections.unmodifiableSet(students.keySet());
    }
}
