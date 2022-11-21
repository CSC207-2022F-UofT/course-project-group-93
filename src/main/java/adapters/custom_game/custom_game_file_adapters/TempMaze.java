package adapters.custom_game.custom_game_file_adapters;

/**
 * A place to store a custom maze while it is being edited and methods to convert it into a text file
 */
public class TempMaze {
    private static EditorTile[][] tileGrid;
    private static String mazeTitle;
    private static String mazeCreator;


    /**
     * Redefine tileGrid with dimensions
     * @param rows the number of rows there will be in this new maze
     * @param cols the number of columns there will be in this new maze
     */
    public static void setGridSize(int rows, int cols){
        TempMaze.tileGrid = new EditorTile[rows][cols];
    }

    /**
     * Add a new Tile object to tile Grid
     * @param x the x position of the Tile to be added
     * @param y the y position of the Tile to be added
     * @param tile the Tile object to be added to tileGrid
     */
    public static void addTile(int x, int y, EditorTile tile){
        //TODO check if x and y are within bounds first
        TempMaze.tileGrid[x][y] = tile;
    }

    /**
     * Sets the title of this TempMaze to be stored later in the custom maze text files
     * @param title the unique title of this TempMaze
     */
    public static void setMazeTitle(String title){
        TempMaze.mazeTitle = title;
    }

    /**
     * Gets the title of this TempMaze for storage in the custom maze text files
     */
    public static String getMazeTitle(){
        return TempMaze.mazeTitle;
    }

    /**
     * Sets the title of this TempMaze to be stored later in the custom maze text files
     * @param creator the username of the user creating this TempMaze
     */
    public static void setMazeCreator(String creator){
        TempMaze.mazeCreator= creator;
    }

    /**
     * Gets the username of the creator of this TempMaze for storage in the custom maze text files
     */
    public static String getMazeCreator(){
        return TempMaze.mazeCreator;
    }

    /**
     * Gets the TempMaze object
     */
    public static EditorTile[][] getMaze(){
        return TempMaze.tileGrid;
    }

    /**
     * @param x the x position of the Tile to be retrieved
     * @param y the y position of the Tile to be retrieved
     * @return the EditorTile at position (x, y)
     * */
    public static EditorTile getTile(int x, int y){
        return tileGrid[x][y];
    }

    /**
     * Get the number representing the Tile at (x, y) for storage in text files
     * @param x the x position of the Tile to be retrieved
     * @param y the y position of the Tile to be retrieved
     * @return the number representing the EditorTile at position (x, y)
     * */
    public static int getTileNum(int x, int y){
        return tileGrid[x][y].getNumCode(); //TODO check if out of bounds
    }

    /**
     * @return the number of rows in this TempMaze
     */
    public static int getRowTotal(){
        return tileGrid.length;
    }

    /**
     * @return the number of columns in this TempMaze
     */
    public static int getColumnTotal(){
        return tileGrid[0].length;
    }
}
