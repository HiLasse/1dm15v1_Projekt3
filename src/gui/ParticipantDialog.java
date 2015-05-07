package gui;

import service.Service;
import model.Conference;
import model.Participant;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ParticipantDialog extends Stage {
    private Participant participant;

    public ParticipantDialog(String title, Participant participant) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.participant = participant;
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public ParticipantDialog(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------
    private Label lblName, lblAddress, lblCountryOrCity, lblPhoneNr, lblCompany;
    private TextField txfName, txfAddress, txfCountryOrCity, txfPhoneNr, txfCompany;
    private int row;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        row = 0;
        lblName = new Label("Name");
        pane.add(lblName, 0, row);

        row++;
        txfName = new TextField();
        pane.add(txfName, 0, row);
        txfName.setPrefWidth(200);

        row++;
        lblAddress = new Label("Address");
        pane.add(lblAddress, 0, row);
        
        row++;
        txfAddress = new TextField();
        pane.add(txfAddress, 0, row);

        row++;
        lblCountryOrCity = new Label("Country or city");
        pane.add(lblCountryOrCity, 0, row);
        
        row++;
        txfCountryOrCity = new TextField();
        pane.add(txfCountryOrCity, 0, row);
        
        row++;
        lblPhoneNr = new Label("Phone number");
        pane.add(lblPhoneNr, 0, row);
        
        row++;
        txfPhoneNr = new TextField();
        pane.add(txfPhoneNr, 0, row);
        
        row++;
        lblCompany = new Label("Company");
        pane.add(lblCompany, 0, row);
        
        row++;
        txfCompany = new TextField();
        pane.add(txfCompany, 0, row);
        
        row++;
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, row);
        
        if(this.participant != null) {
            txfName.setText(participant.getName()+"");
            txfAddress.setText(participant.getAddress()+"");
            txfCountryOrCity.setText(participant.getCountryOrCity()+"");
            txfPhoneNr.setText(participant.getTelephone()+"");
            txfCompany.setText(participant.getCompany()+"");
         }
//        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, row);
        pane.setHalignment(btnCancel, HPos.RIGHT);
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
    
    private void okAction()
    {
    	
    	String name = txfName.getText().trim();
    	String address = txfAddress.getText().trim();
    	int phone = 0;
    	String countryOrCity = txfCountryOrCity.getText().trim();
    	String company = txfCompany.getText().trim();
    	try {
    		name = txfName.getText().trim();
    		address = txfAddress.getText().trim();
    		phone = Integer.parseInt(txfPhoneNr.getText().trim());
    	} catch (NumberFormatException ex) {
            // do nothing
        }
    	
    	if (name.length() > 0  && address.length() > 0 && countryOrCity.length() > 0 && (txfPhoneNr.getText().trim().length()) > 0)
    	{
    		Service.createParticipant(name, address, phone, countryOrCity, false);
    		this.hide();
    	}
    	
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
