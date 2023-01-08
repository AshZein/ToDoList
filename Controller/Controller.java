package Controller;

import Exceptions.ListAlreadyExistsException;
import Model.Item;
import Model.ItemList;
import Model.ToDoLists;
import Views.CategoryView;
import Views.ListView;
import Views.MainView;
import Views.UIDimensions;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Controller {
    MainView mView;
    ToDoLists toDoLists;
    ItemList itemList;
    Item item;
    Stage stage;
    int tempIdGen = 0;

    Scene scene;

    public Controller(Stage stage) throws ListAlreadyExistsException {
        toDoLists = new ToDoLists();
        createBaseLists();

        this.stage = stage;
        mView = new MainView(this);

        initializeMainViewToDoLists();

        scene = mView.getRoot();

        this.stage.setHeight(UIDimensions.stageDim[1]);
        this.stage.setWidth(UIDimensions.stageDim[0]);

        this.stage.setScene(scene);
        this.stage.show();
    }
    /*
     * need to setCurrItemList before using getIncomplete, getComplete and addItem
     */
    public void setCurrItemList(String name){ itemList = toDoLists.getItemList(name); }

    public void setCurrItem(String id){ item = itemList.getItem(id);} // TODO need to make this switch to a more detailed view if needed, maybe

    /*
     * add an item to the currently selected ItemList
     */
    public String addItem(HashMap<String, String> parameters){
        ItemBuilder iBuild = new ItemBuilder();

        iBuild.setDate(parameters.get("date"));
        iBuild.setTime(parameters.get("time"));
        iBuild.setDescription(parameters.get("description"));
        iBuild.setTitle(parameters.get("title"));

        String id = generateId();
        iBuild.setId(id);

        // adding item to the ItemList
        itemList.addItem(iBuild.getItem());

        return id;
    }
    //TODO This is a temporary id generator
    private String generateId(){
        Integer out = new Integer(tempIdGen);
        tempIdGen++;
        return out.toString();
    }

    public HashMap<String, Item> getIncomplete(){ return itemList.getIncomplete(); }

    public HashMap<String,Item> getComplete(){ return itemList.getCompleted(); }

    /*
     * creates the two base ToDoLists complete and incomplete
     */
    private void createBaseLists() {
        try {
            toDoLists.createList("Complete");
            toDoLists.createList("Incomplete");

            // For TESTING
            itemList = toDoLists.getItemList("Complete");
            for(int i = 0; i < 10; i++) {
                HashMap<String, String> temp = new HashMap<>();
                temp.put("title", "TESTTTT" + generateId());
                addItem(temp);
            }

        }catch (ListAlreadyExistsException e){
            System.out.println("ListAlreadyExists exception caught.");
        }
    }

    public ListView getListView(){
        ListView lView = new ListView(itemList, this);
        return lView;
    }

    private void initializeMainViewToDoLists(){
        String[] names = toDoLists.getToDoListNames();

        for (String name: names){
            CategoryView temp = new CategoryView(name);
            mView.addToDoList(temp.drawCategoryView(this));
        }
    }
}
