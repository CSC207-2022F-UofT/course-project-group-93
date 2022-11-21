package hazards;

import entities.hazards.ChasingEnemy;
import entities.hazards.Enemy;
import entities.hazards.Obstacle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.hazards.MazeHazards;

public class ChasingEnemyTest {
    /** Check that a chasing enemy moves towards the player. */
    @Test
    void MovesTowardsPlayer() {
        MazeHazards hazards = new MazeHazards();
        Enemy enemy = new ChasingEnemy(3, 3);
        hazards.addEnemy(enemy);
        TestHazardRequestModel request = new TestHazardRequestModel(5, 5);
        hazards.update(request);
        Assertions.assertTrue(enemy.getX() > 3 || enemy.getY() > 3);
    }

    /** Check that the enemy doesn't move off-screen */
    @Test
    void TestOffscreen() {
        MazeHazards hazards = new MazeHazards();
        Enemy enemy = new ChasingEnemy(8, 2);
        hazards.addEnemy(enemy);
        // even if playerX/playerY is invalid, we shouldn't go off-screen.
        TestHazardRequestModel request = new TestHazardRequestModel(100, 100);
        for (int i = 0; i < 30; i++) {
            hazards.update(request);
            Assertions.assertTrue(enemy.getX() >= 0);
            Assertions.assertTrue(enemy.getY() >= 0);
            Assertions.assertTrue(enemy.getX() < request.mazeWidth());
            Assertions.assertTrue(enemy.getY() < request.mazeHeight());
        }
    }

    /** Check that the enemy doesn't move onto an obstacle */
    @Test
    void TestObstacle() {
        MazeHazards hazards = new MazeHazards();
        Enemy enemy = new ChasingEnemy(6, 7);
        TestHazardRequestModel request = new TestHazardRequestModel(9, 7);
        Obstacle obstacle = new Obstacle(7, 7);
        hazards.addEnemy(enemy);
        hazards.addObstacle(obstacle);
        hazards.update(request);
        Assertions.assertFalse(obstacle.blocksTile(enemy.getX(), enemy.getY()));
    }

    /** Check that the enemy eventually reaches the player. */
    @Test
    void TestReachesPlayer() {
        MazeHazards hazards = new MazeHazards();
        Enemy enemy = new ChasingEnemy(2, 1);
        TestHazardRequestModel request = new TestHazardRequestModel(9, 9);
        // this obstacle shouldn't be in its way
        Obstacle obstacle = new Obstacle(0, 1);
        hazards.addEnemy(enemy);
        hazards.addObstacle(obstacle);
        for (int i = 0; i < 20; i++) {
            hazards.update(request);
            if (hazards.isPlayerKilled(request)) {
                // success!
                return;
            }
        }
        // the enemy didn't reach the player in 20 steps
        Assertions.fail();
    }

}
