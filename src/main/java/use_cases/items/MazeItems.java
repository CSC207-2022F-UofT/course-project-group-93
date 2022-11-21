package use_cases.items;

import entities.items.ICollisionRequestModel;
import entities.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of items within a maze with "collision checking" functionality.
 */
public class MazeItems {
    /**
     * The internal list of items.
     */
    private final List<Item> items;

    /**
     * Construct a new MazeItems class with no items.
     */
    public MazeItems() {
        items = new ArrayList<>();
    }

    /**
     * Check whether the player collides with any item.
     */
    public boolean anyItemCollision(ICollisionRequestModel request) {
        for (Item item : items) {
            if (item.itemCollision(request))
                return true;
        }
        return false;
    }

    /**
     * Add an item.
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     * Get the item at the specified position.
     */
    public Item get(int x, int y) {
        for (Item item : items) {
            if (item.itemExists(x, y)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Delete the item at the specified position.
     */
    public void delete(int x, int y) {
        Item item = get(x, y);
        if (item != null)
            items.remove(item);
    }
}
