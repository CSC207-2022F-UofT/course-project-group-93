package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

import java.util.Comparator;

/**
 * Generate the top 10 scores for the hard mode.
 */
public class HardLeaderboard implements Comparator<User> {

    /**
     * Compare the hard-level scores of the two users.
     * @param a : User a
     * @param b : User b
     */
    public int compare(User a, User b)
    {
        return a.getHardScore() - b.getHardScore();
    }
}