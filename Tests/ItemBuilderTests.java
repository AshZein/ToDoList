package Tests;

import Controller.ItemBuilder;
import Model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemBuilderTests {

    @Test
    public void basicItemBuildTest(){
        ItemBuilder iBuild = new ItemBuilder();

        iBuild.setDate("2022/12/23");
        iBuild.setTitle("Test Title");
        iBuild.setId("abc123");
        iBuild.setDescription("This item is for a test");

        Item item = iBuild.getItem();

        assertEquals("This item is for a test", item.getDescription());
        assertEquals("Test Title", item.getTitle());
        assertEquals("2022/12/23", item.getDate());

        assertTrue(item.toggleCompletion());
    }

    @Test
    public void missingDateItemBuildTest(){
        ItemBuilder iBuild = new ItemBuilder();

        iBuild.setTitle("Test Title");
        iBuild.setId("abc123");
        iBuild.setDescription("This item is for a test");

        Item item = iBuild.getItem();

        assertEquals("This item is for a test", item.getDescription());
        assertEquals("Test Title", item.getTitle());
        assertEquals("", item.getDate());

        assertTrue(item.toggleCompletion());
    }

    @Test
    public void missTitleItemBuildTest(){
        ItemBuilder iBuild = new ItemBuilder();

        iBuild.setDate("2022/12/23");
        iBuild.setId("abc123");
        iBuild.setDescription("This item is for a test");

        Item item = iBuild.getItem();

        assertEquals("This item is for a test", item.getDescription());
        assertEquals("", item.getTitle());
        assertEquals("2022/12/23", item.getDate());

        assertTrue(item.toggleCompletion());
    }

    @Test
    public void missDescItemBuildTest(){
        ItemBuilder iBuild = new ItemBuilder();

        iBuild.setDate("2022/12/23");
        iBuild.setTitle("Test Title");
        iBuild.setId("abc123");

        Item item = iBuild.getItem();

        assertEquals("", item.getDescription());
        assertEquals("Test Title", item.getTitle());
        assertEquals("2022/12/23", item.getDate());

        assertTrue(item.toggleCompletion());
    }

    @Test
    public void noToggleCompleteItemBuildTest(){
        ItemBuilder iBuild = new ItemBuilder();

        iBuild.setDate("2022/12/23");
        iBuild.setTitle("Test Title");
        iBuild.setId("abc123");
        iBuild.setDescription("This item is for a test");

        Item item = iBuild.getItem();

        assertEquals("This item is for a test", item.getDescription());
        assertEquals("Test Title", item.getTitle());
        assertEquals("2022/12/23", item.getDate());

        assertFalse(item.getCompletion());
    }
}
