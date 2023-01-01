package Tests;

import Controller.ItemBuilder;
import Model.Item;
import Model.ItemList;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ItemListTests {

    @Test
    public void basicItemListTest(){
        ItemList iList = new ItemList("test1");

        ItemBuilder iBuild = new ItemBuilder();
        iBuild.setDate("2022/12/23");
        iBuild.setTitle("Test Title");
        iBuild.setId("abc123");
        iBuild.setDescription("This item is for a test");

        Item item = iBuild.getItem();

        iList.addItem(item);

        HashMap<String, Item> incomplete = iList.getIncomplete();

        assertTrue(incomplete.containsKey("abc123"));
        assertEquals(item, incomplete.get("abc123"));

        iList.completeItem("abc123");

        HashMap<String, Item> complete = iList.getCompleted();

        assertTrue(complete.containsKey("abc123"));
        assertEquals(item, complete.get("abc123"));

        assertFalse(incomplete.containsKey("abc123"));

        iList.incompleteItem("abc123");

        assertTrue(incomplete.containsKey("abc123"));
        assertEquals(item, incomplete.get("abc123"));
    }

    @Test
    public void basicTwoItemListTest(){
        ItemList iList = new ItemList("test2");

        ItemBuilder iBuild = new ItemBuilder();
        iBuild.setDate("2022/12/23");
        iBuild.setTitle("Test Title");
        iBuild.setId("abc123");
        iBuild.setDescription("This item is for a test");

        Item item1 = iBuild.getItem();

        iBuild = new ItemBuilder();
        iBuild.setDate("1111/11/11");
        iBuild.setTitle("Test Title2");
        iBuild.setId("def456");
        iBuild.setDescription("This item is for a test");

        Item item2 = iBuild.getItem();

        iList.addItem(item1);
        iList.addItem(item2);

        HashMap<String, Item> incomplete = iList.getIncomplete();

        assertTrue(incomplete.containsKey("abc123"));
        assertEquals(item1, incomplete.get("abc123"));

        assertTrue(incomplete.containsKey("def456"));
        assertEquals(item2, incomplete.get("def456"));

        iList.completeItem("abc123");

        HashMap<String, Item> complete = iList.getCompleted();

        assertTrue(complete.containsKey("abc123"));
        assertEquals(item1, complete.get("abc123"));

        assertFalse(incomplete.containsKey("abc123"));

        assertFalse(complete.containsKey("def456"));
        assertTrue(incomplete.containsKey("def456"));

        iList.incompleteItem("abc123");

        assertTrue(incomplete.containsKey("abc123"));
        assertEquals(item1, incomplete.get("abc123"));
    }

    @Test
    public void incompleteItemExceptionTest(){
        ItemList iList = new ItemList("test3");
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            iList.incompleteItem("abc123");
        });
        String expectedMessage = "This item does not exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void completeItemExceptionTest(){
        ItemList iList = new ItemList("test4");
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            iList.completeItem("abc123");
        });
        String expectedMessage = "This item does not exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
