import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class MovieListView {
    static TableView<MovieObject> table;

    public static Scene draw()
    {
        AplicatieFis.window.setTitle("Movie List");

        //Movie name column
        TableColumn<MovieObject, String> nameColumn = new TableColumn<>("Movie Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("movieName"));

        //Director name column
        TableColumn<MovieObject, String> directorColumn = new TableColumn<>("Directed by");
        directorColumn.setMinWidth(100);
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("directorName"));

        //Description column
        TableColumn<MovieObject, String> descriptionColumn = new TableColumn<>("Short Description");
        descriptionColumn.setMinWidth(150);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionShort"));

        //Genre column
        TableColumn<MovieObject, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setMinWidth(30);
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        //Minutes column
        TableColumn<MovieObject, String> minutesColumn = new TableColumn<>("Minutes");
        minutesColumn.setMinWidth(15);
        minutesColumn.setCellValueFactory(new PropertyValueFactory<>("minutes"));

        table = new TableView<>();
        //table.setItems(getMovieObject());
        table.getColumns().addAll(nameColumn, directorColumn, descriptionColumn, genreColumn, minutesColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        AplicatieFis.window.setScene(scene);
        return scene;
    }

}
