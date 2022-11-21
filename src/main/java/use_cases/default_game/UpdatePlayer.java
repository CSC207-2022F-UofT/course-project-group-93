package use_cases.default_game;

import entities.default_game.Player;

/**
 * Update the Player's data.
 */
public class UpdatePlayer {
    public static int playerSpeed = 40; // might move this to controller

    /**
     * Move the player's position upwards.
     */
    public static void movePlayerUp() {
        Player.movePlayerY(-playerSpeed);
    }

    /**
     * Move the player's position downwards.
     */
    public static void movePlayerDown() {
        Player.movePlayerY(playerSpeed);
    }

    /**
     * Move the player's position to the right.
     */
    public static void movePlayerRight() {
        Player.movePlayerX(playerSpeed);
    }

    /**
     * Move the player's position to the left.
     */
    public static void movePlayerLeft() {
        Player.movePlayerX(-playerSpeed);
    }

    public static int getPlayerX() {
        return Player.getPlayerX();
    }

    public static int getPlayerY() {
        return Player.getPlayerY();
    }

    public static void setPlayerX(int X) {
        Player.setPlayerX(X);
    }

    public static void setPlayerY(int Y) {
        Player.setPlayerY(Y);
    }
}
