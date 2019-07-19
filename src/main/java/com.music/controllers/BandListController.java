package com.music.controllers;

import com.music.TemplateFx.*;
import com.music.utils.DialogsUtils;
import com.music.utils.exceptions.ApplicationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BandListController {

    @FXML
    private Button addButton;

    @FXML
    private ComboBox<GenresFx> genresComboBox;

    @FXML
    private TextField bandField;

    @FXML
    private TableView<BandFx> bandTableView;

    @FXML
    private TableColumn<BandFx, String> bandColumn;

    private BandModel bandModel;
    private BandListModel bandListModel;

    @FXML
    public void initialize() {
        this.bandModel = new BandModel();
        this.bandListModel = new BandListModel();
        try {
            this.bandListModel.init();
            this.bandModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.bandTableView.setItems(this.bandListModel.getBandFxObservableList());
        this.bandModel.bandProperty().bind(this.bandTableView.getSelectionModel().selectedItemProperty());
        this.bandColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        bindings();
        validation();
    }

    private void validation() {
        this.addButton.disableProperty().bind(this.genresComboBox.valueProperty().isNull()
                .or(this.bandField.textProperty().isEmpty()));
    }

    public void bindings() {
        this.genresComboBox.setItems(this.bandModel.getGenresFxObservableList());

        this.genresComboBox.valueProperty().bindBidirectional(this.bandModel.getBandFxObjectProperty().genresFxProperty());
        this.bandField.textProperty().bindBidirectional(this.bandModel.getBandFxObjectProperty().nameProperty());
    }




    private void clearFields() {
        this.genresComboBox.getSelectionModel().clearSelection();
        this.bandField.clear();
    }

    public void addBandOnAction(ActionEvent actionEvent) {
        try {
            this.bandModel.saveBandInDataBase();
            bandListModel.init();
            clearFields();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    public BandModel getBandModel() {
        return bandModel;
    }

}
