import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AplicatieFis extends Application  {
    public static Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window=primaryStage;
       /* File file = new File("data/Customers.json");
        ObjectMapper objectMapper=new ObjectMapper();
        JsonCustomer[] Custom=null;
        try {
            Custom = objectMapper.readValue(file, JsonCustomer[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(JsonCustomer x: Custom) {
            System.out.println(x);
        }*/
        primaryStage.setTitle("Selection Screen");
        primaryStage.setScene(SelectionScreen.draw());
        primaryStage.show();
    }

}
