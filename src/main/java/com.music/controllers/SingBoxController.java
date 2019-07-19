package com.music.controllers;

import com.music.TemplateFx.SongsModel;
import com.music.utils.DialogsUtils;
import com.music.utils.exceptions.ApplicationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SingBoxController implements Initializable{

    @FXML
    private TextFlow text;

    @FXML
    private Text TextData;

    SongsModel songsModel = new SongsModel();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.songsModel = new SongsModel();
        try {
            this.songsModel.init();
        }catch (ApplicationException e){
            DialogsUtils.errorDialog(e.getMessage());
        }
        bindings();

    }

    public void bindings(){

       this.TextData.textProperty().bindBidirectional(this.songsModel.getSongFxObjectProperty().texttProperty());
    }

    public SongsModel getTextModel(){
        return songsModel;
    }

    @FXML
    public void Ok(ActionEvent actionEvent) {

        Stage stage = (Stage) text.getScene().getWindow();
        stage.close();
    }
}
