package com.music.controllers;

import com.music.TemplateFx.GenresFx;
import com.music.TemplateFx.GenresModel;
import com.music.utils.DialogsUtils;
import com.music.utils.exceptions.ApplicationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class GenresListController {

    @FXML
    private TextField nameField;

    @FXML
    private Button addButton;

    @FXML
    private TableView<GenresFx> genresTableView;

    @FXML
    private TableColumn<GenresFx, String> nameColumn;

    private GenresModel genresModel;

    public void initialize() {
        this.genresModel = new GenresModel();
        try {
            this.genresModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.genresTableView.setItems(this.genresModel.getGenresList());
        this.genresModel.genresProperty().bind(this.genresTableView.getSelectionModel().selectedItemProperty());
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        initBindings();
    }

    private void initBindings() {
        this.addButton.disableProperty().bind(nameField.textProperty().isEmpty());
    }


    public void addGenresOnAction(ActionEvent actionEvent) {
        try {
            this.genresModel.saveGenresInDataBase(nameField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.nameField.clear();
    }

    public GenresModel getGenresModel() {
        return genresModel;
    }

}
