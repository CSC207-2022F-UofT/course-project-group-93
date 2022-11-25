package adapters.login_leaderboard;

import use_cases.login_leaderboard.*;

import java.util.ArrayList;

/**
 * Transforms the information from all three leaderboards into a viewable format.
 */
public class LeaderboardPresenter {
    private final ArrayList<String> EASYSCORES = new ArrayList<>();
    private final ArrayList<String> MEDSCORES = new ArrayList<>();
    private final ArrayList<String> HARDSCORES = new ArrayList<>();
    private final LeaderboardGenerator SCORES = new LeaderboardGenerator();

    public void setScores(UsersCreation users){
        SCORES.users = users.prev.users;
    }

    /**
     * Return the top 10 easy-level user scores. If there are less than 10 scores,
     * return the stored scores.
     * @return : A hashmap mapping the top 10 users username to easy scores.
     */
    public ArrayList<String> getTop10Easy() {

        ArrayList<String> arr = SCORES.sortEasy();
        for (int i = 0; i < 10; i++){
            if (i < arr.size()){
                EASYSCORES.add(arr.get(i));
            }
        } return EASYSCORES;
    }

    /**
     * return the top 10 medium-level user scores.
     * @return : A hashmap mapping the top 10 users username to medium scores.
     */
    public ArrayList<String> getTop10Med() {
        ArrayList<String> arr = SCORES.sortMedium();
        for (int i = 0; i < 10; i++){
            if (i < arr.size()){
                MEDSCORES.add(arr.get(i));
            }
        } return MEDSCORES;
    }

    /**
     * return the top 10 hard-level user scores.
     * @return : A hashmap mapping the top 10 users username to easy scores.
     */
    public ArrayList<String> getTop10Hard() {
        ArrayList<String> arr = SCORES.sortHard();
        for (int i = 0; i < 10; i++){
            if (i < arr.size()){
                HARDSCORES.add(arr.get(i));
            }
        } return HARDSCORES;
    }
}