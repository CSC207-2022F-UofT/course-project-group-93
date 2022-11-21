package items;

import entities.items.ICollisionRequestModel;
import entities.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.items.MazeItems;

/** Test the MazeItems class */
public class MazeItemsTest {
    /** Test anyItemCollision without any items. */
    @Test
    public void AnyItemCollisionNoItems() {
        MazeItems mazeItems = new MazeItems();
        ICollisionRequestModel player = new TestCollisionRequestModel(0, 0);
        Assertions.assertFalse(mazeItems.anyItemCollision(player));
    }

    /** Test anyItemCollision with a bunch of items. */
    @Test
    public void AnyItemCollisionMultipleItems() {
        MazeItems mazeItems = new MazeItems();
        mazeItems.add(new Item(5, 5));
        mazeItems.add(new Item(600, 250));
        mazeItems.add(new Item(1000, 800));
        ICollisionRequestModel player1 = new TestCollisionRequestModel(100, 100);
        Assertions.assertFalse(mazeItems.anyItemCollision(player1));  // no collision
        ICollisionRequestModel player2 = new TestCollisionRequestModel(5, 5);
        Assertions.assertTrue(mazeItems.anyItemCollision(player2)); // collision with 1st item
        ICollisionRequestModel player3 = new TestCollisionRequestModel(600, 250);
        Assertions.assertTrue(mazeItems.anyItemCollision(player3)); // collision with 2nd item
        ICollisionRequestModel player4 = new TestCollisionRequestModel(1000, 800);
        Assertions.assertTrue(mazeItems.anyItemCollision(player4)); // collision with 3rd item
    }

    /**
     * Test get without any items.
     */
    @Test
    public void GetNoItems() {
        MazeItems mazeItems = new MazeItems();
        Assertions.assertNull(mazeItems.get(3, 5));
    }

    /**
     * Test get with several items.
     */
    @Test
    public void GetMultipleItems() {
        MazeItems mazeItems = new MazeItems();
        Item item1 = new Item(3, 5);
        Item item2 = new Item(88, 2);
        Assertions.assertNull(mazeItems.get(3, 5));
        mazeItems.add(item1);
        mazeItems.add(item2);
        Assertions.assertEquals(mazeItems.get(3, 5), item1);
        Assertions.assertEquals(mazeItems.get(88, 2), item2);
    }

    /**
     * Test removing items.
     */
    @Test
    public void Remove() {
        MazeItems mazeItems = new MazeItems();
        Item item1 = new Item(4, 3);
        Item item2 = new Item(10, 10);
        mazeItems.add(item1);
        mazeItems.add(item2);
        Assertions.assertEquals(mazeItems.get(4, 3), item1);
        mazeItems.delete(4, 3);
        Assertions.assertNull(mazeItems.get(4, 3));

        Assertions.assertEquals(mazeItems.get(10, 10), item2);
        mazeItems.delete(10, 10);
        Assertions.assertNull(mazeItems.get(10, 10));

    }
}
