package gui;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Conference;
import model.Excursion;
import model.Hotel;
import model.HotelService;
import model.Participant;
import model.Registration;
import service.Service;

public class ParticipantPane extends GridPane {
	private ComboBox<Conference> cbbConference;
	private Label lblConference, lblParticipant, lblAddress, lblTime, lblCountryOrCity, lblPhoneNr, lblCompany, lblCompanion, lblExcursion, lblHotel, lblHotelService, lblPrice;
	private ListView<Excursion>  lvwExcursion; 
	private ListView<HotelService>lvwHotelService;
	private ListView<Participant> lvwParticipant;
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
		lvwParticipant.getItems().setAll(Service.getParticipants()); // this.initParticipantList()
		ChangeListener<Participant> listener =
				(ov, oldParticipant, newParticipant) -> this.selectedParticipantChanged();
				lvwParticipant.getSelectionModel().selectedItemProperty().addListener(listener);


				//        lvwHotel.getItems().setAll(Service.getHotels());

				row+=6;
				lblAddress = new Label("Address");
				this.add(lblAddress, 0, row, 3, 1);

				row++;
				txfAdress = new TextField();
				this.add(txfAdress, 0, row, 3, 1);
				txfAdress.setEditable(false);

				row++;
				lblCountryOrCity = new Label("Country or city");
				this.add(lblCountryOrCity, 0, row, 3, 1);

				row++;
				txfCountryOrCity = new TextField();
				this.add(txfCountryOrCity, 0, row, 3, 1);
				txfCountryOrCity.setEditable(false);

				row++;
				lblPhoneNr = new Label("Phone number");
				this.add(lblPhoneNr, 0, row, 3, 1);

				row++;
				txfPhoneNr = new TextField();
				this.add(txfPhoneNr, 0, row, 3, 1);
				txfPhoneNr.setEditable(false);

				row++;
				lblCompany = new Label("Company");
				this.add(lblCompany, 0, row, 3, 1);

				row++;
				txfCompany = new TextField();
				this.add(txfCompany, 0, row, 3, 1);
				txfCompany.setEditable(false);

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
				cbbConference.getItems().setAll(Service.getConferences());

				row++;
				lblTime = new Label("Time");
				this.add(lblTime, 3, row);

				row++;
				txfTime = new TextField();
				this.add(txfTime, 3, row);
				txfTime.setEditable(false);

				row++;
				lblCompanion = new Label("Companion");
				this.add(lblCompanion, 3, row);

				row++;
				txfCompanion = new TextField();
				this.add(txfCompanion, 3, row);
				txfCompanion.setEditable(false);

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
				txfPrice.setEditable(false);

				row+=2;
				chbLecturer = new CheckBox("Lecturer");
				this.add(chbLecturer, 4, row, 2, 1);
				chbLecturer.setDisable(true);

				row++;
				lblHotel = new Label("Hotels");
				this.add(lblHotel, 4, row, 2, 1);

				row++;
				txfHotel = new TextField();
				this.add(txfHotel, 4, row, 2, 1);
				txfHotel.setEditable(false);

				row++;
				lblHotelService = new Label("Hotel services");
				this.add(lblHotelService, 4, row, 2, 1);

				row++;
				lvwHotelService = new ListView<>();
				this.add(lvwHotelService, 4, row, 2, 7);
				lvwHotelService.setPrefWidth(200);
				lvwHotelService.setPrefHeight(200);

