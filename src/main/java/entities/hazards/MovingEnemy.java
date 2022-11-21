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
     * Create a new moving enemy.
     * @param startX The starting X position
     * @param startY The starting Y position
     */
    public MovingEnemy(int startX, int startY) {
        super(startX, startY);
        // better default image for moving enemies.
        setImageByName("moving-enemy");
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
