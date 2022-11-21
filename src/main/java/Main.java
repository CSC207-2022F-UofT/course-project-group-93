import adapters.login_leaderboard.RegisterUserController;
import use_cases.login_leaderboard.RegisterUserInputBoundary;
import use_cases.login_leaderboard.RegisterUser;
import user_interface.custom_game.custom_game_panels.CustomGamePresenter;
import user_interface.default_game.GlobalFrame;
import user_interface.default_game.GamePanel;
import user_interface.login_leaderboard.RegisterPanel;

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
        //setupCustomMazeMenu();
    }

    /**
     * Build the Game Panel
     **/
    private static void setupGame() {
        GlobalFrame globalFrame = new GlobalFrame();
        globalFrame.setWelcomePanel();
        //tempDefaultGameRunner();
    }

    /**
     * Temporary access to the custom maze main menu
     **/
    private static void setupCustomMazeMenu () {
        CustomGamePresenter tempPresenter = new CustomGamePresenter();
        tempPresenter.callCustomGamePanel();
    }

    /**
     * Temporary access to the default game
     **/
    private static void tempDefaultGameRunner(){
        GamePanel gamePanelUI = new GamePanel();
        gamePanelUI.createGamePanel();
    }

    private static void createUsecaseEngine(){
        // Usecase + adapters framework
        RegisterUserInputBoundary input = new RegisterUser();
        RegisterUserController controller = new RegisterUserController(input);


        // UI
        RegisterPanel output = new RegisterPanel();
        String[] arr;
        arr = output.getUserInfo();
        controller.performUseCase(arr[0], arr[1], arr[2]);

        // call register panel

    }
}