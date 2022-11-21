package use_cases.login_leaderboard;


/***
 * The input boundary that takes in the username,
 * email and password and dominoes into the register use case.
 */
public interface RegisterUserInputBoundary {

    /***
     * Abstract method to pass in the relevant information as per Clean Architecture.
     *
     * @param username String user's username
     * @param email String user's email
     * @param password String user's password.
     */
    void UserSetter(String username, String email, String password);

    /***
     * Abstract createUser method that will later be overriden in the Register Use Case.
     */
    void createUser();
}
