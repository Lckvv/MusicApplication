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
import javafx.scene.control.TreeItem;
import java.util.List;

public class BandModel {
    private ObservableList<BandFx> bandList = FXCollections.observableArrayList();
    private ObjectProperty<BandFx> bandFxObjectProperty = new SimpleObjectProperty<>(new BandFx());
    private ObjectProperty<BandFx> band = new SimpleObjectProperty<>();
    private ObservableList<GenresFx> genresFxObservableList = FXCollections.observableArrayList();
    private TreeItem<String> root = new TreeItem<>();

    public void init() throws ApplicationException {
        BandDao bandDao = new BandDao();
        List<Band> bands= bandDao.queryForAll(Band.class);
        initGenresList();
        initRoot(bands);
    }

    private void initRoot(List<Band> bands) {
        this.root.getChildren().clear();
        bands.forEach(c->{
            TreeItem<String> bandItem = new TreeItem<>(c.getName());
            c.getAlbums().forEach(b->{
                bandItem.getChildren().add(new TreeItem<>(b.getName()));
            });
            root.getChildren().add(bandItem);
        });
    }

    private void initBandList(List<Band> band) {
        this.bandList.clear();
        band.forEach(c -> {
            BandFx bandFx = ConverterBand.convertToBandFx(c);
            this.bandList.add(bandFx);
        });
    }

    private void initGenresList() throws ApplicationException {
        GenresDao genresDao = new GenresDao();
        List<Genres> genresList = genresDao.queryForAll(Genres.class);
        this.genresFxObservableList.clear();
        genresList.forEach(genres -> {
            GenresFx genresFx = ConverterGenres.convertToGenresFx(genres);
            this.genresFxObservableList.add(genresFx);
        });
    }

    public void saveBandInDataBase() throws ApplicationException {
        Band band = ConverterBand.convertToBand(this.getBandFxObjectProperty());

        GenresDao genresDao = new GenresDao();
        Genres genres = genresDao.findById(Genres.class, this.getBandFxObjectProperty().getGenresFx().getId());

        band.setGenres(genres);

        BandDao bandDao = new BandDao();
        bandDao.creatOrUpdate(band);

    }

    public BandFx getBandFxObjectProperty() {
        return bandFxObjectProperty.get();
    }



    public void saveBandInDataBase(String name) throws ApplicationException {
        Band band = ConverterBand.convertToBand(this.getBandFxObjectProperty());

        GenresDao genresDao = new GenresDao();
        Genres genres = genresDao.findById(Genres.class, this.getBandFxObjectProperty().getGenresFx().getId());

        band.setGenres(genres);

        BandDao bandDao = new BandDao();
        bandDao.creatOrUpdate(band);

    }

    public void updateBandInDataBase() throws ApplicationException {
        BandDao bandDao = new BandDao();
        Band tempBand = bandDao.findById(Band.class, getBand().getId());
        tempBand.setName(getBand().getName());
        bandDao.creatOrUpdate(tempBand);
        init();
    }

    public ObservableList<BandFx> getBandList() {
        return bandList;
    }

    public void setBandList(ObservableList<BandFx> bandList) {
        this.bandList = bandList;
    }

    public BandFx getBandFxObjectPropertyBandFx() {
        return bandFxObjectProperty.get();
    }

    public ObjectProperty<BandFx> bandFxObjectPropertyProperty() {
        return bandFxObjectProperty;
    }

    public void setBandFxObjectProperty(BandFx bandFxObjectProperty) {
        this.bandFxObjectProperty.set(bandFxObjectProperty);
    }

    public BandFx getBand() {
        return band.get();
    }

    public ObjectProperty<BandFx> bandProperty() {
        return band;
    }

    public void setBand(BandFx band) {
        this.band.set(band);
    }

    public ObservableList<GenresFx> getGenresFxObservableList() {
        return genresFxObservableList;
    }

    public void setGenresFxObservableList(ObservableList<GenresFx> genresFxObservableList) {
        this.genresFxObservableList = genresFxObservableList;
    }

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}
