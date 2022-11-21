package use_cases.default_game;

import entities.hazards.Obstacle;
import entities.hazards.StationaryEnemy;
import entities.items.ItemBlackhole;
import entities.items.ItemKey;
import entities.items.ItemPhotons;
import use_cases.hazards.MazeHazards;
import use_cases.items.MazeItems;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CustomAssetSetter {

    /**
     * dimensions of the map
     */
    final int MAX_PANEL_COL = 16;
    final int MAX_PANEL_ROW = 12;

    /**
     * Matrix to store integers that correspond to various Assets in the maze.
     */
    private final int[][] mazeAssetNum;

    /**
     * UseCases that deal with the Assets
     */
    private final MazeItems mazeItems;
    private final MazeHazards mazeHazards;

    /**
     * Constructs CustomAssetSetter to place assets on the maze.
     */
    public CustomAssetSetter(String filePath, MazeItems mazeItems, MazeHazards mazeHazards) {
        this.mazeItems = mazeItems;
        this.mazeHazards = mazeHazards;
        this.mazeAssetNum = new int[MAX_PANEL_COL][MAX_PANEL_ROW];
        loadMaze(filePath);
        setAssets();
    }

    /**
     * Adds the integers to mazeAssetNum matrix that correspond to various Assets in the maze.
     *
     * @param filePath the filePath to the txt. file to get the integers from
     */
    public void loadMaze(String filePath) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < MAX_PANEL_COL && row < MAX_PANEL_ROW) {
                String line = br.readLine();
                while (col < MAX_PANEL_COL) {
                    String[] numbers = line.split(" ");  // remove whitespace
                    int num = Integer.parseInt(numbers[col]);  // change String -> int

                    mazeAssetNum[col][row] = num;
                    col++;
                }
                if (col == MAX_PANEL_COL) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    /**
     * Add assets to MazeItems & MazeHazards according to the mazeAssetNum matrix.
     */
    public void setAssets() {
        int col = 0;
        int row = 0;

        while (col < MAX_PANEL_COL && row < MAX_PANEL_ROW) {
            int assetNum = mazeAssetNum[col][row];  // go through each element in matrix
            switch (assetNum) {
                case 1:
                    mazeHazards.addObstacle(new Obstacle(row, col));
                    break;
                case 2:
                    mazeHazards.addEnemy(new StationaryEnemy(row, col));
                    break;
                case 3:
                    mazeItems.add(new ItemKey(row, col));
                    break;
                case 4:
                    mazeItems.add(new ItemPhotons(row, col));
                    break;
                case 5:
                    mazeItems.add(new ItemBlackhole(row, col));
            }
            col++;
            if (col == MAX_PANEL_COL) {
                col = 0;
                row++;
            }
        }
    }

    /**
     * Getters for testing
     */
    public int[][] getMazeAssetNum() {
        return this.mazeAssetNum;
    }

    public MazeItems getMazeItems() {
        return this.mazeItems;
    }

    public MazeHazards getMazeHazards() {
        return this.mazeHazards;
    }
}
