import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AplicatieFis extends Application  {

    protected static Stage window;
    /*public static void copy()
    {
         Path CustoPATH = Paths.get(System.getProperty("user.dir").toString()+"\\data\\Customers");
        if (!Files.exists(CustoPATH)) {
            try {
                FileUtils.copyURLToFile(LoginCustomers.class.getClassLoader().getResource("Customers.json"), CustoPATH.toFile());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }*/
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
