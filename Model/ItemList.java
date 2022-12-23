package Model;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ItemList {
    HashMap<String,Item> complete =  new HashMap<String,Item>();
    HashMap<String,Item> incomplete = new HashMap<String,Item>();

    public void addItem(String id, Item item){
        incomplete.put(id, item);
    }
    public boolean completeItem(String id){
        if(incomplete.containsKey(id)){
            Item item = incomplete.get(id);
            // Moving item to the complete set.
            complete.put(id, item);
            incomplete.remove(id);

            return item.toggleCompletion();
        }
        else{
            throw new NoSuchElementException("This item does not exist.");
        }
    }
    public boolean uncompleteItem(String id){
        if (complete.containsKey(id)){
            Item item = complete.get(id);
            // Moving item from complete to incomplete
            incomplete.put(id, item);
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

    public HashMap<String,Item> getincomplete(){
        return this.incomplete;
    }
}
