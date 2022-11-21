package use_cases.login_leaderboard;

import entities.login_leaderboard.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeaderboardGenerator {
    /**
     * Storing the sorted easy-level scores.
     */
    private final ArrayList<User> EASY = new ArrayList<>();
    /**
     * Storing the sorted medium-level scores.
     */
    private final ArrayList<User> MEDIUM = new ArrayList<>();
    /**
     * Storing the sorted hard-level scores.
     */
    private final ArrayList<User> HARD = new ArrayList<>();
    /**
     * A Map of all previous users. Mapping the username to the user.
     */
    private Map<String, User> users = new HashMap<>();

    /**
     * Updating the map with the previous users.
     * @param users : A map of all previous users.
     */
    public void setUsers(Map<String, User> users){
        this.users = users;
    }

    /**
     * Updating and sorting the easy-level scores.
     * @return : A sorted array list of User objects, sorted by Users easy scores
     */
    public ArrayList<String> sortEasy() {
        EASY.addAll(users.values());
        EASY.sort(new EasyLeaderboard());

        ArrayList<String> easySorted = new ArrayList<>();
        for (User user : EASY) {
            easySorted.add(user.getUsername() + " " + user.getEasyScore());
        }

        return easySorted;
    }

    /**
     * Updating and sorting the medium-level scores.
     *
     * @return : A sorted array list of User objects, sorted by Users medium scores
     */
    public ArrayList<String> sortMedium() {
        MEDIUM.addAll(users.values());
        MEDIUM.sort(new MediumLeaderboard());

        ArrayList<String> medSorted = new ArrayList<>();
        for (User user : MEDIUM) {
            medSorted.add(user.getUsername() + " " + user.getMediumScore());
        }

        return medSorted;
    }

    /**
     * Updating and sorting the hard-level scores.
     *
     * @return : A sorted array list of User objects, sorted by Users hard scores
     */
    public ArrayList<String> sortHard() {
        HARD.addAll(users.values());
        HARD.sort(new HardLeaderboard());

        ArrayList<String> hardScore = new ArrayList<>();
        for (User user : HARD) {
            hardScore.add(user.getUsername() + " " + user.getHardScore());
        }

        return hardScore;
    }
}