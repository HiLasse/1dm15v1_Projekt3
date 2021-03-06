package gui;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Companion;
import model.Conference;
import model.Excursion;
import model.Hotel;
import model.Participant;
import model.Registration;
import service.Service;

public class ConferencePane extends GridPane {
	private Label lblConference, lblHotel, lblParticipant, lblPlace, lblTime, lblPrice, lblExcursion, lblCompanion;
	private ListView<Conference> lvwConference;
	private ListView<Hotel> lvwHotel;
	private ListView<Excursion> lvwExcursion;
	private ListView<Participant> lvwParticipant;
	private ListView<Companion> lvwCompanion;
	private TextField txfPlace, txfTime, txfPrice;
	private Button btnCreate, btnEdit, btnDelete, btnRegister;
	private int row;
	
	public ConferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
	
        //col1
        row = 0;
        lblConference = new Label("Conferences");
        this.add(lblConference, 0, row, 3, 1);
        
        row++;
        lvwConference = new ListView<>();
        this.add(lvwConference, 0, row, 3, 1);
        lvwConference.setPrefWidth(200);
        lvwConference.setPrefHeight(200);
    	lvwConference.getItems().setAll(Service.getConferences());
    	ChangeListener<Conference> listener =
    			(ov, oldConference, newConference) -> this.selectedConferenceChanged();
    			lvwConference.getSelectionModel().selectedItemProperty().addListener(listener);
        
        row++;
        lblPlace = new Label("Place");
        this.add(lblPlace, 0, row, 3, 1);
        
        row++;
        txfPlace = new TextField();
        this.add(txfPlace, 0, row, 3, 1);
        txfPlace.setEditable(false);
        
        row++;
        lblTime = new Label("Time");
        this.add(lblTime, 0, row, 3, 1);
        
        row++;
        txfTime = new TextField();
        this.add(txfTime, 0, row, 3, 1);
        txfTime.setEditable(false);
        
        row++;
        lblPrice = new Label("Price");
        this.add(lblPrice, 0, row, 3, 1);
        
        row++;
        txfPrice = new TextField();
        this.add(txfPrice, 0, row, 3, 1);
        txfPrice.setEditable(false);
        
        row++;
        btnCreate = new Button("Create");
        this.add(btnCreate, 0, row);
        
        btnEdit = new Button("Edit");
        this.add(btnEdit, 1, row);
        
        btnDelete = new Button("Delete");
        this.add(btnDelete, 2, row);
        
        //col2
        row=0;
        lblHotel = new Label("Hotels");
        this.add(lblHotel, 3, row);
        
        row++;
        lvwHotel = new ListView<>();
        this.add(lvwHotel, 3, row);
        lvwHotel.setPrefWidth(200);
        lvwHotel.setPrefHeight(200);
//        lvwHotel.getItems().setAll(Service.getHotels());
        
        row++;
        lblExcursion = new Label("Excursions");
        this.add(lblExcursion, 3, row);
        
        row++;
        lvwExcursion = new ListView<>();
        this.add(lvwExcursion, 3, row, 1, 5);
        lvwExcursion.setPrefWidth(200);
        lvwExcursion.setPrefHeight(20);
//        lvwExorsion.getItems().setAll(Service.getHotels());
        
        //col3
        row=0;
        lblParticipant = new Label("Participant");
        this.add(lblParticipant, 4, row);
        
        row++;
        lvwParticipant = new ListView<>();
        this.add(lvwParticipant, 4, row);
        lvwParticipant.setPrefWidth(200);
        lvwParticipant.setPrefHeight(200);
//        lvwHotel.getItems().setAll(Service.getHotels());
        
        row++;
        lblCompanion = new Label("Companion");
        this.add(lblCompanion, 4, row);
        
        row++;
        lvwCompanion = new ListView<>();
        this.add(lvwCompanion, 4, row, 1, 5);
        lvwCompanion.setPrefWidth(200);
        lvwCompanion.setPrefHeight(20);
//        lvwExorsion.getItems().setAll(Service.getHotels());        
        
        row+=5;
        btnRegister = new Button("Register");
        this.add(btnRegister, 4, row);
       
        
        
        //Button actions-----------------------------------------------------------
        btnCreate.setOnAction(event -> createAction());
        
        btnRegister.setOnAction(event -> registerAction());
        
        alwaysSelect();
        
    }
	
	
	
	

    // -------------------------------------------------------------------------

	private void alwaysSelect()
	{
		if (lvwConference.getItems().size() > 0)
		{
			lvwConference.getSelectionModel().select(0);
		}
	}
	
	
    private void createAction() {
        ConferenceDialog dia = new ConferenceDialog("Create conference");
        dia.showAndWait();

        // Wait for the modal dialog to close


    }
    
    private void registerAction() {
        RegisterDialog dia = new RegisterDialog("Register participant");
        dia.showAndWait();

        // Wait for the modal dialog to close


    }
    

//    private void updateAction() {
//        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
//        if (company == null)
//            return;
//
//        CompanyDialog dia = new CompanyDialog("Update Company", company);
//        dia.showAndWait();
//
//        // Wait for the modal dialog to close
//
//        int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
//        lvwCompanies.getItems().setAll(Service.getCompanies());
//        lvwCompanies.getSelectionModel().select(selectIndex);
//    }
//
//    private void deleteAction() {
//        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
//        if (company == null)
//            return;
//
//        if (company.employeesCount() == 0) {
//            Stage owner = (Stage) this.getScene().getWindow();
//            ConfirmDialog dialog = new ConfirmDialog("Delete Company", owner);
//            dialog.initMessage("Are you sure?");
//            dialog.showAndWait();
//
//            // Wait for the modal dialog to close
//
//            if (dialog.isConfirmed()) {
//                Service.deleteCompany(company);
//                lvwCompanies.getItems().setAll(Service.getCompanies());
//                this.updateControls();
//            }
//        } else {
//            Stage owner = (Stage) this.getScene().getWindow();
//            MessageDialog dialog =
//                new MessageDialog("Delete Company", owner);
//            dialog.initMessage("Can't delete a company that has employees");
//            dialog.showAndWait();
//            // Wait for the modal dialog to close
//        }
//    }

    // -------------------------------------------------------------------------

    private void selectedConferenceChanged() {
        this.updateControls();
    }

    public void updateControls() {
        txfPlace.clear();
        txfPrice.clear();
        txfTime.clear();
        
    	lvwCompanion.getItems().setAll(lvwConference.getSelectionModel().getSelectedItem().getCompanions());
    	lvwHotel.getItems().setAll(lvwConference.getSelectionModel().getSelectedItem().getHotelsArray());
    	lvwParticipant.getItems().setAll(lvwConference.getSelectionModel().getSelectedItem().getParticipants());
    	lvwExcursion.getItems().setAll(lvwConference.getSelectionModel().getSelectedItem().getExcursion());
    	
    	txfPrice.setText(lvwConference.getSelectionModel().getSelectedItem().getPrice()+"");
    	txfTime.setText("" + lvwConference.getSelectionModel().getSelectedItem().getStartTime() + " to " + lvwConference.getSelectionModel().getSelectedItem().getEndTime() +" "+ lvwConference.getSelectionModel().getSelectedItem().getTotaltime()+" days");
    	txfPlace.setText(lvwConference.getSelectionModel().getSelectedItem().getAddress());
    	
    }
}

