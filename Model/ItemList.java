package Model;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ItemList {
    HashMap<String,Item> complete =  new HashMap<String,Item>();
    HashMap<String,Item> uncompleted = new HashMap<String,Item>();

    public void addItem(String id, Item item){
        uncompleted.put(id, item);
    }
    public boolean completeItem(String id){
        if(uncompleted.containsKey(id)){
            Item item = uncompleted.get(id);
            // Moving item to the complete set.
            complete.put(id, item);
            uncompleted.remove(id);

            return item.toggleCompletion();
        }
        else{
            throw new NoSuchElementException("This item does not exist.");
        }
    }
    public boolean uncompleteItem(String id){
        if (complete.containsKey(id)){
            Item item = complete.get(id);
            // Moving item from complete to uncompleted
            uncompleted.put(id, item);
            complete.remove(id);

            return item.toggleCompletion();
        }
        else{
            throw new NoSuchElementException("This item does not exist.");
        }
    }

    public HashMap<String,Item> getCompleted(){
        return this.complete;
    }

    public HashMap<String,Item> getUncompleted(){
        return this.uncompleted;
    }
}
