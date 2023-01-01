package Views;

import Model.Item;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ItemView {
    Item item;

    public ItemView(Item item){
        this.item = item;
    }

    public VBox drawItemView() {
        double[] dimension = UIDimensions.itemViewDim;
        Font[] fonts = UIDimensions.itemFont;

        VBox pieces = new VBox();
        pieces.setMaxSize(dimension[0], dimension[1]);
        pieces.setMinSize(dimension[0], dimension[1]);
        pieces.setAlignment(Pos.BASELINE_LEFT);
        pieces.setStyle("-fx-background-color: #000000;");

        Text title = new Text(item.getTitle());
        title.setFont(fonts[0]);
        title.setStyle("-fx-stroke: #ffffff; -fx-stroke-width: 1.5; -fx-fill: #ffffff");
        title.setTextAlignment(TextAlignment.LEFT);

        Text dateTime = new Text(item.getDate() + "  " + item.getTime());
        dateTime.setFont(fonts[1]);
        dateTime.setStyle("-fx-stroke: #ffffff; -fx-stroke-width: 1.5; -fx-fill: #ffffff");
        dateTime.setTextAlignment(TextAlignment.LEFT);

        pieces.getChildren().add(title);
        pieces.getChildren().add(dateTime);

        return pieces;
    }

}