package view;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Controlador de Wizard.fxml
 * @author Julen Bujanda
 */
public class WizardController {

    private final int PANE_WIDTH = 600;
    private final double TRANSITION_DURATION = 0.5;
    private int showSlide;
    @FXML
    private AnchorPane pane1, pane2, pane3;

    @FXML
    private ImageView closeButton;

    @FXML
    private Label countLabel;

    public void initialize() {
        firstPane();
    }

    /**
     * Desliza el panel deseado
     * @param pane Pane que se desea mover
     * @param byX Distancia horizontal que se deslizará
     */
    private void translateAnimation(Node pane, double byX) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), pane);
        translateTransition.setByX(byX);
        translateTransition.play();
    }

    /**
     * Se ejecuta al hacer click en el botón de siguiente
     */
    @FXML
    public void nextAction() {
        switch (showSlide) {
            case 0:
                translateAnimation(pane2, -PANE_WIDTH);
                showSlide++;
                countLabel.setText("2/3");
                break;
            case 1:
                translateAnimation(pane3, -PANE_WIDTH);
                showSlide++;
                countLabel.setText("3/3");
                break;
            case 2:
                firstPane();
                countLabel.setText("1/3");
        }
    }

    /**
     * Se ejecuta al hacer click en el botón de anterior
     */
    @FXML
    public void backAction() {
        switch (showSlide) {
            case 0:
                lastPane();
                countLabel.setText("3/3");
                break;
            case 1:
                translateAnimation(pane2, PANE_WIDTH);
                showSlide--;
                countLabel.setText("1/3");
                break;
            case 2:
                translateAnimation(pane3, PANE_WIDTH);
                showSlide--;
                countLabel.setText("2/3");
                break;
        }
    }

    /**
     * Cierra la ventana, se ejecuta desde el botón de salir
     */
    @FXML
    public void close() {
        ((Stage) closeButton.getScene().getWindow()).close();
    }

    /**
     * Muestra el primer panel, es llamado cuando se hace click en siguiente
     * estando en el último panel
     */
    private void firstPane() {
        showSlide = 0;
        translateAnimation(pane3, 600);
        translateAnimation(pane2, 600);
    }

    /**
     * Muestra el último panel, se ejecuta al hacer click en anterior en
     * el primer panel
     */
    private void lastPane() {
        showSlide = 2;
        translateAnimation(pane2, -600);
        translateAnimation(pane3, -600);
    }

}
