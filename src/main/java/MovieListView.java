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
import java.io.IOException;

public class MovieListView {
    private static TableView<MovieObject> table;
    private static TextField nameInput, directorInput, descriptionInput,genreInput,minutesInput;
    private static MovieObject[]  Movies=null;
    private static ObservableList<MovieObject> Mov = FXCollections.observableArrayList();   //Mov e vectorul de filme
    //Get all of the products from json
    public static ObservableList<MovieObject> getMovieObject(){
        File file = new File("data/Movies.json");
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            Movies = objectMapper.readValue(file, MovieObject[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (MovieObject x : Movies) {
            Mov.add(x);
            }

        return Mov;
    }




    public static Scene draw()
    {
        AplicatieFis.window.setTitle("Movie List");

        //Movie name column
        TableColumn<MovieObject, String> nameColumn = new TableColumn<>("Movie Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("movieName"));

        //Director name column
        TableColumn<MovieObject, String> directorColumn = new TableColumn<>("Directed by");
        directorColumn.setMinWidth(100);
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("directorName"));

        //Description column
        TableColumn<MovieObject, String> descriptionColumn = new TableColumn<>("Short Description");
        descriptionColumn.setMinWidth(400);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionShort"));

        //Genre column
        TableColumn<MovieObject, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setMinWidth(30);
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        //Minutes column
        TableColumn<MovieObject, String> minutesColumn = new TableColumn<>("Minutes");
        minutesColumn.setMinWidth(10);
        minutesColumn.setCellValueFactory(new PropertyValueFactory<>("minutes"));

        table = new TableView<>();
        table.setItems(getMovieObject());
        table.getColumns().addAll(nameColumn, directorColumn, descriptionColumn, genreColumn, minutesColumn);

        //pt adaugare VV

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Movie name");
        nameInput.setMinWidth(100);

        //Director input
        directorInput = new TextField();
        directorInput.setPromptText("Directed by");

        //Description input
        descriptionInput = new TextField();
        descriptionInput.setPromptText("Description");

        //Genre input
        genreInput = new TextField();
        genreInput.setPromptText("Genre");

        //Minutes input
        minutesInput = new TextField();
        minutesInput.setPromptText("Minutes");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        Button backButton=new Button("Back");
        backButton.setOnAction(e -> {
            AplicatieFis.window.setScene(AdminOverview.draw());
            AplicatieFis.window.setTitle("Admin Overview");
            table.getItems().clear();
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, directorInput, descriptionInput, genreInput, minutesInput, addButton, deleteButton,backButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox);

        Scene scene = new Scene(vBox);
        AplicatieFis.window.setScene(scene);

        return scene;
    }

    //Add button clicked
    public static void addButtonClicked()  {
        MovieObject m = new MovieObject(); //m este un obiect de tip MovieObject
        m.setMovieName(nameInput.getText());
        m.setDirectorName(directorInput.getText());
        m.setDescriptionShort(descriptionInput.getText());
        m.setGenre(genreInput.getText());
        m.setMinutes(Integer.parseInt(minutesInput.getText()));

        table.getItems().add(m);
        File file = new File("data/Movies.json");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
        objectMapper.writeValue(file, table.getItems());
        } catch (IOException e) {
            e.printStackTrace();
        }
        nameInput.clear();
        directorInput.clear();
        descriptionInput.clear();
        genreInput.clear();
        minutesInput.clear();
    }

    //Delete button clicked
    public static void deleteButtonClicked(){
        ObservableList<MovieObject> movieSelected, allMovies;
        allMovies = table.getItems();
        movieSelected = table.getSelectionModel().getSelectedItems();
        movieSelected.forEach(allMovies::remove);
        File file = new File("data/Movies.json");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            objectMapper.writeValue(file, table.getItems());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
