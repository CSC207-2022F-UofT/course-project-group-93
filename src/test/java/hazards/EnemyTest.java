package hazards;

import entities.hazards.IHazardRequestModel;
import entities.hazards.Enemy;
import entities.hazards.StationaryEnemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the default method implementations in the Enemy class
 */
public class EnemyTest {
    /**
     * Test the default implementation of killsPlayer
     */
    @Test
    public void KillsPlayer() {
        Enemy enemy1 = new StationaryEnemy(3, 5);
        Enemy enemy2 = new StationaryEnemy(4, 5);
        IHazardRequestModel request = new TestHazardRequestModel(3, 5);
        Assertions.assertTrue(enemy1.killsPlayer(request));
        Assertions.assertFalse(enemy2.killsPlayer(request));
    }

    /**
     * Test the default implementations of getStartX and getStartY
     */
    @Test
    public void GetStartXY() {
        Enemy enemy = new StationaryEnemy(13, 55);
        Assertions.assertEquals(enemy.getStartX(), 13);
        Assertions.assertEquals(enemy.getStartY(), 55);
    }

    /**
     * Test the default implementations of setStartX and setStartY
     */
    @Test
    public void SetStartXY() {
        Enemy enemy = new StationaryEnemy(13, 55);
        enemy.setStartX(100);
        enemy.setStartY(200);
        Assertions.assertEquals(enemy.getStartX(), 100);
        Assertions.assertEquals(enemy.getStartY(), 200);
    }


}
