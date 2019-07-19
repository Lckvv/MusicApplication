package com.music.controllers;

import com.music.utils.DialogsUtils;
import com.music.utils.FxmlUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ListSearchController {
    
    @FXML
    private Button boyerButton;


    public void searchBoyerOnAction(ActionEvent actionEvent) {
        FXMLLoader loader = FxmlUtils.getLoader("/fxml/BoyerSearch.fxml");
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
}
