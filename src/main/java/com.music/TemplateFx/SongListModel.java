package com.music.TemplateFx;

import com.music.database.dao.AlbumDao;
import com.music.database.dao.BandDao;
import com.music.database.dao.SongsDao;
import com.music.database.models.Album;
import com.music.database.models.Band;
import com.music.database.models.Songs;
import com.music.utils.converters.ConverterAlbum;
import com.music.utils.converters.ConverterBand;
import com.music.utils.converters.ConverterSongs;
import com.music.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SongListModel {

    private ObservableList<AlbumFx> albumFxObservableList= FXCollections.observableArrayList();
    private ObservableList<SongsFx> songsFxObservableList= FXCollections.observableArrayList();

    private ObjectProperty<AlbumFx> albumFxObjectProperty = new SimpleObjectProperty<>();

    private List<SongsFx> songsFxList= new ArrayList<>();

    public void init() throws ApplicationException {
        SongsDao songsDao = new SongsDao();
        List<Songs> songs = songsDao.queryForAll(Songs.class);
        songsFxList.clear();
        songs.forEach(song -> {
            this.songsFxList.add(ConverterSongs.convertToSongsFx(song));
        });
        this.songsFxObservableList.setAll(songsFxList);

        initAlbum();
    }

    public void filterSongsList() {
        if (getAlbumFxObjectProperty() != null) {
            filterPredicate(predicateAlbum());
        } else {
            this.songsFxObservableList.setAll(this.songsFxList);
        }
    }

    public void deleteSongs(SongsFx songsFx) throws ApplicationException {
        SongsDao songsDao = new SongsDao();
        songsDao.deleteById(Songs.class, songsFx.getId());
        init();
    }

    private void initAlbum() throws ApplicationException {
        AlbumDao albumDao = new AlbumDao();
        List<Album> albumList = albumDao.queryForAll(Album.class);
        this.albumFxObservableList.clear();
        albumList.forEach(album -> {
            AlbumFx albumFx = ConverterAlbum.convertToAlbumFx(album);
            this.albumFxObservableList.add(albumFx);
        });
    }

    private Predicate<SongsFx> predicateAlbum() {
        return songsFx -> songsFx.getAlbumFx().getId() == getAlbumFxObjectProperty().getId();
    }

    private void filterPredicate(Predicate<SongsFx> predicate) {
        List<SongsFx> newList = songsFxList.stream().filter(predicate).collect(Collectors.toList());
        this.songsFxObservableList.setAll(newList);
    }

    public ObservableList<AlbumFx> getAlbumFxObservableList() {
        return albumFxObservableList;
    }

    public void setAlbumFxObservableList(ObservableList<AlbumFx> albumFxObservableList) {
        this.albumFxObservableList = albumFxObservableList;
    }

    public ObservableList<SongsFx> getSongsFxObservableList() {
        return songsFxObservableList;
    }

    public void setSongsFxObservableList(ObservableList<SongsFx> songsFxObservableList) {
        this.songsFxObservableList = songsFxObservableList;
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
}
