package hazards;

import entities.hazards.IHazardRequestModel;

/**
 * an IHazardRequestModel implementation for testing only
 */
public class TestHazardRequestModel implements IHazardRequestModel {
    /**
     * simulated player x position
     */
    private final int playerX;
    /**
     * simulated player y position
     */
    private final int playerY;

    /**
     * Create a new test hazard request model with the given player position.
     */
    public TestHazardRequestModel(int playerX, int playerY) {
        this.playerX = playerX;
        this.playerY = playerY;
    }


    @Override
    public int getPlayerX() {
        return playerX;
    }

    @Override
    public int getPlayerY() {
        return playerY;
    }

    @Override
    public int mazeWidth() { return 10; }

    @Override
    public int mazeHeight() { return 10; }
}
