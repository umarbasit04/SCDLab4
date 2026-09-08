package labtasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreasureMapTest {

    @Test
    public void testInitialTotalValue() {
        TreasureMap map = new TreasureMap();
        // 25.0 + 50.0 + 75.0
        assertEquals(150.0, map.getTotalValue(), 0.001);
    }

    @Test
    public void testUpdatePalmValue_AddsMapSize() {
        TreasureMap map = new TreasureMap();
        map.updatePalmValue(); // palm = 50.0 + 3 (map size) = 53.0
        assertEquals(53.0, map.getTreasures().get("palm"), 0.001);
    }

    @Test
    public void testTotalValue_AfterUpdatingPalm() {
        TreasureMap map = new TreasureMap();
        map.updatePalmValue();
        // 25.0 + 53.0 + 75.0
        assertEquals(153.0, map.getTotalValue(), 0.001);
    }
}
