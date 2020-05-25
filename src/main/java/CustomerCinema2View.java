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
import sun.security.krb5.internal.Ticket;

import java.io.File;
import java.io.IOException;

public class CustomerCinema2View {
    private static TableView<MovieObject> table;
    private static TableView<TicketObject> tichete;
    private static TextField nameInput, quantityInput;
    private static MovieObject[]  Movies=null;
    private static TicketObject[] Tickets=null;
    private static ObservableList<MovieObject> Mov = FXCollections.observableArrayList();   //Mov e vectorul de filme
    private static ObservableList<TicketObject> Tick = FXCollections.observableArrayList();   //vectorul de tichete
    //Get all of the products from json
    public static ObservableList<MovieObject> getMovieObject(){
        File file = new File("C:\\Users\\Andreas\\Desktop\\proiect\\data\\admin2Movies.json");
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


    public static ObservableList<TicketObject> getTicketObject(){
        File fileT = new File("C:\\Users\\Andreas\\Desktop\\proiect\\data\\CinemaAdmin2Tickets.json");
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            Tickets = objectMapper.readValue(fileT, TicketObject[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (TicketObject x : Tickets) {
            Tick.add(x);
        }

        return Tick;
    }




    public static Scene draw()
    {
        AplicatieFis.window.setTitle("Movie List Cinema1");

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

        //Client name column
        TableColumn<TicketObject, String> nameClientColumn = new TableColumn<>("Client Name");
        nameClientColumn.setMinWidth(150);
        nameClientColumn.setCellValueFactory(new PropertyValueFactory<>("numeClient"));

        //Quantity column
        TableColumn<TicketObject, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(150);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("cantitate"));

        tichete = new TableView<>();
        tichete.setItems(getTicketObject());
        tichete.getColumns().addAll(nameClientColumn,quantityColumn);


        //Movie Name input
        nameInput = new TextField();
        nameInput.setPromptText("Client name");
        nameInput.setMinWidth(100);

        //Quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");


        //Button
        Button backButton=new Button("Back");
        backButton.setOnAction(e -> {
            AplicatieFis.window.setScene(CinemaListView.draw());
            AplicatieFis.window.setTitle("Cinema List");
            table.getItems().clear();
        });
        Button buyButton=new Button("Buy");
        buyButton.setOnAction(e->{
            TicketObject t = new TicketObject(); //m este un obiect de tip TicketObject
            t.setNumeClient(nameInput.getText());
            t.setCantitate(Integer.parseInt(quantityInput.getText()));
            MovieObject filmulet=(MovieObject) table.getSelectionModel().getSelectedItem();
            filmulet.count(Integer.parseInt(quantityInput.getText()));
            t.setFilm(filmulet);
            if(filmulet.getCantitateOcupata()>100)
            {
                Alert.display("EROARE","Nu mai sunt locuri la acest film!");
            }
            else {
                tichete.getItems().add(t);
                File file = new File("C:\\Users\\Andreas\\Desktop\\proiect\\data\\CinemaAdmin2Tickets.json");
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    objectMapper.writeValue(file, tichete.getItems());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            nameInput.clear();
            quantityInput.clear();

        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,quantityInput, buyButton, backButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox);

        Scene scene = new Scene(vBox);
        AplicatieFis.window.setScene(scene);

        return scene;
    }





}
