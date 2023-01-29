module com.example.demowithfxhibernate {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.naming;

    opens com.uppgifter.uppgift3.model;
    exports com.uppgifter.uppgift3;
    opens com.uppgifter.uppgift3 to javafx.fxml;

}