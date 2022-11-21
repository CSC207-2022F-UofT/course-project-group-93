package entities.hazards;

import entities.default_game.Entity;
import entities.default_game.IDrawOutputBoundary;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * The abstract class which all enemies inherit from.
 */
public abstract class Enemy extends Entity {
    /**
     * The starting x position for the enemy.
     */
    private int startX;
    /**
     * The starting y position for the enemy.
     */
    private int startY;
    /**
     * The image which the enemy should be drawn with.
     */
    private BufferedImage image;

    /**
     * Create a new enemy.
     *
     * @param startX The starting X position
     * @param startY The starting Y position
     */
    public Enemy(int startX, int startY) {
        setStartX(startX);
        setStartY(startY);
        setImageByName("spikes");
    }

    /**
     * Set te image used to draw the enemy.
     *
     * @param name The file name of the image not including the .png extension.
     *             Currently, this should be either "spikes" or "moving-enemy".
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
     * Set the image used to draw the enemy.
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Draw an enemy.
     */
    public void draw(IDrawOutputBoundary d) {
        Graphics2D g2 = d.graphics();
        int tileSize = d.getTileSize();
        int xPixels = getX() * tileSize;
        int yPixels = getY() * tileSize;
        if (image != null) {
            g2.drawImage(image, xPixels, yPixels, tileSize, tileSize, null);
        } else {
            // Failed to load image. Use a rectangle as a fallback.
            g2.setColor(Color.RED);
            g2.drawRect(xPixels, yPixels, tileSize, tileSize);
        }
    }


    /**
     * Reset the enemy to its initial state.
     */
    public abstract void reset();

    /**
     * Update the enemy. Called at a fixed interval (e.g. every 0.5 seconds).
     */
    public abstract void update(IEnemyRequestModel request);

    /**
     * Get the current x position of the enemy.
     */
    public abstract int getX();

    /**
     * Get the current y position of the enemy.
     */
    public abstract int getY();

    /**
     * Get the starting x position of the enemy.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Get the starting y position of the enemy.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Set the starting x position o the enemy.
     */
    public void setStartX(int x) {
        startX = x;
    }

    /**
     * Set the starting y position of the enemy.
     */
    public void setStartY(int y) {
        startY = y;
    }

    /**
     * Check whether this enemy kills the player.
     */
    public boolean killsPlayer(IHazardRequestModel request) {
        return request.getPlayerX() == getX() && request.getPlayerY() == getY();
    }


}
