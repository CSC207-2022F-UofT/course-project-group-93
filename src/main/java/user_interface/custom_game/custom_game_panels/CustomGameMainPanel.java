package user_interface.custom_game.custom_game_panels;
import adapters.custom_game.custom_game_UI_adapters.CustomGameSubmissionManager;
import user_interface.login_leaderboard.Panel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Displays the game customization main menu. Allows the user to select a custom maze to play or build a new one
 */
class CustomGameMainPanel extends Panel implements ICustomGamePanel {
    private final JFrame FRAME = new JFrame("custom main frame");

    /**
     * The first panel to be displayed on entering the custom maze section. Shows a list of custom mazes and a button
     * to take the user to the maze editor
     */
    protected CustomGameMainPanel (){
        //        this.build();

        //every this.tempMainFrame will be replaced by this once custom mazes are linked to the main game and the
        // following section will be removed
        this.FRAME.setSize(768, 576);
        this.FRAME.setResizable(false);
        this.FRAME.setVisible(true);
        this.FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.FRAME.setLayout(new BorderLayout(10, 10));

        displayTitle();
        listCustomMazes();
        displayCustomOptions();
    }


    /**
     * Display the custom maze section title
     */
    private void displayTitle(){
        JLabel header = new JLabel("Custom Mazes", SwingConstants.CENTER);
        labelSet.add(header);
        labelFormat(labelSet);

        this.FRAME.add(header, BorderLayout.PAGE_START);
    }

    /**
     * Display a selection of custom mazes
     */
    private void listCustomMazes(){
        JList<String> mazeListElement = new JList<>(getMazes());
        mazeListElement.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mazeListElement.setLayoutOrientation(JList.VERTICAL_WRAP);
        mazeListElement.setVisibleRowCount(-1);

        JScrollPane mazeListScroller = new JScrollPane(mazeListElement);
        mazeListScroller.setPreferredSize(new Dimension(250, 80));
        this.FRAME.add(mazeListElement, BorderLayout.CENTER);
    }

    /**
     * Retrieve all stored custom mazes and sort them alphabetically
     * @return an ArrayList of all the stored custom mazes
     */
    private String[] getMazes(){
        File mazeFolder = new File("customMazes/");
        File[] mazeFileList = mazeFolder.listFiles();
        ArrayList<String> mazeList = new ArrayList<>();

        assert mazeFileList != null;
        for (File file : mazeFileList) {
            mazeList.add(file.getName());
        }
        mazeList.sort(String.CASE_INSENSITIVE_ORDER);
        String[] mazeArray = new String[mazeList.size()];
        mazeArray = mazeList.toArray(mazeArray);
        return mazeArray;
    }

    /**
     * Display all the actions a user can take involving custom mazes
     * Currently, this is only creating them
     */
    private void displayCustomOptions(){
        JButton editMazeButton = new JButton("create a new maze");
        editMazeButton.addActionListener(new CustomGameSubmissionManager("CustomGameMainPanel", new CustomGamePresenter()));
        this.FRAME.add(editMazeButton, BorderLayout.PAGE_END);
    }
}