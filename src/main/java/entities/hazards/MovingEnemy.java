package entities.hazards;

/** An enemy which moves. */
public abstract class MovingEnemy extends Enemy {
    /**
     * Current x position of enemy
     */
    private int currX;
    /**
     * Current y position of enemy
     */
    private int currY;

    /**
     * Create a new moving enemy with the given starting position.
     */
    public MovingEnemy(int startX, int startY) {
        super(startX, startY);
        currX = startX;
        currY = startY;
    }

    @Override
    public int getX() {
        return currX;
    }

    @Override
    public int getY() {
        return currY;
    }

    @Override
    public void reset() {
        // reset to starting position
        currX = getStartX();
        currY = getStartY();
    }

    /**
     * Set current x position.
     * This should only be used by the update() methods of subclasses of
     * MovingEnemy.
     */
    protected void setX(int x) {
        currX = x;
    }

    /**
     * Set current y position.
     */
    protected void setY(int y) {
        currY = y;
    }
}
