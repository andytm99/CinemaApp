import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.paint.Color;


public class SelectionScreen {

    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 400, h = 250;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        //grid.setAlignment(Pos.CENTER);

        Button CustomerButton = new Button("Customer");
        //CustomerButton.setEffect(new DropShadow());
       // CustomerButton.setStyle("-fx-font-size: 15pt;");
        GridPane.setConstraints(CustomerButton,7,7);

        Button AdministratorButton = new Button("Cinema Manager");
        // AdministratorButton.setEffect(new DropShadow());
        //AdministratorButton.setStyle("-fx-font-size: 15pt;");
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
