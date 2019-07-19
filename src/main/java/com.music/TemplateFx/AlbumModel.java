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
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.util.List;

public class AlbumModel {

    private ObservableList<AlbumFx> albumList = FXCollections.observableArrayList();
    private ObjectProperty<AlbumFx> albumFxObjectProperty= new SimpleObjectProperty<>(new AlbumFx());
    private ObjectProperty<AlbumFx> album = new SimpleObjectProperty<>();
    private ObservableList<BandFx> bandFxObservableList= FXCollections.observableArrayList();
    private TreeItem<String> root = new TreeItem<>();


    public void init() throws ApplicationException {
        AlbumDao albumDao = new AlbumDao();
        List<Album> albums= albumDao.queryForAll(Album.class);
        initBandList();
        initRoot(albums);
    }

    private void initRoot(List<Album> albums) {
        this.root.getChildren().clear();
        albums.forEach(c->{
            TreeItem<String> albumItem = new TreeItem<>(c.getName());
            c.getSongs().forEach(b->{
                albumItem.getChildren().add(new TreeItem<>(b.getName()));
            });
            root.getChildren().add(albumItem);
        });
    }

    private void initBandList() throws ApplicationException {
        BandDao bandDao = new BandDao();
        List<Band> bandList = bandDao.queryForAll(Band.class);
        this.bandFxObservableList.clear();
        bandList.forEach(band -> {
            BandFx bandFx = ConverterBand.convertToBandFx(band);
            this.bandFxObservableList.add(bandFx);
        });
    }

    public void saveAlbumInDataBase() throws ApplicationException {
        Album album = ConverterAlbum.convertToAlbum(this.getAlbumFxObjectProperty());

        BandDao bandDao = new BandDao();
        Band band = bandDao.findById(Band.class, this.getAlbumFxObjectProperty().getBandFx().getId());

        album.setBand(band);

        AlbumDao albumDao = new AlbumDao();
        albumDao.creatOrUpdate(album);

    }

    public void updateAlbumInDataBase() throws ApplicationException {
        AlbumDao albumDao = new AlbumDao();
        Album tempAlbum = albumDao.findById(Album.class, getAlbum().getId());
        tempAlbum.setName(getAlbum().getName());
        albumDao.creatOrUpdate(tempAlbum);
        init();
    }

    public ObservableList<AlbumFx> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(ObservableList<AlbumFx> albumList) {
        this.albumList = albumList;
    }

    public AlbumFx getAlbumFxObjectProperty() {
        return albumFxObjectProperty.get();
    }

    public ObjectProperty<AlbumFx> albumFxObjectPropertyProperty() {
        return albumFxObjectProperty;
    }

    public void setAlbumFxObjectProperty(AlbumFx albumFxObjectProperty) {
        this.albumFxObjectProperty.set(albumFxObjectProperty);
    }

    public AlbumFx getAlbum() {
        return album.get();
    }

    public ObjectProperty<AlbumFx> albumProperty() {
        return album;
    }

    public void setAlbum(AlbumFx album) {
        this.album.set(album);
    }

    public ObservableList<BandFx> getBandFxObservableList() {
        return bandFxObservableList;
    }

    public void setBandFxObservableList(ObservableList<BandFx> bandFxObservableList) {
        this.bandFxObservableList = bandFxObservableList;
    }

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}
