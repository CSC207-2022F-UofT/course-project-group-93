package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

import java.util.Comparator;

/**
 * Generate the top 10 scores for the easy mode.
 */
public class EasyLeaderboard implements Comparator<User> {
    /**
     * Compare the easy-level scores of the two users.
     * @param a : User a
     * @param b : User b
     */
    public int compare(User a, User b)
    {
        return a.getEasyScore() - b.getEasyScore();
    }
}