import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginCustomers {
    private static int ok=0;
    private static String numeCustomer;
     static JsonCustomer[]  Custom=null;
     //private static final Path CustoPATH = Paths.get(System.getProperty("user.dir").toString()+"\\data\\Customers");

    public static Scene draw()
    {
        int w = 350, h = 250;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);

        TextField nameInput = new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput,1,0);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);

        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        File file = new File(System.getProperty("user.dir")+"\\Customers.JSON");
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            Custom = objectMapper.readValue(file, JsonCustomer[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }


        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton,1,2);
        Button SelectScreenButton = new Button("Back");
        GridPane.setConstraints(SelectScreenButton,1,3);
        SelectScreenButton.setOnAction(LoginCustomers::handle);
        loginButton.setOnAction(e -> {

                    for (JsonCustomer x : Custom) {
                        if ((x.getUsername().equals(nameInput.getText())) && (x.getPassword().equals(Integer.toString(passInput.getText().hashCode())))) {
                            ok = 1;

                        }

                    }
                    if (ok == 1) {

                            numeCustomer=nameInput.getText();
                            AplicatieFis.window.setScene(CustomerOverview.draw());
                            AplicatieFis.window.setTitle("Customer Overview");
                            ok=0;
                    } else {
                        Alert.display("EROARE","Username sau parola gresita!");

                    }
                });


        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton,SelectScreenButton);
        Scene scene = new Scene(grid,w,h);
        return scene;
    }

    public static String getNumeCustomers()
    {
        return numeCustomer;
    }

    private static void handle(ActionEvent e) {
        AplicatieFis.window.setScene(SelectionScreen.draw());
        AplicatieFis.window.setTitle("Selection Screen");
    }
}
