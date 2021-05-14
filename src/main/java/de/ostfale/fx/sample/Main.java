package de.ostfale.fx.sample;

import de.ostfale.fx.sample.contacts.domain.Person;
import de.ostfale.fx.sample.contacts.ui.ContactsHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Person> personList = new ArrayList<>(List.of(
            new Person("Werner", "Heisenberg", "Physiker"),
            new Person("Wolfgang ", "Pauli", "Mathematiker"),
            new Person("Niels ", "Bohr", "Chemiker")
    ));

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
