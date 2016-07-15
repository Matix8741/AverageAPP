package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Main extends Application {
	HBox hbox;
	TextField textfields[];
	Scene scene;
	@Override
	public void start(Stage primaryStage) {
		try {
			hbox = new HBox();
			textfields = new TextField[4];
			for(TextField test : textfields) {
				test = new TextField();
				hbox.getChildren().add(test);
			}
			hbox.setSpacing(10);
			scene = new Scene(hbox,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
