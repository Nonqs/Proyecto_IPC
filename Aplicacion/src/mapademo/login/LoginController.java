package mapademo.login;

import mapademo.MapaDemoApp;
import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void goToRegister() throws IOException {
        MapaDemoApp.setRoot("register/Registro");
        
    }

    @FXML
    private void goToHome() throws IOException {
        MapaDemoApp.setRoot("FXMLDocument");
    }
}
