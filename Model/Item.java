package Model;

public class Item {
    String date;
    String time;
    String title;
    String description;
    boolean complete;

    public Item(){
        date = "";
        time = "";
        title = "";
        description = "";
        complete = false;
    }
    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public boolean toggleCompletion(){
        this.complete = !this.complete;
        return this.complete;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public boolean getCompletion(){
        return complete;
    }
}
