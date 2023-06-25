module com.example.cat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cat to javafx.fxml;
    exports com.example.cat;
}