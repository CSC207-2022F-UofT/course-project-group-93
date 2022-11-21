package adapters.login_leaderboard;

import use_cases.login_leaderboard.RegisterUserOutputBoundary;

/***
 * The register use case presenter that aids in telling us whether
 * the registry was successful or not.
 */
public class RegisterUserPresenter {

    private final RegisterUserOutputBoundary useCasePresenter;

    public RegisterUserPresenter(RegisterUserOutputBoundary useCasePresenter) {
        this.useCasePresenter = useCasePresenter;
    }

    public void DisplayResult(){
    }
}
