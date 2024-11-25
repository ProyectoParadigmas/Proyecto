package co.edu.poli.demo.vista;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;



public class Main extends Application {
	private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/demo/vista/formulario.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CRUD Y ARCHIVO (clase SemaforoInteligente)");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}