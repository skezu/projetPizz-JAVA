module com.dal.tprojetpizz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.dal.tprojetpizz to javafx.fxml;
    exports com.dal.tprojetpizz;
}