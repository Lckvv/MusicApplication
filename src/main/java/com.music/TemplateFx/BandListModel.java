package com.music.TemplateFx;

import com.music.database.dao.BandDao;
import com.music.database.dao.GenresDao;
import com.music.database.models.Band;
import com.music.database.models.Genres;
import com.music.utils.converters.ConverterBand;
import com.music.utils.converters.ConverterGenres;
import com.music.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BandListModel {

    private ObservableList<GenresFx> genresFxObservableList = FXCollections.observableArrayList();
    private ObservableList<BandFx> bandFxObservableList= FXCollections.observableArrayList();

    private ObjectProperty<GenresFx> genresFxObjectProperty = new SimpleObjectProperty<>();

    private List<BandFx> bandFxList = new ArrayList<>();
    public void init() throws ApplicationException {
        BandDao bandDao = new BandDao();
        List<Band> bands = bandDao.queryForAll(Band.class);
        bandFxList.clear();
        bands.forEach(band -> {
            this.bandFxList.add(ConverterBand.convertToBandFx(band));
        });
        this.bandFxObservableList.setAll(bandFxList);

        initGenres();
    }

    public void filterBandList() {
        if (getGenresFxObjectProperty() != null) {
            filterPredicate(predicateGenres());
        } else {
            this.bandFxObservableList.setAll(this.bandFxList);
        }
    }

    public void deleteBand(BandFx bandFx) throws ApplicationException {
        BandDao bandDao = new BandDao();
        bandDao.deleteById(Band.class, bandFx.getId());
        init();
    }

    private void initGenres() throws ApplicationException {
        GenresDao genresDao = new GenresDao();
        List<Genres> genresList = genresDao.queryForAll(Genres.class);
        this.genresFxObservableList.clear();
        genresList.forEach(genres -> {
            GenresFx genresFx = ConverterGenres.convertToGenresFx(genres);
            this.genresFxObservableList.add(genresFx);
        });
    }

    private Predicate<BandFx> predicateGenres() {
        return bandFx -> bandFx.getGenresFx().getId() == getGenresFxObjectProperty().getId();
    }

    private void filterPredicate(Predicate<BandFx> predicate) {
        List<BandFx> newList = bandFxList.stream().filter(predicate).collect(Collectors.toList());
        this.bandFxObservableList.setAll(newList);
    }

    public ObservableList<BandFx> getBandFxObservableList() {
        return bandFxObservableList;
    }

    public void setBandFxObservableList(ObservableList<BandFx> bandFxObservableList) {
        this.bandFxObservableList = bandFxObservableList;
    }

    public ObservableList<GenresFx> getGenresFxObservableList() {
        return genresFxObservableList;
    }

    public void setGenresFxObservableList(ObservableList<GenresFx> genresFxObservableList) {
        this.genresFxObservableList = genresFxObservableList;
    }


    public GenresFx getGenresFxObjectProperty() {
        return genresFxObjectProperty.get();
    }

    public ObjectProperty<GenresFx> genresFxObjectPropertyProperty() {
        return genresFxObjectProperty;
    }

    public void setGenresFxObjectProperty(GenresFx genresFxObjectProperty) {
        this.genresFxObjectProperty.set(genresFxObjectProperty);
    }

}
