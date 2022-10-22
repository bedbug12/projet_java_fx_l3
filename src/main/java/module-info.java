module ism.gestion {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;
    requires com.fasterxml.jackson.databind;

    opens  ism.gestion.controllers to javafx.fxml;
    exports ism.gestion;
    exports ism.gestion.core;
    exports ism.gestion.entities;
    exports ism.gestion.controllers;
}

