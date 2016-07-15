package application;
	
import Calculate.Average;
import Calculate.Mark;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Main extends Application {
	HBox hbox;
	TextField textfields[];
	Scene scene;
	Label result;
	Button go;
	@Override
	public void start(Stage primaryStage) {
		try {
			go = new Button("GO");
			result = new Label();
			hbox = new HBox();
			textfields = new TextField[4];
			for(int i =0; i<textfields.length; i++) {
				textfields[i] = new TextField();
				hbox.getChildren().add(textfields[i]);
			}
			result.setText("jestem");
			hbox.getChildren().add(result);
			hbox.getChildren().add(go);
			hbox.setSpacing(10);
			scene = new Scene(hbox,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		go.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Mark[] marks = new Mark[textfields.length];
				for(int i =0; i< marks.length;i++) {
					double for_now=0;
					if ((textfields[i].getText() != null && !textfields[i].getText().isEmpty())){
						System.out.println(textfields[i].getText());
						try{for_now = Double.parseDouble(textfields[i].getText()); }
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
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
