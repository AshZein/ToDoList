package Controller;

import Model.Item;
import Model.ItemList;

import java.util.HashMap;

public class Controller {
    ItemList itemList;

    public Controller(){
        itemList = new ItemList();
    }

    public String addItem(HashMap<String, String> parameters){
        ItemBuilder iBuild = new ItemBuilder();

        iBuild.setDate(parameters.get("date"));
        iBuild.setTime(parameters.get("time"));
        iBuild.setDescription(parameters.get("description"));
        iBuild.setTitle(parameters.get("title"));

        String id = generateId();
        iBuild.setId(id);

        // adding item to the ItemList
        itemList.addItem(id, iBuild.getItem());

        return id;
    }

    private String generateId(){
        throw new UnsupportedOperationException("Not complete yet");
    }

    public HashMap<String, Item> getIncomplete(){
        return itemList.getincompleted();
    }

    public HashMap<String,Item> getComplet(){
        return itemList.getCompleted();
    }
}
