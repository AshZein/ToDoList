package Model;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ItemList {
    HashMap<String,Item> complete =  new HashMap<String,Item>();
    HashMap<String,Item> incomplete = new HashMap<String,Item>();
    String title;
    int numItems;

    public ItemList(String title){
        this.title = title;
        numItems = 0;
    }

    public String getTitle(){ return this.title; }

    public void addItem(Item item){
        incomplete.put(item.getId(), item);
        numItems++;
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
    public boolean incompleteItem(String id){
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

    public HashMap<String,Item> getIncomplete(){
        return this.incomplete;
    }
}
