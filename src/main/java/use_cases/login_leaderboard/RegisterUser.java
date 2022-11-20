package use_cases.login_leaderboard;
import entities.login_leaderboard.User;
/**
 * Register the user by creating a user object of the user.
 * If the user password is invalid (PasswordStrengthChecker), allow user to try again with a new password.
 * If the user password is valid, update the CSV with the user info, let the user know
 * they have been registered.
 */
public class RegisterUser {

    private String username;
    private String email;
    private String password;

    public RegisterUser(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public boolean isValid(){
        return PasswordStrengthChecker.check(this.password);
    }

    public void createUser(){
        if (isValid()){
            User current_user =  new User(this.username, this.email, this.password);

            // write to file
            // TODO
        }
    }



}
