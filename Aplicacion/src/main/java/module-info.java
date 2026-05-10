module com.mycompany.aplicacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.aplicacion to javafx.fxml;
    opens com.mycompany.aplicacion.register to javafx.fxml;
    opens com.mycompany.aplicacion.login to javafx.fxml;
    opens com.mycompany.aplicacion.editUser to javafx.fxml;
    exports com.mycompany.aplicacion;
}
