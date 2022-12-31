package Controller;

import Model.Item;
import Model.ItemList;
import Model.ToDoLists;
import Views.MainView;
import javafx.stage.Stage;

import java.util.HashMap;

public class Controller {
    MainView mView;
    ToDoLists toDoLists;
    ItemList itemList;
    Stage stage;

    public Controller(Stage stage){
        toDoLists = new ToDoLists();
        this.stage = stage;
        mView = new MainView();
    }

    public String addItem(HashMap<String, String> parameters){
        ItemBuilder iBuild = new ItemBuilder();

        iBuild.setDate(parameters.get("date"));
        iBuild.setTime(parameters.get("time"));
        iBuild.setDescription(parameters.get("description"));
        iBuild.setTitle(parameters.get("title"));

        String id = generateId();
        iBuild.setId(id);

        ItemList itemList = toDoLists.getItemList(parameters.get("name"));

        // adding item to the ItemList
        itemList.addItem(iBuild.getItem());

        return id;
    }

    private String generateId(){
        throw new UnsupportedOperationException("Not complete yet");
    }

    public void setCurrItemList(String name){ itemList = toDoLists.getItemList(name); }

    public HashMap<String, Item> getIncomplete(){ return itemList.getIncomplete(); }

    public HashMap<String,Item> getComplete(){ return itemList.getCompleted(); }

    /*
     * creates the two base ToDoLists complete and incomplete
     */
    private void createBaseLists() {
        try {
            toDoLists.createList("Complete");
            toDoLists.createList("Incomplete");
        }catch (ListAlreadyExistsException e){
            System.out.println("ListAlreadyExists exception caught.");
        }
    }

    private void initializeMainViewToDoLists(){
        String[] names = toDoLists.getToDoListNames();

        for (String name: names){
            CategoryView temp = new CategoryView(name);
            mView.addToDoList(temp.drawCategoryView());
        }
    }
}
