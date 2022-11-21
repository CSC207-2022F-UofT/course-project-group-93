package adapters.default_game;

import use_cases.default_game.UpdatePlayer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * User controller for the game.
 */
public class GamePanelController implements KeyListener {
    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            UpdatePlayer.movePlayerUp();
        }
        if (code == KeyEvent.VK_S) {
            UpdatePlayer.movePlayerDown();
        }
        if (code == KeyEvent.VK_D) {
            UpdatePlayer.movePlayerRight();
        }
        if (code == KeyEvent.VK_A) {
            UpdatePlayer.movePlayerLeft();
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
