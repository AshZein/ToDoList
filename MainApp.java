import Views.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage){
        MainView mView = new MainView(stage);
    }
}
