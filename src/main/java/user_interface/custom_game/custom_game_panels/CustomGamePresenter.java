package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.custom_game_UI_adapters.ICustomGamePresenter;
import java.util.Objects;

/**
 * Handles switching between custom maze UI panels
 */
public class CustomGamePresenter implements ICustomGamePresenter, ICustomGamePanel {

    /**
     * Call the constructors of one of the custom game panels
     */
    public void callCustomGamePanel(String panelName) {
        if (Objects.equals(panelName, "CustomGameMainPanel")){
            new CustomGameMainPanel();
        }
        else if (Objects.equals(panelName, "CustomGameInitializerPanel")){
            new CustomGameInitializerPanel();
        }
        else if (Objects.equals(panelName, "CustomGameEditorPanel")){
            new CustomGameEditorPanel();
        }
        else if (Objects.equals(panelName, "customGameInvalidWarnPanel")){
            System.out.println("To do!");
            //TODO display a popup with back buttons and add overloaded method so you can add error message too
            // and handle choices
        }
        else {
            System.out.println("To do!");
            //TODO throw an error
        }
    }

    /**
     * Overloaded version of the above method allowing the main custom game panel to be the default should no parameter
     * be provided
     */
    public void callCustomGamePanel () {
        new CustomGameMainPanel();
    }


    /**
     * Create a TempMaze object to store a custom maze while it is being made
     */
    public void createTempMaze(){
        //void until the initializer is done
    }

}