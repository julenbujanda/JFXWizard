package view;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class WizardController {

    private final int PANE_WIDTH = 600;
    private final double TRANSITION_DURATION = 0.5;
    private int showSlide;
    @FXML
    private AnchorPane pane1, pane2, pane3;

    @FXML
    private Label countLabel;

    public void initialize() {
        firstPane();
    }

    public void translateAnimation(Node node, double byX) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(TRANSITION_DURATION), node);
        translateTransition.setByX(byX);
        translateTransition.play();
    }

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

    private void firstPane() {
        showSlide = 0;
        translateAnimation(pane3, 600);
        translateAnimation(pane2, 600);
    }

    private void lastPane() {
        showSlide = 2;
        translateAnimation(pane2, -600);
        translateAnimation(pane3, -600);
    }

}
