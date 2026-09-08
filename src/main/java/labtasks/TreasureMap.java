package labtasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Lab Task 3: Complex Data Types (Map).
 */
public class TreasureMap {

    private final Map<String, Double> treasures = new HashMap<>();

    public TreasureMap() {
        treasures.put("beach", 25.0);
        treasures.put("palm", 50.0);
        treasures.put("cove", 75.0);
    }

    public Map<String, Double> getTreasures() {
        return treasures;
    }

    // Updates "palm" to be its current value plus the size of the map
    public void updatePalmValue() {
        double current = treasures.get("palm");
        treasures.put("palm", current + treasures.size());
    }

    // Iterates through treasures.values() using a for-each loop to sum all doubles
    public double getTotalValue() {
        double total = 0.0;
        for (double value : treasures.values()) {
            total += value;
        }
        return total;
    }
}
