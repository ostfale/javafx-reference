package de.ostfale.fx.sample.contacts.ui;

import de.ostfale.fx.sample.Main;
import de.ostfale.fx.sample.common.BaseController;
import de.ostfale.fx.sample.contacts.domain.Person;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class ContactsController extends BaseController<Person> implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(ContactsController.class);

    @FXML
    private ListView<Person> lst_person;

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_delete;

    @FXML
    private TextField tf_firstName;

    @FXML
    private TextField tf_lastName;

    @FXML
    private TextArea ta_note;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonBinding();
        setChangeListener(personChangeListener);
        updateModel(FXCollections.observableList(Main.personList), lst_person);
    }

    @FXML
    private void handleKeyAction() {
        modifiedProperty.set(true);
    }

    @FXML
    void closeApplication() {
        Platform.exit();
    }

    @FXML
    void createContact(ActionEvent event) {
        Person person = new Person(tf_firstName.getText(), tf_lastName.getText(), ta_note.getText());
        dataModel.getObjectList().add(person);
    }

    @FXML
    void deleteContact(ActionEvent event) {
        dataModel.getObjectList().remove(dataModel.getCurrentObject());
    }

    @FXML
    void updateContact(ActionEvent event) {
      var person=  dataModel.getCurrentObject();
      person.setFirstName(tf_firstName.getText());
      person.setLastName(tf_lastName.getText());
      person.setNote(ta_note.getText());
    }

    @Override
    protected Comparator<Person> getComparator() {
        return (p1, p2) -> {
            int result = p1.getLastName().compareToIgnoreCase(p2.getLastName());
            if (result == 0) {
                result = p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
            }
            return result;
        };
    }

    private void buttonBinding() {
        btn_delete.disableProperty().bind(lst_person.getSelectionModel().selectedItemProperty().isNull());
        btn_new.disableProperty().bind(
                lst_person.getSelectionModel().selectedItemProperty().isNotNull()
                        .or(tf_firstName.textProperty().isEmpty())
                        .or(tf_lastName.textProperty().isEmpty())
        );
        btn_update.disableProperty().bind(lst_person.getSelectionModel().selectedItemProperty().isNull()
                .or(modifiedProperty.not())
                .or(tf_firstName.textProperty().isEmpty())
                .or(tf_lastName.textProperty().isEmpty())
                .or(ta_note.textProperty().isEmpty()));
    }

    private final ChangeListener<Person> personChangeListener = (obs, oldPerson, newPerson) -> {
        modifiedProperty.set(false);
        if (oldPerson != null) {
            log.info("Old person: {}", newPerson);
            tf_firstName.textProperty().unbindBidirectional(oldPerson.firstNameProperty());
            tf_lastName.textProperty().unbindBidirectional(oldPerson.lastNameProperty());
            ta_note.textProperty().unbindBidirectional(oldPerson.noteProperty());
        }

        if (newPerson == null) {
            tf_firstName.clear();
            tf_lastName.clear();
            ta_note.clear();
        } else {
            log.info("New person: {}", newPerson);
            tf_firstName.textProperty().bindBidirectional(newPerson.firstNameProperty());
            tf_lastName.textProperty().bindBidirectional(newPerson.lastNameProperty());
            ta_note.textProperty().bindBidirectional(newPerson.noteProperty());
        }
    };
}
