import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Cinema2TicketsView {
    private static TableView<MovieObject> table;
    public static Scene draw()
    {
        AplicatieFis.window.setTitle("Tickets bought");

        //Movie name column
        TableColumn<MovieObject, String> nameColumn = new TableColumn<>("Movie Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("movieName"));

        //Button
        Button backButton=new Button("Back");
        backButton.setOnAction(e -> {
            AplicatieFis.window.setScene(AdminOverview2.draw());
            AplicatieFis.window.setTitle("Cinema List");
            table.getItems().clear();
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(backButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox);

        Scene scene = new Scene(vBox);
        AplicatieFis.window.setScene(scene);

        return scene;
    }
}
