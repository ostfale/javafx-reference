package de.ostfale.fx.sample.ui.handler;

import de.ostfale.fx.sample.ui.BaseHandler;
import de.ostfale.fx.sample.ui.controller.MainController;
import javafx.scene.layout.AnchorPane;

public class MainHandler extends BaseHandler<MainController, AnchorPane> {

    public MainHandler() {
        initHandler();
        uiController = getUiController();
        uiRoot = getUiRoot();
    }

    @Override
    protected String getFXMLPath() {
        return "fxml/main.fxml";
    }
}
