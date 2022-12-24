package Controller;

import Model.Item;

public class ItemBuilder {
    Item item;

    public ItemBuilder(){
        item = new Item();
    }

    public void setDate(String date){
        item.setDate(date);
    }

    public void setTime(String time){
        item.setTime(time);
    }
    public void setTitle(String title){
        item.setTitle(title);
    }
    public void setDescription(String description){
        item.setDescription(description);
    }
    public void setId(String id){
        item.setId(id);
    }

    public Item getItem(){
        return this.item;
    }
}
