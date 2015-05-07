package gui;


import java.time.LocalDate;
import java.util.ArrayList;

import service.Service;
import storage.Storage;
import model.Conference;
import model.Hotel;
import model.Excursion;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ConferenceDialog extends Stage {
    private Conference conference;

    public ConferenceDialog(String title, Conference conference) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.conference = conference;
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public ConferenceDialog(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------
    private Label lblName, lblPlace, lblPrice, lblStartTime, lblEndTime, lblHotels, lblAllHotels, lblExcursions, lblAllExcursions;
    private TextField txfName, txfPlace, txfPrice, txfStartMonth ,txfStartYear, txfEndDay, txfEndMonth, txfEndYear;
    private ListView<Hotel> lvwHotels, lvwAllHotels;
    private ListView<Excursion> lvwExcursions, lvwAllExcursions;
    private int row;
    private LocalDate startTime, endTime;
    private DatePicker startDatePicker, endDatePicker;
    private ArrayList<Hotel> hotels = new ArrayList<>();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        row = 0;
        lblName = new Label("Name");
        pane.add(lblName, 0, row, 2, 1);

        row++;
        txfName = new TextField();
        pane.add(txfName, 0, row, 2, 1);
        txfName.setPrefWidth(200);

        row++;
        lblPlace = new Label("Place");
        pane.add(lblPlace, 0, row, 2, 1);

        row++;
        txfPlace = new TextField();
        pane.add(txfPlace, 0, row, 2, 1);
        
        row++;
      lblStartTime = new Label("Start time");
      pane.add(lblStartTime, 0, row);
      
        row++;
        startDatePicker = new DatePicker();
        startDatePicker.setOnAction(event -> {startTime = startDatePicker.getValue();});
        pane.add(startDatePicker, 0, row);
        
        row++;
        lblEndTime = new Label("End time");
        pane.add(lblEndTime, 0, row);
        
        row++;
        endDatePicker = new DatePicker();
        endDatePicker.setOnAction(event -> {endTime = endDatePicker.getValue();});
        pane.add(endDatePicker, 0, row);
        
        row++;
        lblPrice = new Label("Price");
        pane.add(lblPrice, 0, row);
        
        row++;
        txfPrice = new TextField();
        pane.add(txfPrice, 0, row);
        
        row++;
        lblHotels = new Label("Hotels");
        pane.add(lblHotels, 0, row);
        
        lblAllHotels = new Label("All Hotels");
        pane.add(lblAllHotels, 1, row);
        
        row++;
        lvwHotels = new ListView<>();
        pane.add(lvwHotels, 0, row);
        lvwHotels.setPrefWidth(150);
        lvwHotels.setPrefHeight(100);

        lvwAllHotels = new ListView<>();
        pane.add(lvwAllHotels, 1, row);
        lvwAllHotels.setPrefWidth(150);
        lvwAllHotels.setPrefHeight(100);
        lvwAllHotels.getItems().setAll(Storage.getHotels());
//        lvwAllHotels.setOnMouseClicked(new EventHandler<MouseEvent>(){
//        	public void handle(MouseEvent click){
//        		if (click.getClickCount() == 2) {
//        		hotels.add(lvwAllHotels.getSelectionModel().getSelectedItem());
//        		}
//        	}});
        
        //lvwAllHotels.getSelectionModel().getSelectedItem();
        
        row++;
        lblExcursions = new Label("Excursions");
        pane.add(lblExcursions, 0, row);
        
        lblAllExcursions = new Label("All excursions");
        pane.add(lblAllExcursions, 1, row);
        
        row++;
        lvwExcursions = new ListView<>();
        pane.add(lvwExcursions, 0, row);
        lvwExcursions.setPrefWidth(150);
        lvwExcursions.setPrefHeight(100);

        
        lvwAllExcursions = new ListView<>();
        pane.add(lvwAllExcursions, 1, row);
        lvwAllExcursions.setPrefWidth(150);
        lvwAllExcursions.setPrefHeight(100);
//        lvwAllHotels.getItems().setAll(Service.getHotels());
        
        row++;
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, row);
        pane.setHalignment(btnOK, HPos.RIGHT);
//        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, row);
//        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        

    }

//    private void initControls() {
//        if (employee != null) {
//            txfName.setText(employee.getName());
//            txfWage.setText("" + employee.getWage());
//            if (employee.getCompany() != null) {
//                chbCompany.setSelected(true);
//                cbbCompany.getSelectionModel().select(employee.getCompany());
//            } else {
//                cbbCompany.getSelectionModel().select(0);
//            }
//        } else {
//            txfName.clear();
//            txfWage.clear();
//            cbbCompany.getSelectionModel().select(0);
//        }
//    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
    	String name = txfName.getText().trim();
    	String address = txfPlace.getText().trim();
    	int price = 0;
    	try {
    		price = Integer.parseInt(txfPrice.getText().trim());
    	} catch (NumberFormatException ex) {
            // do nothing
        }
    	
    	Service.createConference(name, address, startTime, endTime, price);
    	
    	for(int i = 0; i < hotels.size(); i++){
    		if (hotels.get(i) != null){
    		this.conference.addHotel(hotels.get(i));
    		}
    	}
        this.hide();
    }

//        String name = txfName.getText().trim();
//        if (name.length() == 0) {
//            lblError.setText("Name is empty");
//            return;
//        }
//
//        int wage = -1;
//        try {
//            wage = Integer.parseInt(txfWage.getText().trim());
//        } catch (NumberFormatException ex) {
//            // do nothing
//        }
//        if (wage < 0) {
//            lblError.setText("Wage is not a positive number");
//            return;
//        }
//
//        int employementYear = -1;
//        try {
//        	employementYear = Integer.parseInt(txfEmployementYear.getText().trim());
//        } catch (NumberFormatException ex) {
//            // do nothing
//        }
//        if (employementYear < 0) {
//            lblError.setText("Employement year is not a positive number");
//            return;
//        }
//        
//        boolean companyIsSelected = chbCompany.isSelected();
//        Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();
//
//        // Call Service methods
//        if (employee != null) {
//            Service.updateEmployee(employee, name, wage);
//            if (companyIsSelected) {
//                Service.updateCompanyOfEmployee(employee, newCompany);
//            }
//            else {
//                Service.clearCompanyOfEmployee(employee);
//            }
//        } else {
//            Employee newEmployee = Service.createEmployee(name, wage, employementYear);
//            if (companyIsSelected) {
//                Service.setCompanyOfEmployee(newEmployee, newCompany);
//            }
//        }
//
//        this.hide();
//    }
//
//    // -------------------------------------------------------------------------
//
//    private void selectedCompanyChanged(boolean checked) {
//        cbbCompany.setDisable(!checked);
//    }

}
