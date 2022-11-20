package use_cases.login_leaderboard;

/**
 * Check if the entered user password is acceptable to register user. If not,
 * allow the user to re-enter a new password.
 */
public class PasswordStrengthChecker {
    /***
     * Checks whether the string has at least one capital letter,
     * one numerical character and one special character by comparing ascii values within
     * the respective character class's ascii ranges.
     * @param pwd password.
     * @return boolean to see whether the password was strong enough.
     */
    public static boolean check(String pwd){
        int caps = 0;
        int nums = 0;
        int special_chars = 0;

        for(int i=0;i<pwd.length();i++){
            if ((int) pwd.charAt(i) >= 65 && (int) pwd.charAt(i) <= 90){
                caps += 1;
            }
            if ((int) pwd.charAt(i) >= 33 && (int) pwd.charAt(i) <= 47){
                special_chars += 1;
            }
            if ((int) pwd.charAt(i) >= 48 && (int) pwd.charAt(i) <= 57){
                nums += 1;
            }
        }
        return pwd.length() > 8 && (caps > 0 && nums > 0 && special_chars > 0);
    }
}
