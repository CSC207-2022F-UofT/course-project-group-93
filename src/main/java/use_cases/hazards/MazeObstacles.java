package use_cases.hazards;

import entities.default_game.IDrawOutputBoundary;
import entities.hazards.Obstacle;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of obstacles for a maze.
 */
public class MazeObstacles {
    /**
     * The internal list of obstacles.
     */
    private final List<Obstacle> obstacles;

    /**
     * Construct a MazeObstacles object with no obstacles.
     */
    public MazeObstacles() {
        obstacles = new ArrayList<>();
    }


    /**
     * Check whether the given tile is blocked by an obstacle.
     */
    public boolean isTileBlocked(int x, int y) {
        return get(x, y) != null;
    }

    /**
     * Add an obstacle.
     */
    public void add(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    /**
     * Get the obstacle at the specified position.
     */
    public Obstacle get(int x, int y) {
        for (Obstacle o : obstacles) {
            if (o.blocksTile(x, y)) {
                return o;
            }
        }
        return null;
    }

    /**
     * Delete the obstacle at the specified position.
     */
    public void delete(int x, int y) {
        Obstacle obstacle = get(x, y);
        if (obstacle != null)
            obstacles.remove(obstacle);
    }

    /** Draw all obstacles in the maze. */
    public void draw(IDrawOutputBoundary d) {
        for (Obstacle obstacle: obstacles) {
            obstacle.draw(d);
        }
    }
}
