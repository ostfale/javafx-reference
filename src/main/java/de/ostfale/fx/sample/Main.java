package de.ostfale.fx.sample;

import de.ostfale.fx.sample.contacts.ui.ContactsHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        ContactsHandler contactsHandler = new ContactsHandler();
        Scene scene = new Scene(contactsHandler.getUiRoot(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
