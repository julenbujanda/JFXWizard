import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase principal
 * @author Julen Bujanda
 */
public class Main extends Application {

    private double xOffset;
    private double yOffset;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Wizard.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Sign Up");
        primaryStage.getIcons().add(new Image("img/keyboard.png"));
        primaryStage.setResizable(false);
        // Eliminar el marco de la ventana y hacer su fondo transparente
        primaryStage.initStyle(StageStyle.UNDECORATED);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        // Crear Rectangle para salvar la limitación de los bordes en el Stage
        Rectangle rect = new Rectangle(480, 600);
        rect.setArcHeight(50.0);
        rect.setArcWidth(50.0);
        // Mover ventana al arrastrarla con el ratón
        root.setOnMousePressed(event -> {
            xOffset = primaryStage.getX() - event.getScreenX();
            yOffset = primaryStage.getY() - event.getScreenY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() + xOffset);
            primaryStage.setY(event.getScreenY() + yOffset);
        });
        root.setClip(rect);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
