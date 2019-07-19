package com.music.TemplateFx;

import com.music.database.dao.AlbumDao;
import com.music.database.dao.BandDao;
import com.music.database.dao.SongsDao;
import com.music.database.models.Album;
import com.music.database.models.Band;
import com.music.database.models.Songs;
import com.music.utils.converters.ConverterAlbum;
import com.music.utils.converters.ConverterSongs;
import com.music.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.util.List;

public class SongsModel {

        private ObservableList<SongsFx> songList = FXCollections.observableArrayList();
        private ObjectProperty<SongsFx> songFxObjectProperty = new SimpleObjectProperty<>(new SongsFx());
        private ObjectProperty<SongsFx> song = new SimpleObjectProperty<>();
        private ObservableList<AlbumFx> albumFxObservableList = FXCollections.observableArrayList();
        private TreeItem<String> root = new TreeItem<>();


        public void init() throws ApplicationException {
            SongsDao songsDao = new SongsDao();
            List<Songs> songs = songsDao.queryForAll(Songs.class);
            initAlbumList();
        }


    private void initAlbumList() throws ApplicationException {
        AlbumDao albumDao = new AlbumDao();
        List<Album> albumList = albumDao.queryForAll(Album.class);
        this.albumFxObservableList.clear();
        albumList.forEach(album -> {
            AlbumFx albumFx = ConverterAlbum.convertToAlbumFx(album);
            this.albumFxObservableList.add(albumFx);
        });
    }

        public void saveSongInDataBase(String name) throws ApplicationException {
        Songs songs = ConverterSongs.convertToSongs(this.getSongFxObjectProperty());

        AlbumDao albumDao = new AlbumDao();
        Album album = albumDao.findById(Album.class, this.getSongFxObjectProperty().getAlbumFx().getId());

        songs.setAlbum(album);

        SongsDao songsDao = new SongsDao();
        songsDao.creatOrUpdate(songs);

    }
    public void saveSongInDataBase() throws ApplicationException {
        Songs songs = ConverterSongs.convertToSongs(this.getSongFxObjectProperty());

        AlbumDao albumDao = new AlbumDao();
        Album album = albumDao.findById(Album.class, this.getSongFxObjectProperty().getAlbumFx().getId());

        songs.setAlbum(album);

        SongsDao songsDao = new SongsDao();
        songsDao.creatOrUpdate(songs);

    }

        public void updateSongsInDataBase() throws ApplicationException {
            SongsDao songsDao = new SongsDao();
            Songs tempSongs= songsDao.findById(Songs.class, getSong().getId());
            tempSongs.setName(getSong().getName());
            songsDao.creatOrUpdate(tempSongs);
            init();
        }

        public ObservableList<SongsFx> getSongList() {
            return songList;
        }

        public void setSongList(ObservableList<SongsFx> songList) {
            this.songList = songList;
        }

        public SongsFx getSongFxObjectProperty() {
            return songFxObjectProperty.get();
        }

        public ObjectProperty<SongsFx> songFxObjectPropertyProperty() {
            return songFxObjectProperty;
        }

        public void setSongFxObjectProperty(SongsFx songFxObjectProperty) {
            this.songFxObjectProperty.set(songFxObjectProperty);
        }

        public SongsFx getSong() {
            return song.get();
        }

        public ObjectProperty<SongsFx> songProperty() {
            return song;
        }

        public void setSong(SongsFx song) {
            this.song.set(song);
        }

        public ObservableList<AlbumFx> getAlbumFxObservableList() {
            return albumFxObservableList;
        }

        public void setAlbumFxObservableList(ObservableList<AlbumFx> albumFxObservableList) {
            this.albumFxObservableList = albumFxObservableList;
        }

        public TreeItem<String> getRoot() {
            return root;
        }

        public void setRoot(TreeItem<String> root) {
            this.root = root;
        }
    }
