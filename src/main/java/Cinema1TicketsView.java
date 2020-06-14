import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;

public class Cinema1TicketsView {
    private static TableView<TicketObject> tichete;
    private static TicketObject[] Tickets=null;
    private static ObservableList<TicketObject> Tick = FXCollections.observableArrayList();

    public static ObservableList<TicketObject> getTicketObject(){
        File fileT = new File(System.getProperty("user.dir")+"\\CinemaAdmin1Tickets.json");
        ObjectMapper objectMapper=new ObjectMapper();
//mesaj
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

    public static void deleteButtonClicked(){
        ObservableList<TicketObject> movieSelected, allMovies;
        allMovies = tichete.getItems();
        movieSelected = tichete.getSelectionModel().getSelectedItems();
        movieSelected.forEach(allMovies::remove);
        File file = new File(System.getProperty("user.dir")+"\\CinemaAdmin1Tickets.json");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            objectMapper.writeValue(file, tichete.getItems());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Scene draw()
    {
        AplicatieFis.window.setTitle("Tickets bought");

        TableColumn<TicketObject, String> customerNameColumn = new TableColumn<>("Customer Name");
        customerNameColumn.setMinWidth(150);
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("numeClient"));

        //Movie name column
        TableColumn<TicketObject, String> nameColumn = new TableColumn<>("Movie Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("numeFilm"));

        //Quanity column
        TableColumn<TicketObject, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(10);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("cantitate"));

        tichete = new TableView<>();
        tichete.setItems(getTicketObject());
        tichete.getColumns().addAll(customerNameColumn,nameColumn, quantityColumn);

        //Button
        Button deleteButton=new Button("Delete Orders");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        //Button
        Button backButton=new Button("Back");
        backButton.setOnAction(e -> {
            AplicatieFis.window.setScene(AdminOverview.draw());
            AplicatieFis.window.setTitle("Admin Overview");
            tichete.getItems().clear();
        });


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(deleteButton, backButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tichete,hBox);

        Scene scene = new Scene(vBox);
        AplicatieFis.window.setScene(scene);

        return scene;
    }
}
