package com.music.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {
    private static final String LIST_MUSICS = "/fxml/ListMusics.fxml";
    private static final String ADD_MUSICS = "/fxml/AddMusics.fxml";
    private static final String LIST_SEARCH = "/fxml/ListSearch.fxml";
//    private static final String LIST_LOGS = "/fxml/ListLogs.fxml";

    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openListMusics() {
        mainController.setCenter(LIST_MUSICS);
    }

    @FXML
    public void addMusics() {
        mainController.setCenter(ADD_MUSICS);
    }

    @FXML
    public void openListSearch() {
        mainController.setCenter(LIST_SEARCH);
    }
//
//    @FXML
//    public void openListLogs() {
//        mainController.setCenter(LIST_LOGS);
//    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    private void resetToggleButtons() {
        if(toggleButtons.getSelectedToggle()!=null){
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }

    public void addMusics(ActionEvent actionEvent) {
        resetToggleButtons();
        mainController.setCenter(ADD_MUSICS);
    }

    public void openListSearch(ActionEvent actionEvent) {
        resetToggleButtons();
        mainController.setCenter(LIST_SEARCH);
    }

    public void openListLogs(ActionEvent actionEvent) {
    }
}
