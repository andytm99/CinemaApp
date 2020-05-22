import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminOverview {

    Stage window=new Stage();
    public static Scene draw()
    {
        int w = 400, h = 250;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Button MovieListButton = new Button("Movie List");

        GridPane.setConstraints(MovieListButton,7,7);

        Button TicketsButton = new Button("Tickets bought");

        GridPane.setConstraints(TicketsButton,10,7);

        MovieListButton.setOnAction(e -> {
            AplicatieFis.window.setScene(MovieListView.draw());
            AplicatieFis.window.setTitle("List of Movies");
        });



        grid.getChildren().addAll(MovieListButton,TicketsButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }


}
