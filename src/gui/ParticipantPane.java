package gui;

import javax.swing.JComboBox;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ParticipantPane extends GridPane {
	private ComboBox cbbConference;
	private Label lblConference, lblParticipant, lblAddress, lblTime, lblCountryOrCity, lblPhoneNr, lblCompany, lblCompanion, lblExcursion, lblHotel, lblHotelService, lblPrice;
	private ListView lvwParticipant, lvwExcursion, lvwHotelService;
	private TextField txfConf, txfAdress, txfTime, txfCountryOrCity, txfPhoneNr, txfCompany, txfCompanion, txfHotel, txfPrice;
	private CheckBox chbLecturer;
	private Button btnCreate, btnEdit, btnDelete, btnRegister;
	private int row;
	
	public ParticipantPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
	
        //col1
        row = 0;
        lblParticipant = new Label("Participant");
        this.add(lblParticipant, 0, row, 3, 1);
        
        row++;
        lvwParticipant = new ListView<>();
        this.add(lvwParticipant, 0, row, 3, 6);
        lvwParticipant.setPrefWidth(200);
        lvwParticipant.setPrefHeight(20);
//        lvwHotel.getItems().setAll(Service.getHotels());
        
        row+=6;
        lblAddress = new Label("Address");
        this.add(lblAddress, 0, row, 3, 1);
        
        row++;
        txfAdress = new TextField();
        this.add(txfAdress, 0, row, 3, 1);
        
        row++;
        lblCountryOrCity = new Label("Country or city");
        this.add(lblCountryOrCity, 0, row, 3, 1);
        
        row++;
        txfCountryOrCity = new TextField();
        this.add(txfCountryOrCity, 0, row, 3, 1);
        
        row++;
        lblPhoneNr = new Label("Phone number");
        this.add(lblPhoneNr, 0, row, 3, 1);
        
        row++;
        txfPhoneNr = new TextField();
        this.add(txfPhoneNr, 0, row, 3, 1);
        
        row++;
        lblCompany = new Label("Company");
        this.add(lblCompany, 0, row, 3, 1);
        
        row++;
        txfCompany = new TextField();
        this.add(txfCompany, 0, row, 3, 1);
        
        row++;
        btnCreate = new Button("Create");
        this.add(btnCreate, 0, row);
        
        btnEdit = new Button("Edit");
        this.add(btnEdit, 1, row);
        
        btnDelete = new Button("Delete");
        this.add(btnDelete, 2, row);
        
        //col2
        row = 1;
        lblConference = new Label("Conferences");
        this.add(lblConference, 3, row);
        
        row++;
        //WIP
        cbbConference = new ComboBox<>();
        this.add(cbbConference, 3, row);
        
        row++;
        lblTime = new Label("Time");
        this.add(lblTime, 3, row);
        
        row++;
        txfTime = new TextField();
        this.add(txfTime, 3, row);
        
        row++;
        lblCompanion = new Label("Companion");
        this.add(lblCompanion, 3, row);
        
        row++;
        txfCompanion = new TextField();
        this.add(txfCompanion, 3, row);
        
        row++;
        lblExcursion = new Label("Excursions");
        this.add(lblExcursion, 3, row);
        
        row++;
        lvwExcursion = new ListView<>();
        this.add(lvwExcursion, 3, row, 1, 7);
        lvwExcursion.setPrefWidth(200);
        lvwExcursion.setPrefHeight(20);
//        lvwExorsion.getItems().setAll(Service.getHotels());
        
        //col3
        row=2;
        lblPrice = new Label("Price");
        this.add(lblPrice, 4, row);
        
        txfPrice = new TextField();
        this.add(txfPrice, 5, row);
        
        row+=2;
        chbLecturer = new CheckBox("Lecturer");
        this.add(chbLecturer, 4, row, 2, 1);
        
        row++;
        lblHotel = new Label("Hotels");
        this.add(lblHotel, 4, row, 2, 1);
        
        row++;
        txfHotel = new TextField();
        this.add(txfHotel, 4, row, 2, 1);
        
        row++;
        lblHotelService = new Label("Hotel services");
        this.add(lblHotelService, 4, row, 2, 1);
        
        row++;
        lvwHotelService = new ListView<>();
        this.add(lvwHotelService, 4, row, 2, 7);
        lvwHotelService.setPrefWidth(200);
        lvwHotelService.setPrefHeight(200);
//        lvwHotel.getItems().setAll(Service.getHotels());
        
	}
}