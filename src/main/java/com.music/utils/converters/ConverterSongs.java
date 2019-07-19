package com.music.utils.converters;

import com.music.TemplateFx.BandFx;
import com.music.TemplateFx.SongsFx;
import com.music.database.models.Band;
import com.music.database.models.Songs;

public class ConverterSongs {

    public static Songs convertToSongs(SongsFx songsFx){
        Songs songs = new Songs();
        songs.setId(songsFx.getId());
        songs.setName(songsFx.getName());
        songs.setTextt(songsFx.getTextt());
        return  songs;
    }

    public static SongsFx convertToSongsFx (Songs songs){
        SongsFx songsFx = new SongsFx();
        songsFx.setId(songs.getId());
        songsFx.setName(songs.getName());
        songsFx.setTextt(songs.getTextt());
        songsFx.setAlbumFx(ConverterAlbum.convertToAlbumFx(songs.getAlbum()));
        return songsFx;
    }

}
