package Model;

import Exceptions.ListAlreadyExistsException;

import java.util.HashMap;

public class ToDoLists {
    HashMap<String, ItemList> lists = new HashMap<>();

    /*
     * Creates a new ItemList to add to the list of ItemLists. Throws an exception if there is already a list using the
     * name given.
     */
    public void createList(String name) throws ListAlreadyExistsException {
        if (lists.containsKey(name)){
            throw new ListAlreadyExistsException("This List already exists");
        }
        else{
            lists.put(name, new ItemList());
        }
    }

    public ItemList getItemList(String name){
        return lists.get(name);
    }
}
