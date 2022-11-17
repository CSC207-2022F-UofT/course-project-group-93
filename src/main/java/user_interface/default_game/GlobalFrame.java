package user_interface.default_game;

import use_cases.login_leaderboard.RegisterUser;
import user_interface.login_leaderboard.LoginPanel;
import user_interface.login_leaderboard.RegisterPanel;
import user_interface.login_leaderboard.WelcomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlobalFrame {
    public JFrame window = new JFrame();
    public final int FRAME_WIDTH = 768;
    public final int FRAME_HEIGHT = 576;

    /**
     * A frame that controls the whole project (not implemented yet).
     **/
    public GlobalFrame() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("AstroMaze");
        window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        window.setResizable(false);
        window.setVisible(true);

    }

    /**
     * Sets the initial panel of the frame to the welcome screen.
     */
    public void setWelcomePanel() {
        WelcomePanel welcome = new WelcomePanel();
        window.add(welcome);

        // add extra methods in welcomepanel to ensure this works
        // properly when needed. For now, testing whether panel
        // changing actually works.
        window.setLocationRelativeTo(null);
        // centers the window..got it..
        window.setVisible(true);
    }


}
