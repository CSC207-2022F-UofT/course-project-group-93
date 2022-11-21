package entities.hazards;

import entities.default_game.Entity;
import entities.default_game.IDrawOutputBoundary;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * An obstacle in a maze
 */
public class Obstacle extends Entity {
    /**
     * The x position of the obstacle.
     */
    private int x;
    /**
     * The y position of the obstacle.
     */
    private int y;
    /**
     * The width of the obstacle, in tiles.
     */
    private int width;
    /**
     * The height of the obstacle, in tiles.
     */
    private int height;
    /**
     * The image which the obstacle should be drawn with.
     */
    private BufferedImage image;


    /**
     * An exception indicating that the obstacle has been set to an invalid (zero or negative) size.
     * This is a RuntimeException, because it would be annoying to check for this everywhere,
     * and it's a relatively unlikely mistake.
     */
    public static class BadSizeException extends RuntimeException {
        /**
         * Create a new BadSizeException.
         *
         * @param isWidth If true, the problem is the obstacle's width. If false, it's the obstacle's height.
         * @param value   The attempted width/height value.
         */

        public BadSizeException(boolean isWidth, int value) {
            super(getMessage(isWidth, value));
        }

        /**
         * Create an appropriate error message, to be passed to the superclass constructor.
         */
        private static String getMessage(boolean isWidth, int value) {
            if (isWidth)
                return "Bad obstacle width: " + value;
            else
                return "Bad obstacle height: " + value;
        }
    }

    /**
     * Throw a BadSizeException if width is invalid.
     */
    public static void checkWidth(int width) {
        if (width <= 0)
            throw new BadSizeException(true, width);
    }

    /**
     * Throw a BadSizeException if height is invalid.
     */
    public static void checkHeight(int height) {
        if (height <= 0)
            throw new BadSizeException(false, height);
    }


    /**
     * Construct a new obstacle.
     * @param x The X position of the obstacle.
     * @param y The Y position of the obstacle.
     * @param width The width of the obstacle. This must be positive, or a BadSizeException will be thrown.
     * @param height The height of the obstacle. This must be positive, or a BadSizeException will be thrown.
     */
    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        checkWidth(width);
        checkHeight(height);
        this.width = width;
        this.height = height;
        setImageByName("rock");
    }

    /**
     * Construct a new 1x1 object at (x, y).
     */
    public Obstacle(int x, int y) {
        this(x, y, 1, 1);
    }


    /**
     * Set te image used to draw the obstacle.
     *
     * @param name The file name of the image not including the .png extension.
     *             Currently, this should be "brick-wall", "tree", or "rock".
     */
    public void setImageByName(String name) {
        InputStream imageStream = getClass().getClassLoader().getResourceAsStream("hazards/" + name + ".png");
        if (imageStream != null) {
            try {
                setImage(ImageIO.read(imageStream));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Set the image used to draw the obstacle.
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Get the x position of the obstacle.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y position of the obstacle.
     */
    public int getY() {
        return y;
    }

    /**
     * Set the x position of the obstacle.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set the y position of the obstacle.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the width of the obstacle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the obstacle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the width of the obstacle. w must be positive, otherwise a BadSizeException will be thrown.
     */
    public void setWidth(int w) {
        checkWidth(w);
        width = w;
    }

    /**
     * Set the height of the obstacle. h must be positive, otherwise a BadSizeException will be thrown.
     */
    public void setHeight(int h) {
        checkHeight(h);
        height = h;
    }

    /**
     * Check whether the obstacle blocks the given point.
     */
    public boolean blocksTile(int pointX, int pointY) {
        return pointX >= x && pointY >= y && pointX < x + width && pointY < y + height;

    }

    /** Draw the obstacle. */
    public void draw(IDrawOutputBoundary d) {
        int tileSize = d.getTileSize();
        Graphics2D g2 = d.graphics();
        int xPixels = getX() * tileSize;
        int yPixels = getY() * tileSize;
        if (image != null) {
            g2.drawImage(image, xPixels, yPixels, tileSize, tileSize, null);
        } else {
            // Failed to load image. Use a rectangle as a fallback.
            g2.setColor(Color.BLACK);
            g2.drawRect(xPixels, yPixels, tileSize, tileSize);
        }
    }
}
