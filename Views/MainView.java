package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView {
    VBox toDoLists;
    HBox root;

    public MainView(){
        toDoLists = new VBox(0);
        toDoLists.setPadding(new Insets(4,4,4,4));
        toDoLists.setStyle("-fx-background-color: #000000");
        toDoLists.setAlignment(Pos.CENTER);

        root = new HBox(20);
        root.setPadding(new Insets(4,4,4,4));
        root.setStyle("-fx-background-color: #ffffff");
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(toDoLists);
    }

    public void addToDoList(Node toDoList){
        toDoLists.getChildren().add(toDoList);
    }

    public Scene getRoot(){
        return new Scene(root, UIDimensions.stageDim[0], UIDimensions.stageDim[1]);
    }
}
