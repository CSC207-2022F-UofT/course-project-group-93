package adapters.custom_game.custom_game_UI_adapters;

import adapters.custom_game.custom_game_file_adapters.EditorTile;
import adapters.custom_game.custom_game_file_adapters.TempMaze;
import use_cases.custom_game.custom_game_file_management.CustomGameValidator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Handles clicks to all buttons that should take the user to a new panel to and from the custom maze section
 */
public class CustomGameSubmissionManager implements ActionListener {
    private final String PANEL;
    private final ICustomGamePresenter presenter;
    private ICustomInitializerInput initializer;

    /**
     * Listens for clicks to buttons on the custom maze panels, calls the verifier if necessary and calls the
     * appropriate panels in response.
     *
     * @param panel the current panel of the submission button (CustomGameInitializerPanel or CustomGameEditorPanel)
     * @param presenter an instance of the presenter interface to display a new panel after verification
     */
    public CustomGameSubmissionManager(String panel, ICustomGamePresenter presenter){
        this.PANEL = panel;
        this.presenter = presenter;
    }

    /**
     * Listens for clicks to buttons on the custom maze panels, calls the verifier if necessary and calls the
     * appropriate panels in response.
     *
     * @param panel the current panel of the submission button (CustomGameInitializerPanel or CustomGameEditorPanel)
     * @param presenter an instance of the presenter interface to display a new panel after verification
     */
    public CustomGameSubmissionManager(String panel, ICustomGamePresenter presenter, ICustomInitializerInput initializer){
        this.PANEL = panel;
        this.presenter = presenter;
        this.initializer = initializer;
    }

    /**
     * Signal that the TempMaze being edited is ready for verification and storage
     *
     * @param e represents a click on a button in one of the custom maze panels
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(PANEL, "CustomGameEditorPanel")){
            verifyEditorInput(TempMaze.getMaze());
        }
        else if (Objects.equals(PANEL, "CustomGameMainPanel")){
            presenter.callCustomGamePanel("CustomGameInitializerPanel");
        }
        else if (Objects.equals(PANEL, "toCustomMain")){
            presenter.callCustomGamePanel("CustomGameMainPanel");
        }
        else if (Objects.equals(PANEL, "CustomGameInitializerPanel")){
            verifyInitializerInput();
        }
    }

    /**
     * Calls and sends a maze to the verifier. If it is valid, it calls the presenter to return the User to the custom
     * game main menu. If not, it shows the user a panel warning that their input was invalid.
     *
     * @param maze the maze just created in the editor
     */
    public void verifyEditorInput(EditorTile[][] maze){
        if (CustomGameValidator.verifyMaze(maze)){
            //TODO should display a popup to say the maze was written
            presenter.callCustomGamePanel("CustomGameMainPanel");
        }
        else {
            presenter.callCustomGamePanel("customGameInvalidWarnPanel");
        }
    }

    /**
     * Calls and sends maze initializer values to the verifier. If it is valid, it calls the presenter to take the
     * User to the editor. If not, it shows the user a panel warning that their input was invalid.
     */
    public void verifyInitializerInput(){
        String mazeName = initializer.getMazeName();
        if (CustomGameValidator.verifyName(mazeName)){
            presenter.callCustomGamePanel("CustomGameEditorPanel");
            //if more options are included in the initializer, more checks will be added
            prepareTempMaze(mazeName);
        }
        else {
            presenter.callCustomGamePanel("customGameInvalidWarnPanel");
        }
    }

    /**
     * Sends information from the initializer to TempMaze
     */
    public void prepareTempMaze(String mazeName){
        TempMaze.setMazeTitle(mazeName);
        //TempMaze.setMazeCreator();
    }
}
