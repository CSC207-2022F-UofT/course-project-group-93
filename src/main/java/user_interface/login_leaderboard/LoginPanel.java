package user_interface.login_leaderboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Allows user to enter their username and password. If both are correct, take the user to
 * the home screen. Else, allow the user to reset or re-enter their password.
 */
public class LoginPanel extends Panel implements ActionListener {

    private String username;
    private String password;

    /***
     * Constructs the login panel where the user can enter their username
     * and password.
     */
    public LoginPanel() {

        this.build();
        JLabel returnUserName = new JLabel("Please enter your username");
        returnUserName.setBounds(270, 100, 450, 70);


        JTextField username = new JTextField(50);
        username.setBounds(160, 180, 450, 30);

        JLabel returnPassword = new JLabel("Please enter your password");
        returnPassword.setBounds(270, 300, 450, 70);


        JPasswordField password = new JPasswordField(50);
        password.setBounds(160, 380, 450, 30);

        JButton logIn = new JButton("Log into your account");
        logIn.setBounds(250, 420, 50, 50);
        logIn.setSize(245, 30);

        logIn.setActionCommand("Cool");

        labelSet.add(returnUserName);
        labelSet.add(returnPassword);
        labelFormat(labelSet);


        this.add(returnUserName);
        this.add(username);
        this.add(returnPassword);
        this.add(password);
        this.add(logIn);

        logIn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
