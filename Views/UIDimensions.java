package Views;

import javafx.scene.text.Font;

public class UIDimensions {
    // all dimensions are {x, y}
    static double[] categoryDim = new double[] {316, 100};
    static Font categoryFont = new Font(35);
    static Font[] itemFont = new Font[] {new Font(18), new Font(12)};  // {title font, dateTime font}
    static Font listTitleFont = new Font(40);
    public static double[] stageDim = new double[] {950 + 25, 750}; //added 25 for the scroll bar temporarily
    static double[] itemViewDim = new double[]{634, 100};
    static double[] mainViewDim = new double[]{950, 750};
    static double[] listViewDim = new double[]{634, 750};
}
