package hazards;

import entities.hazards.ChasingEnemy;
import entities.hazards.IHazardRequestModel;
import entities.hazards.Enemy;
import entities.hazards.Obstacle;
import entities.hazards.StationaryEnemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.hazards.MazeHazards;

/**
 * Test the MazeHazards class
 */
public class MazeHazardsTest {

    /**
     * test isPlayerBlocked with no hazards
     */
    @Test
    public void IsPlayerBlockedEmpty() {
        MazeHazards hazards = new MazeHazards();
        IHazardRequestModel player = new TestHazardRequestModel(1, 12);
        Assertions.assertFalse(hazards.isPlayerBlocked(player));
    }

    /**
     * test isPlayerBlocked with some obstacles
     */
    @Test
    public void IsPlayerBlockedObstacles() {
        MazeHazards hazards = new MazeHazards();
        hazards.addObstacle(new Obstacle(12, 33));
        hazards.addObstacle(new Obstacle(48, 5));
        IHazardRequestModel player1 = new TestHazardRequestModel(12, 33);
        Assertions.assertTrue(hazards.isPlayerBlocked(player1));
        IHazardRequestModel player2 = new TestHazardRequestModel(48, 6);
        Assertions.assertFalse(hazards.isPlayerBlocked(player2));
    }


    /**
     * test isPlayerKilled with no hazards
     */
    @Test
    public void IsPlayerKilledEmpty() {
        MazeHazards hazards = new MazeHazards();
        IHazardRequestModel player = new TestHazardRequestModel(1, 12);
        Assertions.assertFalse(hazards.isPlayerKilled(player));
    }

    /**
     * test isPlayerKilled with some enemies
     */
    @Test
    public void IsPlayerKilledEnemies() {
        MazeHazards hazards = new MazeHazards();
        hazards.addEnemy(new StationaryEnemy(1, 2));
        hazards.addEnemy(new StationaryEnemy(3, 4));
        IHazardRequestModel player1 = new TestHazardRequestModel(1, 2);
        Assertions.assertTrue(hazards.isPlayerKilled(player1));
        IHazardRequestModel player2 = new TestHazardRequestModel(2, 1);
        Assertions.assertFalse(hazards.isPlayerKilled(player2));
    }

    /**
     * Test getting and removing enemies.
     */
    @Test
    public void EnemyManipulation() {
        MazeHazards hazards = new MazeHazards();
        hazards.deleteObstacle(5, 3);
        Enemy enemy = new StationaryEnemy(10, 3);
        hazards.addEnemy(enemy);
        Assertions.assertEquals(hazards.getEnemy(10, 3), enemy);
        Assertions.assertNull(hazards.getEnemy(3, 10));
        hazards.deleteEnemy(10, 3);
        Assertions.assertNull(hazards.getEnemy(10, 3));
    }

    /**
     * Test getting and removing obstacles.
     */
    @Test
    public void ObstacleManipulation() {
        MazeHazards hazards = new MazeHazards();
        Assertions.assertNull(hazards.getObstacle(3, 5));
        hazards.deleteObstacle(5, 3);
        Obstacle o1 = new Obstacle(3, 5);
        hazards.addObstacle(o1);
        Assertions.assertEquals(hazards.getObstacle(3, 5), o1);
        hazards.deleteObstacle(3, 5);
        Assertions.assertNull(hazards.getObstacle(3, 5));
    }

    /** Test reset method. */
    @Test
    public void Reset() {
        MazeHazards hazards = new MazeHazards();
        Enemy enemy = new ChasingEnemy(5, 5);
        hazards.addEnemy(enemy);
        hazards.update(new TestHazardRequestModel(1, 1));
        // enemy should have moved towards the player.
        Assertions.assertFalse(enemy.getX() == enemy.getStartX() && enemy.getY() == enemy.getStartY());
        hazards.reset();
        // enemy should now be back at starting position.
        Assertions.assertTrue(enemy.getX() == enemy.getStartX() && enemy.getY() == enemy.getStartY());
    }
}
