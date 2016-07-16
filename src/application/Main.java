package application;
	
import java.util.ArrayList;

import Calculate.Average;
import Calculate.Mark;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	public int amount_fields = 0;
	public int height = 110;
	VBox vbox;
	BorderPane botton_panel;
	BorderPane front;
	ArrayList<TextField> textfields;
	Scene scene;
	Label result;
	Button go, add;
	private void add_field(ArrayList<TextField> textfields, Stage primaryStage) {
		textfields.add(new TextField());
		textfields.get(textfields.size()-1).setMaxWidth(50);
		textfields.get(textfields.size()-1).setPrefHeight(21);
		amount_fields++;
		vbox.getChildren().add(textfields.get(amount_fields-1));
		height+=35;
		primaryStage.setHeight(height);
	}
	@Override
	public void start(Stage primaryStage) {
		primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));
		try {
			front = new BorderPane();
			scene = new Scene(front,40,height);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			add = new Button("add");
			botton_panel = new BorderPane();
			go = new Button("GO");
			result = new Label();
			vbox = new VBox();
			vbox.setPadding(new Insets(10));
			vbox.setSpacing(8);
			textfields = new ArrayList<>();
			vbox.getChildren().add(add);
			add_field(textfields,primaryStage);
			add_field(textfields,primaryStage);
			add_field(textfields,primaryStage);
			add_field(textfields,primaryStage);
			result.setText("jestem");
			vbox.setSpacing(10);
			front.setLeft(vbox);
			front.setMaxWidth(120);
			front.setMaxHeight(120);
			botton_panel.setLeft(result);
			botton_panel.setPadding(new Insets(9));
			botton_panel.setRight(go);
			front.setBottom(botton_panel);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
		go.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Mark[] marks = new Mark[textfields.size()];
				for(int i =0; i< marks.length;i++) {
					double for_now=0;
					if ((textfields.get(i).getText() != null && !textfields.get(i).getText().isEmpty())){
						System.out.println(textfields.get(i).getText());
						try{for_now = Double.parseDouble(textfields.get(i).getText()); }
						catch(NumberFormatException e) {
								System.out.println("nie dziala");
							}
					}
					marks[i] =  new Mark(for_now);
				}
				String text =String.valueOf(Average.Count_Average(marks)) ;
				result.setText(text);
			}
		});
		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				add_field(textfields,primaryStage);
				
			}
			
		});

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
