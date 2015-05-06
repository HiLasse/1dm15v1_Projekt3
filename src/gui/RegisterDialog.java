package gui;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class RegisterDialog extends Stage {
    public RegisterDialog(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }


    // -------------------------------------------------------------------------
    private Label lblConference, lblParticipant, lblDay, lblMonth, lblYear, lblStartTime, lblEndTime, lblExcursions, lblAllExcursions, lblServices, lblAllServices;
    private TextField txfCompanion, txfStartDay, txfStartMonth ,txfStartYear, txfEndDay, txfEndMonth, txfEndYear;
    private ListView lvwParticipant, lvwExcursions, lvwAllExcursions, lvwServices, lvwAllServices;
    private CheckBox chbCompanion, chbHotel;
	private ComboBox<Object> cbbConference, cbbHotel;
	private int row;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(50);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        
        GridPane pane1 = new GridPane();
        pane1.setHgap(10);
        pane1.setVgap(10);
        pane.add(pane1, 0, 0);
        
        row = 0;
        lblConference = new Label("Conferences");
        pane1.add(lblConference, 0, row, 2, 1);
        
        row++;
        cbbConference = new ComboBox<>();
        pane1.add(cbbConference, 0, row, 2, 1);
        
        row++;
        lblParticipant = new Label("Participant");
        pane1.add(lblParticipant, 0, row, 2, 1);
        
        row++;
        lvwParticipant = new ListView<>();
        pane1.add(lvwParticipant, 0, row);
        lvwParticipant.setPrefWidth(150);
        lvwParticipant.setPrefHeight(100);
//        lvwParticipant.getItems().setAll(this.initParticipantList());
//        ChangeListener<Participant> listener =
//                (ov, oldParticipant, newParticipant) -> this.selectedParticipantChanged();
//                lvwParticipant.getSelectionModel().selectedItemProperty().addListener(listener);
        
        Button btnCreate = new Button("Create");
        pane1.add(btnCreate, 1, row);
        
        row++;
        //---tidpane start---
        GridPane timePane = new GridPane();
        pane1.add(timePane, 0, row, 2, 1);
        timePane.setHgap(10);
        timePane.setVgap(10);
        timePane.setGridLinesVisible(false);
        
        lblDay = new Label("Day");
        timePane.add(lblDay, 1, 0);
        
        lblMonth = new Label("Month");
        timePane.add(lblMonth, 2, 0);
        
        lblYear = new Label("Year");
        timePane.add(lblYear, 3, 0);
        
        lblStartTime = new Label("Start time");
        timePane.add(lblStartTime, 0, 1);

        lblEndTime = new Label("End time");
        timePane.add(lblEndTime, 0, 2);
        
        txfStartDay = new TextField();
        timePane.add(txfStartDay, 1, 1);
        txfStartDay.setPrefWidth(40);
        
        txfStartMonth = new TextField();
        timePane.add(txfStartMonth, 2, 1);
        txfStartMonth.setPrefWidth(40);
        
        txfStartYear = new TextField();
        timePane.add(txfStartYear, 3, 1);
        txfStartYear.setPrefWidth(60);
        
        txfEndDay = new TextField();
        timePane.add(txfEndDay, 1, 2);
        txfEndDay.setPrefWidth(40);
        
        txfEndMonth = new TextField();
        timePane.add(txfEndMonth, 2, 2);
        txfEndMonth.setPrefWidth(40);
        
        txfEndYear = new TextField();
        timePane.add(txfEndYear, 3, 2);
        txfEndYear.setPrefWidth(60);
        //---tidpane slut---
        
        
        GridPane pane2 = new GridPane();
        pane2.setHgap(10);
        pane2.setVgap(10);
        pane.add(pane2, 1, 0);
        
        row=0;
        chbCompanion = new CheckBox("Companion");
        pane2.add(chbCompanion, 0, row, 2, 1);
        
        row++;
        txfCompanion = new TextField();
        pane2.add(txfCompanion, 0, row, 2, 1);
        txfCompanion.setDisable(true);
        
        
        row++;
        lblExcursions = new Label("Excursions");
        pane2.add(lblExcursions, 0, row);
        
        lblAllExcursions = new Label("All excursions");
        pane2.add(lblAllExcursions, 1, row);
        
        row++;
        lvwExcursions = new ListView<>();
        pane2.add(lvwExcursions, 0, row);
        lvwExcursions.setPrefWidth(150);
        lvwExcursions.setPrefHeight(100);

        
        lvwAllExcursions = new ListView<>();
        pane2.add(lvwAllExcursions, 1, row);
        lvwAllExcursions.setPrefWidth(150);
        lvwAllExcursions.setPrefHeight(100);
//        lvwAllHotels.getItems().setAll(Service.getHotels());
        lvwAllExcursions.setDisable(true);
        
        
        row++;
        chbHotel = new CheckBox("Hotel");
        pane2.add(chbHotel, 0, row, 2, 1);
        
        row++;
        cbbHotel = new ComboBox<Object>();
        pane2.add(cbbHotel, 0, row, 2, 1);
        cbbHotel.setDisable(true);
        
        
        row++;
        lblServices = new Label("Services");
        pane2.add(lblServices, 0, row);
        
        lblAllServices = new Label("All services");
        pane2.add(lblAllServices, 1, row);
        
        row++;
        lvwServices = new ListView<>();
        pane2.add(lvwServices, 0, row);
        lvwServices.setPrefWidth(150);
        lvwServices.setPrefHeight(100);

        
        lvwAllServices = new ListView<>();
        pane2.add(lvwAllServices, 1, row);
        lvwAllServices.setPrefWidth(150);
        lvwAllServices.setPrefHeight(100);
//        lvwAllServices.getItems().setAll(Service.getServices());
        
        
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 1);
        pane.setHalignment(btnOK, HPos.RIGHT);
//        GridPane.setHalignment(btnOK, HPos.RIGHT);
//        btnOK.setOnAction(event -> this.okAction());
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 1);
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

//    private void okAction() {
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
