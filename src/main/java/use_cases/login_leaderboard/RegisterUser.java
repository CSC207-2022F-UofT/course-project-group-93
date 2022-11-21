package use_cases.login_leaderboard;
import entities.login_leaderboard.User;

/**
 * Register the user by creating a user object of the user.
 * If the user password is invalid (PasswordStrengthChecker), allow user to try again with a new password.
 * If the user password is valid, update the CSV with the user info, let the user know
 * they have been registered.
 */
public class RegisterUser implements RegisterUserInputBoundary {

    private String username;
    private String email;
    private String password;

    /***
     * Checks whether the password passed in from the UserInputBoundary is valid.
     * @return boolean that states whether the user's registered password is correct or not.
     */
    public boolean isValid(){
        return PasswordStrengthChecker.check(this.password);
    }

    /***
     * Initializes and saves the user's details to later initialize a User entity.
     * @param username String user's username
     * @param email String user's email
     * @param password String user's password.
     */
    @Override
    public void UserSetter(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /***
     * Actually creates the user, and also initiates the process of writing
     * to the user data csv file.
     */
    @Override
    public void createUser(){
        if (isValid()){
            User current_user =  new User(this.username, this.email, this.password);
            // write to file
            // TODO
        }
    }

}