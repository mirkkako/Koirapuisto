module com.example.koirapuisto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.koirapuisto to javafx.fxml;
    exports com.example.koirapuisto;
}