package gui;

import java.util.ArrayList;

import model.Conference;
import model.Excursion;
import model.Hotel;
import model.HotelService;
import model.Participant;
import model.Registration;
import service.Service;
import storage.Storage;
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

public class HotelPane extends GridPane{
	private Label lblHotel, lblPrice, lblPrice2, lblHotelService;

	private int row;
	private ListView<Hotel> lvwHotel;
	private ListView<HotelService> lvwHotelService;
	private Button btnCreate, btnEdit, btnDelete;
	private TextField txfHotel,txfPrice, txfPrice2;

	public HotelPane(){
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		//col1
		row = 0;

		lblHotel = new Label("Hotel");
		this.add(lblHotel, 0, row, 3, 1);

		row++;
		lvwHotel = new ListView<>();
		this.add(lvwHotel, 0, row, 3, 6);
		lvwHotel.setPrefWidth(200);
		lvwHotel.setPrefHeight(200);
		ChangeListener<Hotel> listener =
				(ov, oldHotel, newHotel) -> this.selectedHotelChanged();
				lvwHotel.getSelectionModel().selectedItemProperty().addListener(listener);
				lvwHotel.getItems().setAll(this.initHotelList());

						row+=6;
						lblPrice = new Label("Price");
						this.add(lblPrice, 0, row);
						
						row++;
						txfPrice = new TextField();
						this.add(txfPrice, 0, row);
						txfPrice.setEditable(false);
						
						row++;
						HBox hbox1 = new HBox();
						this.add(hbox1, 0, row, 3, 1);
						hbox1.setSpacing(20);

						row++;
						btnCreate = new Button("Create");
						btnEdit = new Button("Edit");
						btnDelete = new Button("Delete");

						hbox1.getChildren().addAll(btnCreate, btnEdit, btnDelete);

						//col2
						//col3
						row=6;

						row = 0;
						lblHotel = new Label("Hotel");
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
						

						row+=7;
						lblPrice2 = new Label("Price");
						this.add(lblPrice2, 4, row);

						txfPrice2 = new TextField();
						this.add(txfPrice2, 5, row);
						txfPrice2.setEditable(false);

						btnCreate.setOnAction(event -> this.createAction());
						btnEdit.setOnAction(event -> this.updateAction());
						btnDelete.setOnAction(event -> this.deleteAction());

						alwaysSelect();
	}

	private ArrayList<Hotel> initHotelList()
	{
		ArrayList<Hotel> list = new ArrayList<>();
		for(Hotel hotel: Storage.getHotels())
		{
			list.add(hotel);
		}
		return list;
	}


	private void createAction()
	{
		HotelDialog dia = new HotelDialog ("Create Hotel");
		dia.showAndWait();

		lvwHotel.getItems().setAll(this.initHotelList());
		this.updateControls();
		alwaysSelect();
	}

	private void updateAction()
	{
		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
		if (hotel == null)
			return;
		HotelDialog dia = new HotelDialog ("Update "+ hotel.getName(), hotel);
		dia.showAndWait();
		alwaysSelect();

		int selectIndex = lvwHotel.getSelectionModel().getSelectedIndex();
		lvwHotel.getItems().setAll(this.initHotelList());
		lvwHotel.getSelectionModel().select(selectIndex);
	}

	private void deleteAction()
	{
		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
		if (hotel == null)
			return;
		//		ParticipantDialog dia = new ParticipantDialog ("Update Participant", Participant);
		//		dia.showAndWait();

		Service.deleteHotel(hotel);
		lvwHotel.getItems().setAll(this.initHotelList());
		this.updateControls();
		alwaysSelect();
	}

	//-----------------------------------------------------------------

	private void alwaysSelect()
	{
		if (lvwHotel.getItems().size() > 0)
		{
			lvwHotel.getSelectionModel().select(0);
		}
		if (lvwHotelService.getItems().size() > 0)
		{
			lvwHotelService.getSelectionModel().select(0);
		}
	}

	private void selectedHotelChanged() {
		this.updateControls();
	}

//	private void selectedConferenceChanged() {
//		lvwHotel.getItems().setAll(cbbConference.getSelectionModel().getSelectedItem().getHotelsArray());
//	}



	private void updateControls()
	{
		//reset textfields

		txfHotel.clear();

		txfPrice.clear();


		Hotel hotel = lvwHotel.getSelectionModel().getSelectedItem();
//		Conference conference = cbbConference.getSelectionModel().getSelectedItem();
		if (hotel == null) {
			return;
		}




		// Hotel
				txfHotel.setText(lvwHotel.getSelectionModel().getSelectedItem().getName()+"");	
		// Hotel Service
				lvwHotelService.getItems().setAll(lvwHotel.getSelectionModel().getSelectedItem().getHotelServices());
		//price
				txfPrice.setText(lvwHotel.getSelectionModel().getSelectedItem().getPricePrDay()+"");
				txfPrice2.setText("Unimplemented");
				//lvwHotelService.getSelectionModel().getSelectedItem().getPrice()+"");

	}

}
