package gui;

import sun.launcher.resources.launcher;
import model.Conference;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
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


public class ConferenceDialog extends Stage {
    private Conference conference;

    public ConferenceDialog(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
//
//    public ConferenceDialog(String title) {
//        this(title, null);
//    }

    // -------------------------------------------------------------------------
    private Label lblName, lblPlace, lblDay, lblMonth, lblYear, lblStartTime, lblEndTime, lblHotels, lblAllHotels, lblExcursions, lblAllExcursions;
    private TextField txfName, txfPlace, txfStartDay, txfStartMonth ,txfStartYear, txfEndDay, txfEndMonth, txfEndYear;
    private ListView lvwHotels, lvwAllHotels, lvwExcursions, lvwAllExcursions;
    private int row;

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
        //---tidpane start---
        GridPane timePane = new GridPane();
        pane.add(timePane, 0, row, 2, 1);
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
//        lvwAllHotels.getItems().setAll(Service.getHotels());        
        
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
//        btnOK.setOnAction(event -> this.okAction());
        
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
