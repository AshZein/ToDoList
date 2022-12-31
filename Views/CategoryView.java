package Views;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CategoryView {
    String name;
    Canvas canvas;
    GraphicsContext gc;

    public CategoryView(String name){
        this.name = name;
    }

    public StackPane drawCategoryView(){
        double[] dimension = UIDimensions.categoryDim;

        StackPane stackOut = new StackPane();
        stackOut.setStyle("-fx-background-color: #000000");
        stackOut.setAlignment(Pos.CENTER);

        Text text = new Text(this.name);
        text.setFont(UIDimensions.categoryFont);
        text.setStyle("-fx-stroke: #ffffff; -fx-stroke-width: 1.5; -fx-fill: #ffffff");
        stackOut.getChildren().add(text);

        canvas = new Canvas(dimension[0], dimension[1]);

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.strokeRect(0, 0, dimension[0], dimension[1]);
        stackOut.getChildren().add(canvas);



        return stackOut;
    }
}
