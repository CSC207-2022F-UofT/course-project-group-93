import user_interface.custom_game.custom_game_panels.CustomGamePresenter;
import user_interface.default_game.GlobalFrame;

/**
 * Run the game
 **/
public class Main {
    /**
     * Run this method to run the game panel
     *
     * @param args for when we need some input
     */
    public static void main(String[] args) {
        setupGame();
        setupCustomMazeMenu();
    }

    /**
     * Build the Game Panel
     **/
    private static void setupGame() {
        GlobalFrame globalFrame = new GlobalFrame();
        globalFrame.setWelcomePanel();
    }

    /**
     * Temporary access to the custom maze main menu
     **/
    private static void setupCustomMazeMenu () {
        CustomGamePresenter tempPresenter = new CustomGamePresenter();
        tempPresenter.callCustomGamePanel();
    }
}
