package adapters.login_leaderboard;

import use_cases.login_leaderboard.RegisterUserInputBoundary;

/**
 * Transforms the information from RegisterScreen to be accessible for RegisterUser.
 * Passes username, password, and email address.
 */
public class RegisterUserController {
    private final RegisterUserInputBoundary useCaseInteractor;
    public RegisterUserController(RegisterUserInputBoundary useCaseInteractor) {
        this.useCaseInteractor = useCaseInteractor;
    }

    public void performUseCase(String username, String password, String email) {
        this.useCaseInteractor.UserSetter(username, email, password);
        this.useCaseInteractor.createUser();
    }
}