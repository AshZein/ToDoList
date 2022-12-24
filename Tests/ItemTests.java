package Tests;

import Model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemTests {

    @Test
    public void basicItemTest(){
        Item item = new Item();

        item.setDate("2022/12/23");
        item.setTitle("Test Title");
        item.setId("abc123");
        item.setDescription("This item is for a test");

        assertEquals("This item is for a test", item.getDescription());
        assertEquals("Test Title", item.getTitle());
        assertEquals("2022/12/23", item.getDate());

        assertTrue(item.toggleCompletion());
    }
}
