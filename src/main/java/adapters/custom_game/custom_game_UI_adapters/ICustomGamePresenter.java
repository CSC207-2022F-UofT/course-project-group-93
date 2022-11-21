package adapters.custom_game.custom_game_UI_adapters;

/**
 * Handles switching between custom maze UI panels
 */
public interface ICustomGamePresenter {

    void callCustomGamePanel();

    void callCustomGamePanel(String panelName);

    void createTempMaze();
}
