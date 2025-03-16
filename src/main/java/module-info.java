module org.example.fotbalovytymlistview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.fotbalovytymlistview to javafx.fxml;
    exports org.example.fotbalovytymlistview;
}