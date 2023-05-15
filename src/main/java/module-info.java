module com.example.td1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.FXML1 to javafx.fxml;
    exports com.example.td1.FXML1;

    exports com.example.td1.partie1;
    exports com.example.td1.partie2;
    exports com.example.td1.pacman;
    exports com.example.td1.Pendu;

}

