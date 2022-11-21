package use_cases.hazards;

import entities.default_game.IDrawOutputBoundary;
import entities.hazards.Enemy;
import entities.hazards.IEnemyRequestModel;
import entities.hazards.IHazardRequestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of enemies for a maze.
 */
public class MazeEnemies {
    /**
     * The internal list of enemies.
     */
    private final List<Enemy> enemies;

    /**
     * Construct a new MazeEnemies object with no enemies.
     */
    public MazeEnemies() {
        enemies = new ArrayList<>();
    }

    /**
     * Check whether the player is killed by any enemy.
     */
    public boolean isPlayerKilled(IHazardRequestModel request) {
        for (Enemy enemy : enemies) {
            if (enemy.killsPlayer(request))
                return true;
        }
        return false;
    }

    /**
     * Add an enemy.
     */
    public void add(Enemy enemy) {
        enemies.add(enemy);
    }

    /**
     * Update all enemies
     */
    public void update(IEnemyRequestModel request) {
        for (Enemy enemy : enemies) {
            enemy.update(request);
        }
    }

    /**
     * Reset all enemies to their starting positions.
     */
    public void reset() {
        for (Enemy enemy : enemies) {
            enemy.reset();
        }
    }

    /**
     * Get the enemy at the given position.
     *
     * @return The enemy, or null if there is no enemy at that position.
     */
    public Enemy get(int x, int y) {
        for (Enemy enemy : enemies) {
            if (enemy.getX() == x && enemy.getY() == y) {
                return enemy;
            }
        }
        return null;
    }

    /**
     * Delete the enemy at the given position if there is one.
     */
    public void delete(int x, int y) {
        Enemy enemy = get(x, y);
        if (enemy != null)
            enemies.remove(enemy);
    }

    /** Draw all enemies in the maze. */
    public void draw(IDrawOutputBoundary d) {
        for (Enemy enemy: enemies) {
            enemy.draw(d);
        }
    }
}
