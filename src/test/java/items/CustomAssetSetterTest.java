package items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.default_game.CustomAssetSetter;
import use_cases.items.MazeItems;
import use_cases.hazards.MazeHazards;


/**
 * Test the CustomAssetSetter class
 */
public class CustomAssetSetterTest {

    /**
     * Test CustomAssetSetter with a maze matrix with only 0's.
     */
    @Test
    public void LoadMazeOnlyZeroes() {
        MazeItems mazeItems = new MazeItems();
        MazeHazards mapHazards = new MazeHazards();
        CustomAssetSetter caSetter = new CustomAssetSetter("maze01.txt", mazeItems, mapHazards);

        Assertions.assertEquals(0, caSetter.getMazeAssetNum()[0][0]);
        Assertions.assertNotEquals(4, caSetter.getMazeAssetNum()[12][10]);
        Assertions.assertNull(caSetter.getMazeHazards().getEnemy(0, 0));
        Assertions.assertNull(caSetter.getMazeHazards().getObstacle(7, 7));
        Assertions.assertNull(caSetter.getMazeItems().get(3, 3));
    }

    /**
     * Test CustomAssetSetter with at least one of each integer.
     */
    @Test
    public void LoadMazeOneOfEach() {
        MazeItems mazeItems = new MazeItems();
        MazeHazards mapHazards = new MazeHazards();
        CustomAssetSetter caSetter = new CustomAssetSetter("maze02.txt", mazeItems, mapHazards);

        Assertions.assertEquals(0, caSetter.getMazeAssetNum()[0][0]);
        Assertions.assertEquals(1, caSetter.getMazeAssetNum()[1][0]);
        Assertions.assertEquals(4, caSetter.getMazeAssetNum()[4][0]);
        Assertions.assertNull(caSetter.getMazeHazards().getEnemy(5, 5));
        Assertions.assertNull(caSetter.getMazeHazards().getObstacle(7, 7));
        Assertions.assertNotNull(caSetter.getMazeHazards().getObstacle(0, 1));
        Assertions.assertNotNull(caSetter.getMazeItems().get(0, 4));
    }

    /**
     * Test CustomAssetSetter with each integer occurring multiple times.
     */
    @Test
    public void LoadMazeMultiple() {
        MazeItems mazeItems = new MazeItems();
        MazeHazards mapHazards = new MazeHazards();
        CustomAssetSetter caSetter = new CustomAssetSetter("maze03.txt", mazeItems, mapHazards);

        Assertions.assertEquals(5, caSetter.getMazeAssetNum()[5][0]);
        Assertions.assertEquals(5, caSetter.getMazeAssetNum()[5][1]);
        Assertions.assertEquals(5, caSetter.getMazeAssetNum()[5][2]);
        Assertions.assertNull(caSetter.getMazeHazards().getEnemy(0, 5));
        Assertions.assertNull(caSetter.getMazeHazards().getObstacle(1, 5));
        Assertions.assertNotNull(caSetter.getMazeItems().get(1, 5));
        Assertions.assertNotNull(caSetter.getMazeItems().get(2, 5));
    }
}

