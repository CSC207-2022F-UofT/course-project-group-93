package user_interface.custom_game.custom_game_file_management;

import adapters.custom_game.custom_game_file_adapters.TempMaze;
import use_cases.custom_game.custom_game_file_management.ICustomGameFileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles all reading and writing to the files used by the customization feature
 */
public class CustomGameFileManager implements ICustomGameFileManager{

    /**
     * Store a custom maze in customMazes.txt
     * (assumes the maze has already been verified to be both writable and solvable)
     */
    public void storeNewCustomMaze(){
        try {
            String mazeName = "customMazes/New Maze"; //Temporary line to make this runnable
            //String mazeName = TempMaze.getMazeTitle(); //will be replaced with this once the initializer is done
            File mazeFile = new File(mazeName);
            FileWriter mazeWriter = new FileWriter(mazeFile);

            for (int x = 0; x < TempMaze.getRowTotal(); x++) {
                for (int y = 0; y < TempMaze.getColumnTotal(); y++) {
                    mazeWriter.write(TempMaze.getTileNum(x, y) + " ");
                }
                mazeWriter.write(System.getProperty("line.separator"));
            }
//            mazeWriter.write(System.getProperty("line.separator"));
//            mazeWriter.write(TempMaze.getMazeCreator());
            mazeWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
