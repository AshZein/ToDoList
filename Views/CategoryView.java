package Views;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CategoryView {
    String name;
    Canvas canvas;
    GraphicsContext gc;

    public CategoryView(String name){
        this.name = name;
    }

    public Canvas drawCategoryView(){
        double[] dimension = UIDimensions.categoryDim;
        canvas = new Canvas(dimension[0], dimension[1]);
        canvas.setStyle("-fx-background-color: #000000");

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillText(name, dimension[0]/2, dimension[1]/2);

        return canvas;
    }
}
