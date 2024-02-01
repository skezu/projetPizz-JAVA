module com.dal.tprojetpizz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dal.tprojetpizz to javafx.fxml;
    exports com.dal.tprojetpizz;
}