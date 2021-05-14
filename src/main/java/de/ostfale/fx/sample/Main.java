package de.ostfale.fx.sample;

import de.ostfale.fx.sample.ui.handler.MainHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        MainHandler mainHandler = new MainHandler();
        Scene scene = new Scene(mainHandler.getUiRoot(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
