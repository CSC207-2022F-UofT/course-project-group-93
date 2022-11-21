package entities.hazards;

/**
 * Interface for communicating relevant information for hazard checking.
 */
public interface IHazardRequestModel {
    /**
     * Get the x position of the player.
     */
    int getPlayerX();

    /**
     * Get the y position of the player.
     */
    int getPlayerY();

    /** The width of the maze in tiles. */
    int mazeWidth();

    /** The height of the maze in tiles. */
    int mazeHeight();
}
