// Yoko Nakajima COSC1047w19
// Assignment#4 14.9(page587)

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class fourFans extends Application {
	@Override
	public void start(Stage stage) {
		
		//Call the drawFan() method to create four fans
		GridPane pane = drawFan();
		Scene scene = new Scene(pane, 400,400);
		stage.setTitle("Exercise14_09");
		stage.setScene(scene);
		stage.show();	
	}
			
	public static GridPane drawFan() {
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setHgap(20);
		pane.setVgap(20);
		
		int column=0;
		int row =0;
		
		for(int i =0; i< 4; i++) {
			
			Circle c = new Circle(100,100,80);
			c.setFill(Color.WHITE);
			c.setStroke(Color.BLACK);
			// Create a group and add the circle to the group
			Group group = new Group();
			group.getChildren().add(c);
			
			// Customize a color and opacity
			Color color = new Color(Math.random(), Math.random(), Math.random(), 1.0);
			
			// Create four arcs for each circle and add them to the group
				int degree;
				for(int j=0; j<4; j++) {
					degree = j*90;
					Arc arc = new Arc(100,100,65,65,30+degree,35);
					arc.setFill(color);
					arc.setType(ArcType.ROUND);
					group.getChildren().add(arc);
				}
			
			// set the row and column for the second row of fans
			if(i==2) {
				row=1;
				column=0;
			}
			pane.add(group,column,row);
			
			column++;
		}
		return  pane;
	}
	
	public static void main(String[]args) {
		Application.launch(args);
	}
}

