module com.example.tdtp1_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tdtp1_javafx to javafx.fxml;
    exports com.example.tdtp1_javafx;
}