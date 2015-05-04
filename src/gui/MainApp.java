package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import service.Service;

public class MainApp extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }

//    @Override
//    public void init() {
//        Service.initStorage();
//    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabConference = new Tab("Conference");
        tabPane.getTabs().add(tabConference);

        ConferencePane companyPane = new ConferencePane();
        tabConference.setContent(companyPane);
//        tabConference.setOnSelectionChanged(event -> companyPane.updateControls());

//        Tab tabEmployees = new Tab("Employees");
//        tabPane.getTabs().add(tabEmployees);
//
//        EmployeePane employeePane = new EmployeePane();
//        tabEmployees.setContent(employeePane);
//        tabEmployees.setOnSelectionChanged(event -> employeePane.updateControls());
    }

}
