// Yoko Nakajima COSC1047w19
// Assignment#6 16.19(page686)

import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class FanPane extends Pane{
	private Timeline animation;	
	private Pane pane;
	private int increment = 1;
	private Arc[] arcs = new Arc[4];
	private Slider slspeed;
	
	public FanPane() {
		pane = drawFan();
		getChildren().add(pane);
		animation = new Timeline(new KeyFrame(Duration.millis(10), e-> moveFan()));
		animation.setCycleCount(Timeline.INDEFINITE);
	}
	
	public void speedControl() {
		animation.setRate(slspeed.getValue());
	}

	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	
	public void start() {
		animation.play();
	}
	
	public void stop() {
		animation.pause();
	}
	
	public void reverse() {
		increment = (increment == 1) ? -1 : 1;
	}
	
	public void setSlider() {
		slspeed = new Slider();
		slspeed.setMin(1);
		slspeed.setMax(10);
		slspeed.valueProperty().addListener(ov ->
			speedControl());	
	}
	
	public void moveFan() {
		for(int i =0; i< arcs.length; i++) {
			arcs[i].setStartAngle(arcs[i].getStartAngle() + increment);
		}
	}

	public Pane drawFan() {
		
		BorderPane bpane = new BorderPane();
		bpane.setPadding(new Insets(5));
		
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		
		Button btPause = new Button("Pause");
		Button btResume = new Button("Resume");
		Button btReverse = new Button("Reverse");
		
		btPause.setOnAction(e-> stop());
		btResume.setOnAction(e-> start());
		btReverse.setOnAction(e-> reverse());
		
		hbox.getChildren().addAll(btPause,btResume,btReverse);
		
		bpane.setTop(hbox);
		
		Circle c = new Circle(100,100,70);
		c.setFill(Color.WHITE);
		c.setStroke(Color.BLACK);
		
		//Group is for circle and arcs
		Group group = new Group();
		group.getChildren().add(c);
		
		// Customize a color and opacity
		Color color = new Color(Math.random(), Math.random(), Math.random(), 1.0);
		
		// Create four arcs
		int degree;
		for(int j=0; j<4; j++) {
			degree = j*90;
			Arc arc = new Arc(100,100,60,60,30+degree,35);
			arc.setFill(color);
			arc.setType(ArcType.ROUND);
			group.getChildren().add(arc);
			arcs[j]= arc;
		}
		bpane.setCenter(group);
		
		// Set the slider at the bottom of BorderPane 
		setSlider();
		bpane.setBottom(slspeed);
		bpane.setStyle("-fx-border-color: black");
	
		Pane pane = new Pane();
		pane.getChildren().add(bpane);
		
		return pane;
	}
}
