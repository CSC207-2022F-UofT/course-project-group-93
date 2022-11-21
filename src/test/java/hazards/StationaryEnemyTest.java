package hazards;

import entities.hazards.Enemy;
import entities.hazards.StationaryEnemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the StationaryEnemy class
 */
public class StationaryEnemyTest {
    /**
     * Test getX and getY
     */
    @Test
    public void GetXY() {
        Enemy enemy = new StationaryEnemy(-2, -5);
        Assertions.assertEquals(enemy.getX(), -2);
        Assertions.assertEquals(enemy.getY(), -5);
    }

    /**
     * Test that update doesn't affect x, y, startX, startY.
     */
    @Test
    public void Update() {
        Enemy enemy = new StationaryEnemy(1, 2);
        enemy.update(null);
        Assertions.assertEquals(enemy.getX(), 1);
        Assertions.assertEquals(enemy.getY(), 2);
        Assertions.assertEquals(enemy.getStartX(), 1);
        Assertions.assertEquals(enemy.getStartY(), 2);
    }

    /**
     * Test that reset doesn't affect x, y, startX, startY
     */
    @Test
    public void Reset() {
        Enemy enemy = new StationaryEnemy(33, 44);
        enemy.reset();
        Assertions.assertEquals(enemy.getX(), 33);
        Assertions.assertEquals(enemy.getY(), 44);
        Assertions.assertEquals(enemy.getStartX(), 33);
        Assertions.assertEquals(enemy.getStartY(), 44);
    }

}
