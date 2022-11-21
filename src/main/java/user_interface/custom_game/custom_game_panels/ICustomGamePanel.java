package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.custom_game_UI_adapters.CustomGameSubmissionManager;

import javax.swing.*;
import java.awt.*;

/**
 * Common UI methods for the custom game section
 */
interface ICustomGamePanel {

    /**
     * draws a button on the panel that cancels all current tasks and returns the user to the custom game main menu
     * @param x the x positioning on the panel
     * @param y the y positioning on the panel
     */
    default void returnToCustomMainButton(JComponent component, int x, int y){
        JButton backButton = new JButton("go back");
        backButton.addActionListener(new CustomGameSubmissionManager("toCustomMain", new CustomGamePresenter()));
        backButton.setBounds(x, y, 50, 30);
        component.add(backButton);
    }

    /**
     * default positioning is the bottom right of the panel
     */
    default void returnToCustomMainButton(JComponent component){
        JButton backButton = new JButton("go back");
        backButton.addActionListener(new CustomGameSubmissionManager("toCustomMain", new CustomGamePresenter()));
        backButton.setPreferredSize(new Dimension(50, 30));
        component.add(backButton);
    }

    /**
     * draws a button on the panel that will return the user to the game's main menu
     */
    default void returnToMainButton(){
        //TODO - default implementation
    }
}
