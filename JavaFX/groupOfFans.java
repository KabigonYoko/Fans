// Yoko Nakajima COSC1047w19
// Assignment#6 16.19(page686)

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class groupOfFans extends Application {
	private FanPane[] fanpane = {new FanPane(), new FanPane(), new FanPane()};
	
	@Override
	public void start(Stage stage) {
		
		// Add three FanPane objects into the HBox
		HBox hbox1 = new HBox(5);
		//hbox1.setAlignment(Pos.CENTER);
		hbox1.getChildren().addAll(fanpane[0], fanpane[1], fanpane[2]);
		
		HBox hbox2 = new HBox(15);
		hbox2.setAlignment(Pos.CENTER);
		
		Button btStart = new Button("Start All");
		Button btStop = new Button("Stop All");
		hbox2.getChildren().addAll(btStart, btStop);
		
		BorderPane bpane = new BorderPane();
		bpane.setCenter(hbox1);
		bpane.setBottom(hbox2);
		
		// Pause animation
		btStart.setOnAction(e-> {
			fanpane[0].start();
			fanpane[1].start();
			fanpane[2].start();
		});
		
		// Resume animation
		btStop.setOnAction(e->{
			fanpane[0].stop();
			fanpane[1].stop();
			fanpane[2].stop();
		});
	
		Scene scene = new Scene(bpane,600,230);
		stage.setTitle("Exercise16_19");
		stage.setScene(scene);
		stage.show();	
		}		
	
	public static void main(String[]args) {
		Application.launch(args);
	}
}


	
	
