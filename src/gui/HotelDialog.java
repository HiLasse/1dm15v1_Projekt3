package gui;

import service.Service;
import model.Conference;
import model.Hotel;
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


public class HotelDialog extends Stage {
    private Hotel hotel;

    public HotelDialog(String title, Hotel hotel) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.hotel = hotel;
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public HotelDialog(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------
    private Label lblName, lblPricePrDay;
    private TextField txfName, txfPricePrDay;
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
        lblPricePrDay = new Label("Price per day");
        pane.add(lblPricePrDay, 0, row);
        
        row++;
        txfPricePrDay = new TextField();
        pane.add(txfPricePrDay, 0, row);
        txfPricePrDay.setPrefWidth(200);
        if(this.hotel != null) {
             txfName.setText(hotel.getName()+"");
             txfPricePrDay.setText(hotel.getPricePrDay()+"");
         }
        row++;
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, row);
        
//        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, row);
        pane.setHalignment(btnCancel, HPos.RIGHT);
//        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        

    }



    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }
    
    private void okAction()
    {
    	
    	String name = txfName.getText().trim();
    	int pricePrDay = 0;
    	try {
    		name = txfName.getText().trim();
    		pricePrDay = Integer.parseInt(txfPricePrDay.getText().trim());
    	} catch (NumberFormatException ex) {
            // do nothing
        }
    	
    	if (name.length() > 0 && (txfPricePrDay.getText().trim().length()) > 0)
    	{
            if(this.hotel != null) {
                this.hotel.setName(name);
                this.hotel.setPricePrDay(pricePrDay);
            }
            else{
    		Service.createHotel(name, pricePrDay);
            }
    		this.hide();
            
    	}
    	
    }
    
    

}
