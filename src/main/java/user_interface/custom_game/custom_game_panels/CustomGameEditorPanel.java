package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.custom_game_UI_adapters.CustomGameSubmissionManager;

import javax.swing.*;
import java.awt.*;

/**
 * UI to allow the user to build their own maze
 */
class CustomGameEditorPanel extends Panel implements ICustomGamePanel{
    private final JFrame editorFrame = new JFrame("Maze Editor");
    private final int SPRITE_TILE_SIZE = 16;
    private final int SCALE = 3; // may be changed to an unfixed variable later
    private final int TILE_SIZE = SPRITE_TILE_SIZE * SCALE;
    private final int MAX_PANEL_COL= 16;
    private final int MAX_PANEL_ROW = 12;

    /**
     * Displays the custom maze editor: a grid to build the maze, a bar to input stamina and a few buttons for saving,
     * and returning to previous menus
     */
    protected CustomGameEditorPanel (){
        final int PANEL_WIDTH = TILE_SIZE * MAX_PANEL_COL;
        final int PANEL_HEIGHT = TILE_SIZE * MAX_PANEL_ROW;

        //this will mostly be handled by Panel's methods later
        editorFrame.setLayout(new BorderLayout());
        editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editorFrame.setResizable(false);
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        editorFrame.setBackground(Color.black);

        displayEditor();
        displayButtons();

        editorFrame.pack();
        editorFrame.setLocationByPlatform(true);
        editorFrame.setVisible(true);
    }

    /**
     * add the editor to the panel
     */
    private void displayEditor(){
        EditorGrid editorGrid = new EditorGrid(MAX_PANEL_ROW, MAX_PANEL_COL, TILE_SIZE);
        editorFrame.add(editorGrid, BorderLayout.CENTER);
    }

    /**
     * add the submission and back buttons to the panel
     */
    private void displayButtons(){
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JButton submissionButton = new JButton("submit");
        submissionButton.addActionListener(new CustomGameSubmissionManager("CustomGameEditorPanel", new CustomGamePresenter()));

        bottomPanel.add(submissionButton);
        returnToCustomMainButton(bottomPanel);

        editorFrame.add(bottomPanel, BorderLayout.PAGE_END);
    }
}