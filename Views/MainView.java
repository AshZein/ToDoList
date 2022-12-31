package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class MainView {
    VBox toDoLists;
    HBox root;

    public MainView(){
        toDoLists = new VBox(0);
        toDoLists.setPadding(new Insets(0,0,0,0));
        toDoLists.setStyle("-fx-background-color: #000000;");
        toDoLists.setAlignment(Pos.CENTER);

        double[] dimension = UIDimensions.categoryDim;
        toDoLists.setPrefWidth(dimension[0]);

        root = new HBox(20);
        root.setPadding(new Insets(0,0,0,0));
        root.setStyle("-fx-background-color: #ffffff");
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(toDoLists);
    }

    public void addToDoList(Node toDoList){

        Line line = new Line();
        line.setStartX(0.0f);
        line.setStartY(0.0f);
        line.setEndX(UIDimensions.categoryDim[0]);
        line.setEndY(0);
        line.setStyle("-fx-fill: #808080; -fx-stroke: #808080;");

        toDoLists.getChildren().add(line);
        toDoLists.getChildren().add(toDoList);
    }

    public Scene getRoot(){
        return new Scene(root, UIDimensions.stageDim[0], UIDimensions.stageDim[1]);
    }
}
