package de.ostfale.fx.sample.contacts.ui;

import de.ostfale.fx.sample.contacts.domain.Person;
import de.ostfale.fx.sample.common.BaseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactsController extends BaseController<Person> implements Initializable {

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_delete;

    @FXML
    void createContact(ActionEvent event) {

    }

    @FXML
    void deleteContact(ActionEvent event) {

    }

    @FXML
    void updateContact(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
