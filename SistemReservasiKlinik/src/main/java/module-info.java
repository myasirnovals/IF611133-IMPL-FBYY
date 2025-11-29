module id.ac.ifunjani.sistemreservasiklinik {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens id.ac.ifunjani.sistemreservasiklinik to javafx.fxml;
    exports id.ac.ifunjani.sistemreservasiklinik;
}