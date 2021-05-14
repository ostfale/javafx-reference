package de.ostfale.fx.sample.common;

import javafx.fxml.FXMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

abstract public class BaseHandler<T, U> {

    private static final Logger log = LoggerFactory.getLogger(BaseHandler.class);

    // create resource bundle
    private final String resourcePath = "bundles.main";
    ResourceBundle resourceBundle = ResourceBundle.getBundle(resourcePath);

    protected T uiController;
    protected U uiRoot;

    private final FXMLLoader fxmlLoader = new FXMLLoader();

    protected abstract String getFXMLPath();

    public T getUiController() {
        return uiController;
    }

    public U getUiRoot() {
        return uiRoot;
    }

    protected void initHandler() {
        final URL resource = ClassLoader.getSystemResource(getFXMLPath());
        fxmlLoader.setLocation(resource);
        fxmlLoader.setResources(resourceBundle);

        try {
            uiRoot = fxmlLoader.load();
            uiController = fxmlLoader.getController();
        } catch (IOException e) {
            log.error("Could not load fxml resources from path: {}", getFXMLPath());
        }
    }
}
