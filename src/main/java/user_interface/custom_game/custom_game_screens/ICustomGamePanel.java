package user_interface.custom_game.custom_game_screens;

/**
 * Common UI methods for the custom game section
 */
interface ICustomGamePanel {

    /**
     * draws a button on the screen that cancels all current tasks and returns the user to the custom game main menu
     * @param x the x positioning on the screen
     * @param y the y positioning on the screen
     */
    default void returnToCustomMainButton(int x, int y){

    }

    /**
     * default positioning is the bottom right of the screen
     */
    default void returnToCustomMainButton(){

    }
}
