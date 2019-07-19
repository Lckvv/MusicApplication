package com.music.controllers;

import com.music.TemplateFx.*;
import com.music.utils.DialogsUtils;
import com.music.utils.FxmlUtils;
import com.music.utils.exceptions.ApplicationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMusicsContoller {

    @FXML
    private ComboBox<GenresFx> genresComboBox;

    @FXML
    private ComboBox<BandFx> bandComboBox;

    @FXML
    private ComboBox<AlbumFx> albumComboBox;

    @FXML
    private TextField songTextField;

    @FXML
    private TextArea textArea;

    @FXML
    private Button genresButton;

    @FXML
    private Button saveButton;

    private BandModel bandModel;
    private AlbumModel albumModel;
    private SongsModel songsModel;

    Image image = new Image(getClass().getResourceAsStream("/icons/add.png"));
    ImageView imageView = new ImageView(image);

    @FXML
    public void initialize() {
        this.bandModel = new BandModel();
        try {
            this.bandModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.albumModel = new AlbumModel();
        try {
            this.albumModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.songsModel = new SongsModel();
        try {
            this.songsModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        bindings();
        validation();


    }

    private void validation() {
        this.saveButton.disableProperty().bind(this.albumComboBox.valueProperty().isNull()
                .or(this.songTextField.textProperty().isEmpty())
                .or(this.textArea.textProperty().isEmpty()));

    }

    public void bindings() {
        this.genresComboBox.setItems(this.bandModel.getGenresFxObservableList());
        this.bandComboBox.setItems(this.albumModel.getBandFxObservableList());
        this.albumComboBox.setItems(this.songsModel.getAlbumFxObservableList());

        this.albumComboBox.valueProperty().bindBidirectional(this.songsModel.getSongFxObjectProperty().albumFxProperty());
        this.songTextField.textProperty().bindBidirectional(this.songsModel.getSongFxObjectProperty().nameProperty());
        this.textArea.textProperty().bindBidirectional(this.songsModel.getSongFxObjectProperty().texttProperty());

    }


    private void setScenes(){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
    public void updateGenres(ActionEvent actionEvent) {
        FXMLLoader loader = FxmlUtils.getLoader("/fxml/GenresList.fxml");
        setScenes();
    }


    public void updateBand(ActionEvent actionEvent) {
        FXMLLoader loader = FxmlUtils.getLoader("/fxml/BandList.fxml");
        setScenes();
    }

    public void updateAlbum(ActionEvent actionEvent) {
        FXMLLoader loader = FxmlUtils.getLoader("/fxml/AlbumList.fxml");
        setScenes();
    }

    public void saveOnAction(ActionEvent actionEvent) {
        try {
            this.songsModel.saveSongInDataBase();
            clearFields();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    private void clearFields() {
        this.genresComboBox.getSelectionModel().clearSelection();
        this.bandComboBox.getSelectionModel().clearSelection();
        this.albumComboBox.getSelectionModel().clearSelection();
        this.songTextField.clear();
        this.textArea.clear();

    }
    public SongsModel getSongsModel() {
        return songsModel;
    }
}
