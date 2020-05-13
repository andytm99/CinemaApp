import javafx.application.Application;
import javafx.stage.Stage;

public class AplicatieFis extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Log In");
        primaryStage.setScene(LoginMenu.draw());
        primaryStage.show();
    }
}
