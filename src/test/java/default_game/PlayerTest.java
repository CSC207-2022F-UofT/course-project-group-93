package default_game;

import com.sun.tools.javac.Main;
import entities.default_game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.default_game.UpdatePlayer;

public class PlayerTest {
    /**
     * Check the setter and getter methods of Player.
     */
    @Test
    public void SetGetPlayerXY() {
        UpdatePlayer.setPlayerX(100);
        UpdatePlayer.setPlayerY(50);

        Assertions.assertEquals(100, Player.getPlayerX());
        Assertions.assertEquals(50, Player.getPlayerY());
    }

    /**
     * Check that player positions are updated correctly.
     */
    @Test
    public void UpdatePlayerMoveUpTest() {
        UpdatePlayer.setPlayerX(50);
        UpdatePlayer.setPlayerY(50);

        UpdatePlayer.movePlayerUp();
        Assertions.assertEquals(50, Player.getPlayerX());
        Assertions.assertEquals(10, Player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveDownTest() {
        UpdatePlayer.setPlayerX(50);
        UpdatePlayer.setPlayerY(50);

        UpdatePlayer.movePlayerDown();
        Assertions.assertEquals(50, Player.getPlayerX());
        Assertions.assertEquals(90, Player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveLeftTest() {
        UpdatePlayer.setPlayerX(50);
        UpdatePlayer.setPlayerY(50);

        UpdatePlayer.movePlayerLeft();
        Assertions.assertEquals(10, Player.getPlayerX());
        Assertions.assertEquals(50, Player.getPlayerY());
    }

    @Test
    public void UpdatePlayerMoveRightTest() {
        UpdatePlayer.setPlayerX(50);
        UpdatePlayer.setPlayerY(50);

        UpdatePlayer.movePlayerRight();
        Assertions.assertEquals(90, Player.getPlayerX());
        Assertions.assertEquals(50, Player.getPlayerY());
    }
}
