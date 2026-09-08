package labtasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Lab Task 4: Unmodifiable Wrappers.
 */
public class Zoo {

    private final List<String> animals = new ArrayList<>(Arrays.asList("lion", "tiger", "bear"));

    // Returns the mutable internal list wrapped as a read-only view
    public List<String> getAnimals() {
        return Collections.unmodifiableList(animals);
    }
}
