module com.mycompany.aplicacion {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.aplicacion to javafx.fxml;
    exports com.mycompany.aplicacion;
}
