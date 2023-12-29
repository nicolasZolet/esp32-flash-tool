module com.nicolas.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fazecast.jSerialComm;


    opens com.nicolas.demo to javafx.fxml;
    exports com.nicolas.demo;
    exports com.nicolas.demo.classes;
    opens com.nicolas.demo.classes to javafx.fxml;
}