import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CustomerOverview {

    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 450, h = 250;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Button CinemaListButton = new Button("Cinema List");

        GridPane.setConstraints(CinemaListButton,7,7);

        Button TicketsButton = new Button("Tickets bought");

        GridPane.setConstraints(TicketsButton,11,7);

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton,9,10);

        backButton.setOnAction(e ->{
            AplicatieFis.window.setScene(LoginCustomers.draw());
            AplicatieFis.window.setTitle("Customer Log in");
        });

        CinemaListButton.setOnAction(e -> {
            AplicatieFis.window.setScene(CinemaListView.draw());
            AplicatieFis.window.setTitle("Cinema List");
        });



        grid.getChildren().addAll(CinemaListButton,TicketsButton,backButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }


}
