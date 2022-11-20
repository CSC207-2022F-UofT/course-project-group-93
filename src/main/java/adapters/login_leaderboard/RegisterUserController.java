package adapters.login_leaderboard;
import use_cases.login_leaderboard.RegisterUser;
/**
 * Transforms the information from RegisterScreen to be accessible for RegisterUser.
 * Passes username, password, and email address.
 */
public class RegisterUserController {


    public static void invokeRegisterUserController(String username, String email, String pwd) {
        new RegisterUser(username, email, pwd);
    }
}

