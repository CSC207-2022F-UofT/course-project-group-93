package entities.default_game;

/**
 * Represents the player. Player data is updated in UpdatePlayer class.
 */
public class Player extends Entity {

    private static int playerX;

    private static int playerY;

    /**
     * Get the player's current x-coordinate.
     *
     * @return the current x-coordinate
     */
    public static int getPlayerX() {
        return playerX;
    }

    /**
     * Get the player's current y-coordinate.
     *
     * @return the current y-coordinate.
     */
    public static int getPlayerY() {
        return playerY;
    }

    /**
     * Set the player's x-coordinate.
     *
     * @param X x-coordinate to set the player to.
     */
    public static void setPlayerX(int X) {
        playerX = X;
    }

    /**
     * Set the player's y-coordinate.
     *
     * @param Y y-coordinate to set the player to.
     */
    public static void setPlayerY(int Y) {
        playerY = Y;
    }

    /**
     * Change the player's x-coordinate by moveByX.
     *
     * @param moveByX value to change the x-coordinate by.
     */
    public static void movePlayerX(int moveByX) {
        playerX += moveByX;
    }

    /**
     * Change the player's y-coordinate by moveByY.
     *
     * @param moveByY value to change the y-coordinate by.
     */
    public static void movePlayerY(int moveByY) {
        playerY += moveByY;
    }
}
