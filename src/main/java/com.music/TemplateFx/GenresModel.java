package com.music.TemplateFx;


import com.music.database.dao.BandDao;
import com.music.database.dao.GenresDao;
import com.music.database.models.Band;
import com.music.database.models.Genres;
import com.music.utils.converters.ConverterGenres;
import com.music.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.sql.SQLException;
import java.util.List;

public class GenresModel {
    private ObservableList<GenresFx> genresList = FXCollections.observableArrayList();
    private ObjectProperty<GenresFx> genres = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();

    public void init() throws ApplicationException {
        GenresDao genresDao = new GenresDao();
        List<Genres> genres= genresDao.queryForAll(Genres.class);
        initGenresList(genres);
        initRoot(genres);
    }

    private void initRoot(List<Genres> genres) {
        this.root.getChildren().clear();
        genres.forEach(c->{
            TreeItem<String> genresItem = new TreeItem<>(c.getName());
            c.getBands().forEach(b->{
                genresItem.getChildren().add(new TreeItem<>(b.getName()));
            });
            root.getChildren().add(genresItem);
        });
    }

    private void initGenresList(List<Genres> genres) {
        this.genresList.clear();
        genres.forEach(c -> {
            GenresFx genresFx = ConverterGenres.convertToGenresFx(c);
            this.genresList.add(genresFx);
        });
    }

    public void deleteGenresById() throws ApplicationException, SQLException {
        GenresDao genresDao = new GenresDao();
        genresDao.deleteById(Genres.class, genres.getValue().getId());
        BandDao bandDao = new BandDao();
        bandDao.deleteByColumnName(Band.Genres_Id, genres.getValue().getId());
        init();
    }


    public void saveGenresInDataBase(String name) throws ApplicationException {
        GenresDao genresDao = new GenresDao();
        Genres genres = new Genres();
        genres.setName(name);
        genresDao.creatOrUpdate(genres);
        init();
    }

    public void updateGenresInDataBase() throws ApplicationException {
        GenresDao genresDao = new GenresDao();
        Genres tempGenres = genresDao.findById(Genres.class, getGenres().getId());
        tempGenres.setName(getGenres().getName());
        genresDao.creatOrUpdate(tempGenres);
        init();
    }


    public ObservableList<GenresFx> getGenresList() {
        return genresList;
    }

    public void setGenresList(ObservableList<GenresFx> genresList) {
        this.genresList = genresList;
    }

    public GenresFx getGenres() {
        return genres.get();
    }

    public ObjectProperty<GenresFx> genresProperty() {
        return genres;
    }

    public void setGenres(GenresFx genres) {
        this.genres.set(genres);
    }

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}

