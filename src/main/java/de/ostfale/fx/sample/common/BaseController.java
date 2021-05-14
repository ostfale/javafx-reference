package de.ostfale.fx.sample.common;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.Comparator;

public class BaseController<T> {

    protected DataModel<T> dataModel;
    protected BooleanProperty modifiedProperty = new SimpleBooleanProperty(false);
    private ChangeListener<T> changeListener;

    private DataModel<T> initDataModel(ReadOnlyObjectProperty<T> selectedItemProperty) {
        DataModel<T> dm = new DataModel<>();
        dm.currentObjectProperty().bind(selectedItemProperty);

        if (changeListener != null) {
            dm.currentObjectProperty().addListener(changeListener);
        }
        return dm;
    }

    protected void updateModel(ObservableList<T> list, ListView<T> control) {
        if (dataModel == null) {
            dataModel = initDataModel(control.getSelectionModel().selectedItemProperty());
            if (getComparator() != null) {
                control.setItems(dataModel.getSortedList(getComparator()));
            } else {
                control.setItems(dataModel.getObjectList());
            }
        }
        dataModel.setObjectList(list);
    }

    protected void updateModel(ObservableList<T> list, ComboBox<T> control) {
        if (dataModel == null) {
            dataModel = initDataModel(control.getSelectionModel().selectedItemProperty());
            if (getComparator() != null) {
                control.setItems(dataModel.getSortedList(getComparator()));
            } else {
                control.setItems(dataModel.getObjectList());
            }
        }
        dataModel.setObjectList(list);
    }

    protected Comparator<T> getComparator() {
        return null;
    }

    protected void setChangeListener(ChangeListener<T> changeListener) {
        this.changeListener = changeListener;
    }
}
