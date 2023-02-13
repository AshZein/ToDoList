package Views;

import Controller.Controller;
import Model.Item;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ItemView {
    Item item;

    // Should replace these with methods from the colour objects later
    String backColour =  "-fx-background-color: #000000;";
    String textColour = "-fx-stroke: #ffffff; -fx-stroke-width: 1.5; -fx-fill: #ffffff";

    public ItemView(Item item){
        this.item = item;
    }

    public HBox drawItemView(Controller control) {
        HBox complete;
        double[] dimension = UIDimensions.itemViewDim;
        Font[] fonts = UIDimensions.itemFont;

        complete = new HBox();
        complete.setMaxSize(dimension[0], dimension[1]);
        complete.setMinSize(dimension[0], dimension[1]);
        complete.setAlignment(Pos.BASELINE_LEFT);
        complete.setStyle(backColour);

        StackPane checkBox = DrawCheckBox(dimension, dimension);

        // Setting overall element size and background colour
        VBox pieces = new VBox();
        pieces.setMaxSize(dimension[0] - (dimension[0]/20), dimension[1] - (dimension[1]/20));
        pieces.setMinSize(dimension[0] - (dimension[0]/20), dimension[1] - (dimension[1]/20));
        pieces.setAlignment(Pos.BASELINE_LEFT);
        pieces.setStyle(backColour);

        // setting title of item element, and associated fonts and colour
        Text title = new Text(item.getTitle());
        title.setFont(fonts[0]);
        title.setStyle(textColour);
        title.setTextAlignment(TextAlignment.LEFT);

        // setting date and time of item element, and associated fonts and colour
        Text dateTime = new Text(item.getDate() + "  " + item.getTime());
        dateTime.setFont(fonts[1]);
        dateTime.setStyle(textColour);
        dateTime.setTextAlignment(TextAlignment.LEFT);

        pieces.getChildren().add(title);
        pieces.getChildren().add(dateTime);

        pieces.setOnMouseClicked(e -> {
            control.setCurrItem(item.getId());
        });

        complete.getChildren().add(checkBox);
        complete.getChildren().add(pieces);
        return complete;
    }

    private StackPane DrawCheckBox(double[] maxSize, double[] minSize){
        StackPane checkBox = new StackPane();

        checkBox.setMaxSize(maxSize[0], maxSize[1]);
        checkBox.setMinSize(minSize[0], minSize[1]);

        checkBox.setStyle(backColour);

        Canvas square = new Canvas(maxSize[0], minSize[0]);
        GraphicsContext gc = square.getGraphicsContext2D();
        gc.setStroke(Color.WHITE);
        gc.strokeRect(0,0, maxSize[0]/20, maxSize[0]/20);

        checkBox.getChildren().add(square);

        return checkBox;
    }

}