package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import service.Service;

public class MainApp extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Service.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS");
		//stage.setTitle("CuteOwl Conference Administrator 0.0.1");
		stage.getIcons().add(new Image("file:resources/cuteOwl.png"));
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

        ConferencePane conferencePane = new ConferencePane();
        tabConference.setContent(conferencePane);
//        tabConference.setOnSelectionChanged(event -> companyPane.updateControls());

        Tab tabExcursion = new Tab("Excursion");
        tabPane.getTabs().add(tabExcursion);

        ExcursionPane excursionPane = new ExcursionPane();
        tabExcursion.setContent(excursionPane);
//        tabExcursion.setOnSelectionChanged(event -> excursionPane.updateControls());
        
        Tab tabHotel = new Tab("Hotel");
        tabPane.getTabs().add(tabHotel);

        HotelPane hotelPane = new HotelPane();
        tabHotel.setContent(hotelPane);
//        tabHotel.setOnSelectionChanged(event -> hotelPane.updateControls());	
        
        Tab tabParticipant = new Tab("Participant");
        tabPane.getTabs().add(tabParticipant);

        ParticipantPane participantPane = new ParticipantPane();
        tabParticipant.setContent(participantPane);
//        tabParticipant.setOnSelectionChanged(event -> participantPane.updateControls());	
    }

}
