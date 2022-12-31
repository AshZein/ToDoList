package Views;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class CategoryView {
    String name;


    public CategoryView(String name){
        this.name = name;
    }

    public StackPane drawCategoryView(){
        double[] dimension = UIDimensions.categoryDim;

        StackPane stackOut = new StackPane();
        stackOut.setPrefWidth(dimension[0]);
        stackOut.setPrefHeight(dimension[1]);
        stackOut.setStyle("-fx-background-color: #000000;");
        stackOut.setAlignment(Pos.CENTER);

        Text text = new Text(this.name);
        text.setFont(UIDimensions.categoryFont);
        text.setStyle("-fx-stroke: #ffffff; -fx-stroke-width: 1.5; -fx-fill: #ffffff");
        stackOut.getChildren().add(text);

        return stackOut;
    }
}