				btnCreate.setOnAction(event -> this.createAction());
				btnEdit.setOnAction(event -> this.updateAction());
				btnDelete.setOnAction(event -> this.deleteAction());


	}

	private ArrayList<Participant> initParticipantList()
	{
		ArrayList<Participant> list = new ArrayList<>();
		for( Participant participant: Service.getParticipants())
		{
			list.add(participant);
		}
		return list;
	}
	
	private ArrayList<Excursion> initExcursionList()
	{
		ArrayList<Excursion> list = new ArrayList<>();
		for(Registration regi: Service.getRegistration())
		{
			list = regi.getExcursions();
		}
		return list;
	}


	private void createAction()
	{
		ParticipantDialog dia = new ParticipantDialog ("Create Participant");
		dia.showAndWait();

		lvwParticipant.getItems().setAll(initParticipantList());
		this.updateControls();
	}

	private void updateAction()
	{
		Participant participant = lvwParticipant.getSelectionModel().getSelectedItem();
		if (participant == null)
			return;
		ParticipantDialog dia = new ParticipantDialog ("Update Participant", participant);
		dia.showAndWait();

		int selectIndex = lvwParticipant.getSelectionModel().getSelectedIndex();
		lvwParticipant.getItems().setAll(this.initParticipantList());
		lvwParticipant.getSelectionModel().select(selectIndex);
	}

	private void deleteAction()
	{
		Participant participant = lvwParticipant.getSelectionModel().getSelectedItem();
		if (participant == null)
			return;
		//		ParticipantDialog dia = new ParticipantDialog ("Update Participant", Participant);
		//		dia.showAndWait();

		Service.deleteParticipant(participant);
		lvwParticipant.getItems().setAll(this.initParticipantList());
		this.updateControls();
	}

	//-----------------------------------------------------------------

	private ArrayList<Hotel> getHotelsFromConferences()
	{
		Conference conference = cbbConference.getSelectionModel().getSelectedItem();
		ArrayList<Hotel> hotels = conference.getHotelsArray();
		return hotels;
	}

	private void selectedParticipantChanged() {
		this.updateControls();
	}
	
	

	private void updateControls()
	{
		Participant participant = lvwParticipant.getSelectionModel().getSelectedItem();
		Conference conference = cbbConference.getSelectionModel().getSelectedItem();
		Excursion excursion = lvwExcursion.getSelectionModel().getSelectedItem();
		if ( participant != null)
		{
			txfAdress.setText(participant.getAddress());
			txfCountryOrCity.setText(participant.getCountryOrCity());
			txfPhoneNr.setText(""+participant.getTelephone());
			
			//Company
			if( participant.getCompany() != null)
			{
				txfCompany.setText(participant.getCompany()+"");
			}
			else
			{
				txfCompany.clear();
			}
			
			//Lecturer
			if (participant.isLecture())
			{
				chbLecturer.setDisable(false);
				chbLecturer.setSelected(true);
			}
			else
			{
				chbLecturer.setDisable(true);
				chbLecturer.setSelected(false);
			}
			
			//Companion
//			for(Participant x: conference.getParticipantsArray())
//			{
//				if(x.getCompanion().equals(participant.getCompanion()))
//				{
//					if (x.getCompanion().getName().trim().length() > 0)
//					{
//					 txfCompanion.setText(x.getCompanion().getName());
//					}
//				}
//			}
			
			// Hotel
			for(Registration x: Service.getRegistration())
			{
				if(x.getParticipant().equals(participant))
				{
					txfHotel.setText(x.getHotel().getName());
				}
//				else 
//				{ 
//					txfHotel.clear();
//				}
				txfPrice.setText(x.calcTotalPrice()+"");
			}
			
			// Hotel Service
			for(Registration x: Service.getRegistration()) 
			{
				if(x.getParticipant().equals(participant))
				{
					lvwHotelService.getItems().setAll(x.getHotelServices());
				}
				txfPrice.setText(x.calcTotalPrice()+"");
			}
			
			//Excursion
			for(Registration x: Service.getRegistration()) 
			{
				if(x.getParticipant().equals(participant))
				{
					lvwExcursion.getItems().setAll(x.getExcursions());
				}
				txfPrice.setText(x.calcTotalPrice()+"");
			}
		}
		else
		{
			txfAdress.clear();
			txfCountryOrCity.clear();
			txfPhoneNr.clear();
		}
		
	}
}
