package com.mycompany.aplicacion.editUser;

import com.mycompany.aplicacion.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class EditUserController {

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("primary");
    }
}
