package gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ConferencePane extends GridPane {
	private ListView Lvwconference
    }

    // -------------------------------------------------------------------------

//    private void createAction() {
//        CompanyDialog dia = new CompanyDialog("Create Company");
//        dia.showAndWait();
//
//        // Wait for the modal dialog to close
//
//        lvwCompanies.getItems().setAll(Service.getCompanies());
//        int index = lvwCompanies.getItems().size() - 1;
//        lvwCompanies.getSelectionModel().select(index);
//    }
//
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

//    private void selectedCompanyChanged() {
//        this.updateControls();
//    }
//
//    public void updateControls() {
//        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
//        if (company != null) {
//            txfName.setText(company.getName());
//            txfHours.setText("" + company.getHours());
//            StringBuilder sb = new StringBuilder();
//            for (Employee emp : company.getEmployees()) {
//                sb.append(emp + "\n");
//            }
//            txaEmps.setText(sb.toString());
//        } else {
//            txfName.clear();
//            txfHours.clear();
//            txaEmps.clear();
//        }
//    }


