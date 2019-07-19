package com.music.controllers;

import com.music.TemplateFx.*;
import com.music.utils.DialogsUtils;
import com.music.utils.FxmlUtils;
import com.music.utils.exceptions.ApplicationException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MusicsController {

    private static final String SING_BOX = "/fxml/SingBox.fxml";

    @FXML
    private ComboBox genresComboBox;
    @FXML
    private ComboBox bandComboBox;
    @FXML
    private TableView<AlbumFx> albumTableView;
    @FXML
    private TableView<SongsFx> songsTableView;
    @FXML
    private TableColumn<AlbumFx, String> albumColumn;
    @FXML
    private TableColumn<SongsFx, String> songsColumn;

    @FXML
    private TableColumn<SongsFx, String> textColumn;

    @FXML
    private TableColumn<SongsFx, SongsFx> buttonColumn;

    private BandListModel bandListModel;
    private AlbumListModel albumListModel;
    private SongListModel songListModel;

    @FXML
    void initialize(){
        this.bandListModel = new BandListModel();
        try {
            this.bandListModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.albumListModel = new AlbumListModel();
        try {
            this.albumListModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.songListModel = new SongListModel();
        try {
            this.songListModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }


        this.albumTableView.setRowFactory(tv -> {
            TableRow<AlbumFx> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty())){
                    this.songListModel.filterSongsList();
                }
            });
            return row;
        });

        this.buttonColumn.setCellFactory(param -> new TableCell<SongsFx, SongsFx>() {
            Button button = createButton("/icons/Add.png");

            @Override
            protected void updateItem(SongsFx item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    return;
                }

                if (!empty) {
                    setGraphic(button);
                    button.setOnAction(event -> {
                        FXMLLoader loader = FxmlUtils.getLoader("/fxml/SingBox.fxml");
                        Scene scene = null;
                        try {
                            scene = new Scene(loader.load());
                        } catch (IOException e) {
                            DialogsUtils.errorDialog(e.getMessage());
                        }
                        SingBoxController controller = loader.getController();
                        controller.getTextModel().setSongFxObjectProperty(item);
                        controller.bindings();
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.showAndWait();
                    });
                }
            }
        });

        bandComboBox.setDisable(true);
        textColumn.setVisible(false);

        //  Ustawienie Bazy w kontrolkach

        this.genresComboBox.setItems(this.bandListModel.getGenresFxObservableList());
        this.bandComboBox.setItems(this.bandListModel.getBandFxObservableList());

        //Przypięcie wartości
        this.bandListModel.genresFxObjectPropertyProperty().bind(this.genresComboBox.valueProperty());
        this.albumListModel.bandFxObjectPropertyProperty().bind(this.bandComboBox.valueProperty());
        this.songListModel.albumFxObjectPropertyProperty().bind(this.albumTableView.getSelectionModel().selectedItemProperty());

        // Ustawienie podanych wartosci

        this.albumTableView.setItems(this.albumListModel.getAlbumFxObservableList());
        this.songsTableView.setItems(this.songListModel.getSongsFxObservableList());


        this.albumColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.songsColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.textColumn.setCellValueFactory(cellData -> cellData.getValue().texttProperty());
        this.buttonColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

    }
    public void genresOnAction(ActionEvent actionEvent) {
        this.bandListModel.filterBandList();
        this.bandComboBox.setDisable(false);
    }

    public void bandOnAction(ActionEvent actionEvent) {
        this.albumListModel.filterAlbumList();

    }

    private Button createButton(String path) {
        Button button = new Button();
        Image image = new Image(this.getClass().getResource(path).toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return button;
    }

}
