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
    /**
     * A frame that controls the whole project (not implemented yet).
     **/
    public GlobalFrame() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("AstroMaze");
        int FRAME_WIDTH = 768;
        int FRAME_HEIGHT = 576;
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

        if (welcome.state == 0){
            RegisterPanel r = new RegisterPanel();
            r.setVisible(true);
            welcome.add(new RegisterPanel());
        }
        else if (welcome.state == 1){
            LoginPanel l = new LoginPanel();
            l.setVisible(true);
            welcome.add(new LoginPanel());
        }


        // add extra methods in welcomepanel to ensure this works
        // properly when needed. For now, testing whether panel
        // changing actually works.
        window.setLocationRelativeTo(null);
        // centers the window..got it..
        window.setVisible(true);
    }

    public void changePanel(JPanel panel){
    }
}
