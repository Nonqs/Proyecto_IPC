package com.mycompany.aplicacion.login;

import com.mycompany.aplicacion.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void goToRegister() throws IOException {
        App.setRoot("/com/mycompany/aplicacion/register/Registro");
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("primary");
    }
}
