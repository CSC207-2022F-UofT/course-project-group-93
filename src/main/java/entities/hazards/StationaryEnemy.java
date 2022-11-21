package entities.hazards;

/**
 * An enemy which does not move from its starting position
 */
public class StationaryEnemy extends Enemy {

    /**
     * Create a new stationary enemy.
     * @param startX The starting X position.
     * @param startY The starting Y position.
     */
    public StationaryEnemy(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void reset() {
        // we don't need to do anything here
    }

    @Override
    public void update(IEnemyRequestModel request) {
        // we don't need to do anything here
    }

    @Override
    public int getX() {
        return getStartX();
    }

    @Override
    public int getY() {
        return getStartY();
    }
}
