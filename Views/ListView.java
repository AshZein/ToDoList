package Views;

import Model.Item;
import Model.ItemList;
import Controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ListView {
    ItemList itemList;
    Controller control;
    String title;

    public ListView(ItemList itemList, Controller control){
        this.control = control;
        this.itemList = itemList;
        title = itemList.getTitle();
    }

    public VBox drawListView(){
        VBox out = new VBox();

        // Setting preferred dimensions
        out.setStyle("-fx-background-color: #000000;");
        out.setMaxSize(UIDimensions.itemViewDim[0], UIDimensions.listViewDim[1]);
        out.setMinSize(UIDimensions.itemViewDim[0], UIDimensions.listViewDim[1]);
        out.setPrefSize(UIDimensions.itemViewDim[0], UIDimensions.listViewDim[1]);

        // setting the header element size
        StackPane header = new StackPane();
        header.setMaxSize(UIDimensions.itemViewDim[0], UIDimensions.itemViewDim[1] * 1.5);
        header.setStyle("-fx-background-color: #000000;");
        header.setAlignment(Pos.BASELINE_LEFT);

        // setting the header element text, font and size
        Text headerText = new Text(title);
        headerText.setFont(UIDimensions.listTitleFont);
        headerText.setStyle("-fx-stroke: #ffffff; -fx-stroke-width: 1.5; -fx-fill: #ffffff");
        headerText.setTextAlignment(TextAlignment.LEFT);

        header.getChildren().add(headerText);

        out.getChildren().add(header);
        out.getChildren().add(getListLine());

        for(String itemId: itemList.getCompleted().keySet()){
            Item item = itemList.getItem(itemId);
            ItemView itemView = new ItemView(item);

            out.getChildren().add(itemView.drawItemView(control));
            out.getChildren().add(getListLine());
        }

        for(String itemId: itemList.getIncomplete().keySet()){
            Item item = itemList.getItem(itemId);
            ItemView itemView = new ItemView(item);

            out.getChildren().add(itemView.drawItemView(control));
            out.getChildren().add(getListLine());
        }

        return out;
    }

    private Line getListLine(){
        // creates a line UI element to separate list elements
        Line line = new Line();
        line.setStartX(0.0f);
        line.setStartY(0.0f);
        line.setEndX(UIDimensions.listViewDim[0] * 2);
        line.setEndY(0);
        line.setStyle("-fx-fill: #808080; -fx-stroke: #808080;");

        return line;
    }
}
