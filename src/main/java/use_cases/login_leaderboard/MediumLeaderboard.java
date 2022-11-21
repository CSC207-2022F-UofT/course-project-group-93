package use_cases.login_leaderboard;

import entities.login_leaderboard.User;
import java.util.Comparator;

/**
 * Generate the top 10 scores for the medium mode.
 */
public class MediumLeaderboard implements Comparator<User> {

    /**
     * Compare the medium-level scores of the two users.
     * @param c : User c
     * @param d : User d
     */
    public int compare(User c, User d)
    {
        return c.getMediumScore() - d.getMediumScore();
    }
}