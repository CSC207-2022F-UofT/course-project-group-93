package hazards;

import entities.hazards.IHazardRequestModel;
import entities.hazards.ChasingEnemy;
import entities.hazards.MovingEnemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.hazards.MazeHazards;

public class MovingEnemyTest {
    /** Test that resetting a moving enemy returns it to its starting position. */
    @Test
    public void Reset() {
        MazeHazards hazards = new MazeHazards();
        MovingEnemy enemy = new ChasingEnemy(5, 5);
        hazards.addEnemy(enemy);
        IHazardRequestModel request = new TestHazardRequestModel(3, 3);
        // this should move the enemy (but that's not what we're testing here)
        hazards.update(request);
        enemy.reset();
        Assertions.assertEquals(enemy.getX(), 5);
        Assertions.assertEquals(enemy.getY(), 5);
    }
}
