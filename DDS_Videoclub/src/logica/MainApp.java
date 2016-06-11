package logica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Videoclub");

        initRootLayout();

        showOverview("../presentacion/vista/MenuPrincipalEmpleado.fxml");
    }


    private void initRootLayout() {
        try {
            // Cargamos el layout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../presentacion/vista/RootLayout.fxml"));
            rootLayout = loader.load();

            // Cargamos el contenido
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showOverview(String rutaVista) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(rutaVista));
            AnchorPane overview = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(overview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
