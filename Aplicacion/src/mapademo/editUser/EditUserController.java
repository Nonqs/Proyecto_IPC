package mapademo.editUser;

import mapademo.MapaDemoApp;
import java.io.IOException;
import javafx.fxml.FXML;

public class EditUserController {

    @FXML
    private void goToHome() throws IOException {
        MapaDemoApp.setRoot("FXMLDocument");
    }
}
