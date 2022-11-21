package use_cases.custom_game.custom_game_file_management;

import adapters.custom_game.custom_game_file_adapters.EditorTile;
import user_interface.custom_game.custom_game_file_management.CustomGameFileManager;

/**
 * Responsible for verifying input the user wants to store: maze names from the initializer panel and mazes from the
 * editor panel
 */
public class CustomGameValidator {

    /**
     * Checks if a new custom maze is valid
     * @param maze the maze to check
     * @return whether the maze is valid or not
     */
    public static boolean verifyMaze(EditorTile[][] maze){
        //run tests and if they pass, call:
        CustomGameFileManager fileManager = new CustomGameFileManager();
        fileManager.storeNewCustomMaze();

        return true;
        //tests should include checking if TempMaze contains a maze that can be written (ex. exists, all rows/cols same
        // len etc.)
    }

    /**
     * Checks if a maze name is unique
     * @param name the maze name to check
     * @return whether the name is unique or not
     */
    public static boolean verifyName(String name){
        //TODO - when the initializer is made
        return true;
    }
}
