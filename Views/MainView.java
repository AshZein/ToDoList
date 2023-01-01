package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;

public class MainView {
    VBox toDoLists;
    HBox root;

    public MainView(){
        toDoLists = new VBox(0);
        toDoLists.setPadding(new Insets(0,0,0,0));
        toDoLists.setStyle("-fx-background-color: #000000;");
        toDoLists.setAlignment(Pos.TOP_CENTER);

        double[] catDimension = UIDimensions.categoryDim;
        toDoLists.setPrefWidth(catDimension[0]);
        toDoLists.setPrefHeight(UIDimensions.stageDim[1]);

        StackPane listHeader = new StackPane();
        listHeader.setPadding(new Insets(0,0,0,5));
        listHeader.setPrefWidth(catDimension[0]);
        listHeader.setPrefHeight(catDimension[1]);
        listHeader.setStyle("-fx-background-color: #000000;");
        listHeader.setAlignment(Pos.BOTTOM_LEFT);

        Text text = new Text("Lists");
        text.setStyle("-fx-stroke: #ffffff; -fx-stroke-width: 1.5; -fx-fill: #ffffff; -fx-font-size: 40");

        listHeader.getChildren().add(text);

        toDoLists.getChildren().add(listHeader);
        toDoLists.getChildren().add(getListLine());

        root = new HBox(20);
        root.setPadding(new Insets(0,0,0,0));
        root.setStyle("-fx-background-color: #ffffff");
        root.setAlignment(Pos.BOTTOM_LEFT);

        ScrollPane toDoScroll = new ScrollPane(toDoLists);
        toDoScroll.setFitToWidth(true);
        toDoScroll.setFitToHeight(true);
        toDoScroll.hbarPolicyProperty().set(ScrollPane.ScrollBarPolicy.NEVER);
        toDoScroll.vbarPolicyProperty().set(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.getChildren().add(toDoScroll);
    }

    public void addToDoList(Node toDoList){
        toDoLists.getChildren().add(toDoList);
        toDoLists.getChildren().add(getListLine());
    }

    private Line getListLine(){
        Line line = new Line();
        line.setStartX(0.0f);
        line.setStartY(0.0f);
        line.setEndX(UIDimensions.categoryDim[0]);
        line.setEndY(0);
        line.setStyle("-fx-fill: #808080; -fx-stroke: #808080;");

        return line;
    }

    public Scene getRoot(){
        return new Scene(root, UIDimensions.stageDim[0], UIDimensions.stageDim[1]);
    }
}
