package guiTEST;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class TestApp extends Application{
	double windowHeight;
	double windowWidth;
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage mainStage){
		mainStage.setTitle("CuteOwl Conference Administrator 0.0.1");
		mainStage.getIcons().add(new Image("file:resources/cuteOwl.png"));
		GridPane mainPane = new GridPane();
		Scene mainScene = new Scene(mainPane);
		mainStage.setScene(mainScene);
		mainStage.setResizable(true);
		mainStage.show();
		mainStage.setMaximized(true);
		windowHeight = mainStage.getHeight();
		windowWidth = mainStage.getWidth();
		this.initContent(mainPane);

	}
	
	private void initContent(GridPane mainPane) {
		mainPane.setGridLinesVisible(false);
		mainPane.setPadding(new Insets(10));
		mainPane.setHgap(10);
		mainPane.setVgap(10);
		mainPane.setStyle("-fx-background-color: blue");
		Label lblRolled = new Label(""+windowWidth+" "+windowHeight);
		mainPane.add(lblRolled, 4, 3);
	}
private Test test = new Test();
}
