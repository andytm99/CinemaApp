import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CinemaListView {


    public static Scene draw()
    {
        AplicatieFis.window.setTitle("Cinema List");
        Button Cinema1Button=new Button("Cinema1");
        Button Cinema2Button=new Button("Cinema2");
        Button backButton =new Button("Back");
        backButton.setOnAction(e->{
                AplicatieFis.window.setScene(CustomerOverview.draw());
                AplicatieFis.window.setTitle("Customer Overview");

        });

        Cinema1Button.setOnAction(e ->{
            AplicatieFis.window.setScene(CustomerCinema1View.draw());
            AplicatieFis.window.setTitle("Movies From admin1 Cinema");
        });

        Cinema2Button.setOnAction(e ->{
            AplicatieFis.window.setScene(CustomerCinema2View.draw());
            AplicatieFis.window.setTitle("Movies From admin2 Cinema");
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(Cinema1Button,Cinema2Button,backButton);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        VBox.setMargin(Cinema1Button, new Insets(10, 10, 10, 10));
        VBox.setMargin(Cinema2Button, new Insets(10, 10, 10, 10));
        VBox.setMargin(backButton, new Insets(10, 10, 10, 10));

        Scene scene = new Scene(vBox,400,200);

        return scene;
    }
}
