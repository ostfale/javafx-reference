package de.ostfale.fx.sample.ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private final String javafxVersion = System.getProperty("javafx.version");

    @FXML
    private Label color;

    @FXML
    private Label label;

    @FXML
    private ResourceBundle resources;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(String.format(resources.getString("label.text"), "JavaFX", javafxVersion));
    }

    @FXML
    private void updateColor() {
        Random random = new Random();
        this.color.setTextFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }
}
