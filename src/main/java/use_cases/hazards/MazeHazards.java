package use_cases.hazards;

import entities.default_game.IDrawOutputBoundary;
import entities.hazards.Enemy;
import entities.hazards.IEnemyRequestModel;
import entities.hazards.IHazardRequestModel;
import entities.hazards.Obstacle;

/**
 * A collection of hazards for a maze.
 * A hazard is currently an obstacle or an enemy, but more types of hazards could be added in the future.
 */
public class MazeHazards {
    /**
     * An object which manages the enemies for the maze.
     */
    private final MazeEnemies enemies;
    /**
     * An object which manages the obstacles for the maze.
     */
    private final MazeObstacles obstacles;

    /**
     * Create an empty maze hazards object.
     */
    public MazeHazards() {
        enemies = new MazeEnemies();
        obstacles = new MazeObstacles();
    }

    /**
     * Add an enemy to the maze hazards.
     */
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    /**
     * Add an obstacle to the maze hazards.
     */
    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    /**
     * Check whether the player is blocked by a hazard.
     */
    public boolean isPlayerBlocked(IHazardRequestModel request) {
        return obstacles.isTileBlocked(request.getPlayerX(), request.getPlayerY());
    }

    /**
     * Check whether the player is blocked by a hazard.
     */
    public boolean isPlayerKilled(IHazardRequestModel request) {
        return enemies.isPlayerKilled(request);
    }

    /**
     * Update the maze hazards.
     * This should be called at a fixed interval (e.g. every 0.5 seconds).
     * The game can be made more difficult by calling this more often, since enemies will move faster.
     */
    public void update(IHazardRequestModel request) {
        enemies.update(new IEnemyRequestModel() {
            @Override
            public boolean isTileBlockedForEnemies(int x, int y) {
                return obstacles.isTileBlocked(x, y);
            }

            @Override
            public int getPlayerX() {
                return request.getPlayerX();
            }

            @Override
            public int getPlayerY() {
                return request.getPlayerY();
            }

            @Override
            public int mazeWidth() { return request.mazeWidth(); }

            @Override
            public int mazeHeight() { return request.mazeHeight(); }
        });
    }

    /**
     * Reset the maze hazards to their initial state.
     * This can be called when the player is killed, and the user has to restart the level.
     */
    public void reset() {
        enemies.reset();
    }

    /**
     * Get the enemy at the given position.
     *
     * @return The enemy, or null if there is no enemy at this position.
     */
    public Enemy getEnemy(int x, int y) {
        return enemies.get(x, y);
    }

    /**
     * Delete the enemy at the given position if there is one.
     */
    public void deleteEnemy(int x, int y) {
        enemies.delete(x, y);
    }

    /**
     * Get the obstacle at the given position.
     *
     * @return The obstacle, or null if there is no obstacle at this position.
     */
    public Obstacle getObstacle(int x, int y) {
        return obstacles.get(x, y);
    }

    /**
     * Delete the obstacle at the given position if there is one.
     */
    public void deleteObstacle(int x, int y) {
        obstacles.delete(x, y);
    }

    /**
     * Draw all hazards in the maze.
     */
    public void draw(IDrawOutputBoundary d) {
        obstacles.draw(d);
        enemies.draw(d);
    }
}
