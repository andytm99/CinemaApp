import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SelectionScreen {

    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 400, h = 250;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Button CustomerButton = new Button("Customer");

        GridPane.setConstraints(CustomerButton,7,7);

        Button AdministratorButton = new Button("Cinema Manager");

        GridPane.setConstraints(AdministratorButton,10,7);

        CustomerButton.setOnAction(e -> {
            AplicatieFis.window.setScene(LoginCustomers.draw());
            AplicatieFis.window.setTitle("Customer Log in");
        });
        AdministratorButton.setOnAction(e -> {
            AplicatieFis.window.setScene(LoginManagers.draw());
            AplicatieFis.window.setTitle("Manager Log in");
        });

        grid.getChildren().addAll(CustomerButton,AdministratorButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }


}
