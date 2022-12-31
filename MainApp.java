import Controller.Controller;
import Exceptions.ListAlreadyExistsException;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws ListAlreadyExistsException {
        Controller control = new Controller(stage);
    }
}
