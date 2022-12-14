package use_cases.login_leaderboard;

import java.util.regex.Pattern;

/**
 * Register the user by creating a user object of the user.
 * If the user password is invalid (PasswordStrengthChecker), allow user to try again with a new password.
 * If the user password is valid, update the CSV with the user info, let the user know
 * they have been registered.
 * If the username already exists in the data file, tell the user "This user already exists"
 */
public class RegisterUser extends PreviousUsers implements IRegisterUserInputBoundary {

    final IRegisterUserOutputBoundary userPresenter;
    private String username;
    private String email;
    private String password;
    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
            "(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+" +
            "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
    private final IFileOutputBoundary UPDATECSV;


    public RegisterUser(IRegisterUserOutputBoundary userPresenter, IFileOutputBoundary input){
        this.userPresenter = userPresenter;
        this.UPDATECSV = input;
    }

    /**
     * Checks whether the password passed in from the UserInputBoundary is valid.
     * @return boolean that states whether the user's registered password is correct or not.
     */
    public boolean isValid(){
        return PasswordStrengthChecker.check(this.password);
    }

    /**
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

    /**
     * Actually creates the user, and also initiates the process of writing
     * to the user data csv file.
     */
    @Override
    public String createUser(){
        if (isValid() && !UserAlreadyExists() && ValidEmail()){
            UPDATECSV.updateNewUser(username, password, email);
            userPresenter.PrepareView("You have been registered.");
            return "yes";
        }
        if (isValid() && !UserAlreadyExists() && !ValidEmail()){
            userPresenter.PrepareView("Enter a valid email.");
            return "no";
        }

        else if(UserAlreadyExists()){
            userPresenter.PrepareView("This user already exists. Please log in now.");
            return "user exists";

        }
        else if(!isValid()){
            userPresenter.PrepareView("Your password is not valid");
            return "no";
        }
        return null;
    }

    /**
     * Checks if the user already exists by calling on the hashmap
     * of users created by the FileUser class.
     * @return boolean depending on whether user exists or not.
     */
    public boolean UserAlreadyExists(){
        return getUsers().containsKey(username);
    }


    /**
     * Checks whether the given email is valid by using a Regular Expression.
     * @return true or false depending on the validity of the input email.
     */
    public boolean ValidEmail(){

        return EMAIL_REGEX.matcher(email).matches();
    }
}