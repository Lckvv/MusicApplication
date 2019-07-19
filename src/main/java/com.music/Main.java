package com.music;

import com.music.database.dbRun.DbManager;
import com.music.utils.FillDatabase;
import com.music.utils.FxmlUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application{
    private static final String MAIN_FXML = "/fxml/Main.fxml";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane borderPane = FxmlUtils.fxmlLoader(MAIN_FXML);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("tittle.application"));
        primaryStage.show();
        DbManager.initDatabase();
        FillDatabase.fillDatabase(); // w tym miejscu uruchamiam dodatkowy kod, który wypełnia bazę danych

    }
}



