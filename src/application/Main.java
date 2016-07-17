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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	public int amount_fields = 0;
	public int height = 110;
	HBox top_options;
	VBox vbox;
	BorderPane botton_panel;
	BorderPane front;
	ArrayList<TextField> textfields, values;
	ArrayList<HBox> rows;
	Scene scene;
	Label result;
	Button go, add;
	RadioButton isValues;
	private void add_field(ArrayList<TextField> textfields, Stage primaryStage) {
		rows.add(new HBox());
		textfields.add(new TextField());
		textfields.get(textfields.size()-1).setMaxWidth(50);
		textfields.get(textfields.size()-1).setPrefHeight(21);
		amount_fields++;
		rows.get(amount_fields-1).getChildren().add(textfields.get(amount_fields-1));
		vbox.getChildren().add(rows.get(amount_fields-1));
		height+=35;
		primaryStage.setHeight(height);
	}
	private void clear_values(ArrayList<TextField> values) {
		for(int i =0; i<values.size();i++) {
			rows.get(i).getChildren().remove(values.get(i));
		}
		
	}
	private void on_values(ArrayList<TextField> values) {
		if(rows.size()==values.size()){
			for(int i=0; i<rows.size();i++) {
				rows.get(i).getChildren().add(values.get(i));
				rows.get(i).setSpacing(10);
			}
			
		}
		else {
			if(values.size()==0) {
				for(int i=0; i<rows.size();i++) {
					values.add(new TextField());
					values.get(i).setMaxWidth(50);
					values.get(i).setMaxHeight(21);
					rows.get(i).getChildren().add(values.get(i));
					rows.get(i).setSpacing(10);
				}
			}
			else {
				for(int i=values.size(); i<rows.size();i++) {
					values.add(new TextField());
					values.get(i).setMaxWidth(50);
					values.get(i).setMaxHeight(21);
				}
				for(int i=0; i<rows.size();i++) {
					rows.get(i).getChildren().add(values.get(i));
					rows.get(i).setSpacing(10);
				}
			}
		}
	}
	@Override
	public void start(Stage primaryStage) {
		primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));
		try {
			values = new ArrayList<>();
			rows = new ArrayList<>();
			isValues = new RadioButton("Values");
			top_options = new HBox();
			front = new BorderPane();
			scene = new Scene(front,160,height);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			add = new Button("add");
			botton_panel = new BorderPane();
			go = new Button("GO");
			result = new Label();
			vbox = new VBox();
			vbox.setPadding(new Insets(10));
			vbox.setSpacing(8);
			textfields = new ArrayList<>();
			top_options.getChildren().addAll(add,isValues);
			top_options.setSpacing(16);
			vbox.getChildren().add(top_options);
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
				String text = "";
				
				if(isValues.isSelected()){
					for(int i =0; i< marks.length;i++) {
						double for_now=0;
						double for_values=0;
						if ((textfields.get(i).getText() != null && !textfields.get(i).getText().isEmpty())){
							System.out.println(textfields.get(i).getText());
							try{for_now = Double.parseDouble(textfields.get(i).getText()); }
							catch(NumberFormatException e) {
									System.out.println("nie dziala");
								}
						}
						if ((values.get(i).getText() != null && !values.get(i).getText().isEmpty())){
							System.out.println(values.get(i).getText());
							try{for_values = Double.parseDouble(values.get(i).getText()); }
							catch(NumberFormatException e) {
									System.out.println("nie dziala");
								}
						}
						marks[i] =  new Mark(for_now, for_values);
					}
					System.out.println("lele" +marks[0].getValue());
					text =String.valueOf(Average.Count_Average(marks)) ;
				}
				else {
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
					text =String.valueOf(Average.Count_Average(marks)) ;
				}
				result.setText(text);
			}
		});
		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				add_field(textfields,primaryStage);
				
			}
			
		});
		isValues.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(isValues.isSelected()){
					System.out.println("ee");
					on_values(values);
					//clear_values(values);
				}
				else {
					clear_values(values);
				}
			}

		});

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
