package com.music.TemplateFx;

import com.music.database.dao.AlbumDao;
import com.music.database.dao.BandDao;
import com.music.database.dao.GenresDao;
import com.music.database.models.Album;
import com.music.database.models.Band;
import com.music.database.models.Genres;
import com.music.utils.converters.ConverterAlbum;
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

public class AlbumListModel {
    private ObservableList<AlbumFx> albumFxObservableList= FXCollections.observableArrayList();
    private ObservableList<BandFx> bandFxObservableList= FXCollections.observableArrayList();

    private ObjectProperty<BandFx> bandFxObjectProperty = new SimpleObjectProperty<>();

    private List<AlbumFx> albumFxList = new ArrayList<>();
    public void init() throws ApplicationException {
        AlbumDao albumDao = new AlbumDao();
        List<Album> albums = albumDao.queryForAll(Album.class);
        albumFxList.clear();
        albums.forEach(album -> {
            this.albumFxList.add(ConverterAlbum.convertToAlbumFx(album));
        });
        this.albumFxObservableList.setAll(albumFxList);

        initBand();
    }

    public void filterAlbumList() {
        if (getBandFxObjectProperty() != null) {
            filterPredicate(predicateBand());
        } else {
            this.albumFxObservableList.setAll(this.albumFxList);
        }
    }

    public void deleteAlbum(AlbumFx albumFx) throws ApplicationException {
        AlbumDao albumDao = new AlbumDao();
        albumDao.deleteById(Band.class, albumFx.getId());
        init();
    }

    private void initBand() throws ApplicationException {
        BandDao bandDao = new BandDao();
        List<Band> bandList = bandDao.queryForAll(Band.class);
        this.bandFxObservableList.clear();
        bandList.forEach(band -> {
            BandFx bandFx = ConverterBand.convertToBandFx(band);
            this.bandFxObservableList.add(bandFx);
        });
    }

    private Predicate<AlbumFx> predicateBand() {
        return albumFx -> albumFx.getBandFx().getId() == getBandFxObjectProperty().getId();
    }

    private void filterPredicate(Predicate<AlbumFx> predicate) {
        List<AlbumFx> newList = albumFxList.stream().filter(predicate).collect(Collectors.toList());
        this.albumFxObservableList.setAll(newList);
    }

    public ObservableList<AlbumFx> getAlbumFxObservableList() {
        return albumFxObservableList;
    }

    public void setAlbumFxObservableList(ObservableList<AlbumFx> albumFxObservableList) {
        this.albumFxObservableList = albumFxObservableList;
    }

    public ObservableList<BandFx> getBandFxObservableList() {
        return bandFxObservableList;
    }

    public void setBandFxObservableList(ObservableList<BandFx> bandFxObservableList) {
        this.bandFxObservableList = bandFxObservableList;
    }

    public BandFx getBandFxObjectProperty() {
        return bandFxObjectProperty.get();
    }

    public ObjectProperty<BandFx> bandFxObjectPropertyProperty() {
        return bandFxObjectProperty;
    }

    public void setBandFxObjectProperty(BandFx bandFxObjectProperty) {
        this.bandFxObjectProperty.set(bandFxObjectProperty);
    }
}
