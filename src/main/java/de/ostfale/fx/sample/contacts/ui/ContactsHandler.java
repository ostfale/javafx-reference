package de.ostfale.fx.sample.contacts.ui;

import de.ostfale.fx.sample.common.BaseHandler;
import javafx.scene.layout.VBox;

public class ContactsHandler extends BaseHandler<ContactsController, VBox> {

    private static final String fxmlPath = "fxml/contacts.fxml";

    public ContactsHandler() {
        initHandler();
    }

    @Override
    protected String getFXMLPath() {
        return fxmlPath;
    }
}
