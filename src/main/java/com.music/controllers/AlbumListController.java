package com.music.controllers;

import com.music.TemplateFx.*;
import com.music.utils.DialogsUtils;
import com.music.utils.exceptions.ApplicationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AlbumListController {
    @FXML
    private Button addButton;

    @FXML
    private ComboBox<BandFx> bandComboBox;

    @FXML
    private TextField albumField;

    @FXML
    private TableView<AlbumFx> albumTableView;

    @FXML
    private TableColumn<AlbumFx, String> albumColumn;

    private AlbumModel albumModel;
    private AlbumListModel albumListModel;

    @FXML
    public void initialize() {
        this.albumModel = new AlbumModel();
        this.albumListModel = new AlbumListModel();
        try {
            this.albumListModel.init();
            this.albumModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.albumTableView.setItems(this.albumListModel.getAlbumFxObservableList());
        this.albumModel.albumProperty().bind(this.albumTableView.getSelectionModel().selectedItemProperty());
        this.albumListModel.bandFxObjectPropertyProperty().bind(this.bandComboBox.valueProperty());
        this.albumColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        bindings();
        validation();
    }

    private void validation() {
        this.addButton.disableProperty().bind(this.bandComboBox.valueProperty().isNull()
                .or(this.albumField.textProperty().isEmpty()));
    }

    public void bindings() {
        this.bandComboBox.setItems(this.albumModel.getBandFxObservableList());

        this.bandComboBox.valueProperty().bindBidirectional(this.albumModel.getAlbumFxObjectProperty().bandFxProperty());
        this.albumField.textProperty().bindBidirectional(this.albumModel.getAlbumFxObjectProperty().nameProperty());
    }




    private void clearFields() {
        this.bandComboBox.getSelectionModel().clearSelection();
        this.albumField.clear();
    }

    public void addAlbumOnAction(ActionEvent actionEvent) {
        try {
            this.albumModel.saveAlbumInDataBase();
            albumListModel.init();
            clearFields();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }
    public AlbumModel getAlbumModel(){return albumModel;}

    public void bandOnAction(ActionEvent actionEvent) {
        this.albumListModel.filterAlbumList();
    }
}
