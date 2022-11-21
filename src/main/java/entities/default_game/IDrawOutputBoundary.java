package entities.default_game;

import java.awt.Graphics2D;

/**
 * The output boundary for drawing to the window.
 * The presenter can implement this interface, and any entities
 * which need drawing can have a draw method which takes this.
 */
public interface IDrawOutputBoundary {
    /** Get the size of a tile in pixels */
    int getTileSize();

    /** Get the Graphics2D object associated with the window. */
    Graphics2D graphics();
}
