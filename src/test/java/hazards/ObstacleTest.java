package hazards;


import entities.hazards.Obstacle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the Obstacle class
 */
public class ObstacleTest {
    /**
     * Try constructing a normal obstacle.
     */
    @Test
    public void ConstructObstacle() {
        Obstacle o = new Obstacle(1, 3, 5, 8);
        Assertions.assertEquals(o.getX(), 1);
        Assertions.assertEquals(o.getY(), 3);
        Assertions.assertEquals(o.getWidth(), 5);
        Assertions.assertEquals(o.getHeight(), 8);
    }

    /**
     * Try constructing an obstacle with a width of 0.
     */
    @Test
    public void ConstructObstacleZeroWidth() {
        try {
            new Obstacle(3, 5, 0, 14);
            Assertions.fail("Obstacle should throw an exception when given a size of zero.");
        } catch (Obstacle.BadSizeException e) {
            // (no code needed here)
        }
    }

    /**
     * Try constructing an obstacle with a negative height.
     */
    @Test
    public void ConstructObstacleNegativeHeight() {
        try {
            new Obstacle(3, 5, 13, -1);
            Assertions.fail("Obstacle should throw an exception when given a size of zero.");
        } catch (Obstacle.BadSizeException e) {
            // (no code needed here)
        }
    }

    /**
     * Test setX, setY
     */
    @Test
    public void SetPos() {
        Obstacle o = new Obstacle(1, 1, 2, 3);
        o.setX(17);
        o.setY(192);
        Assertions.assertEquals(o.getX(), 17);
        Assertions.assertEquals(o.getY(), 192);
    }

    /**
     * Test setWidth, setHeight
     */
    @Test
    public void SetSize() {
        Obstacle o = new Obstacle(1, 1, 2, 3);
        o.setWidth(123);
        o.setHeight(456);
        Assertions.assertEquals(o.getWidth(), 123);
        Assertions.assertEquals(o.getHeight(), 456);
    }

    /**
     * Test blocksPlayer with a 1x1 obstacle.
     */
    @Test
    public void OneByOneBlocksPlayer() {
        Obstacle o = new Obstacle(486, 333);
        Assertions.assertTrue(o.blocksTile(486, 333));
        Assertions.assertFalse(o.blocksTile(487, 333));
        Assertions.assertFalse(o.blocksTile(486, 332));
    }

    /**
     * Test blocksPlayer with a larger obstacle.
     */
    @Test
    public void BlocksPlayer() {
        Obstacle o = new Obstacle(100, 200, 32, 12);
        Assertions.assertTrue(o.blocksTile(131, 200));
        Assertions.assertFalse(o.blocksTile(99, 204));
        Assertions.assertFalse(o.blocksTile(132, 202));
    }
}
