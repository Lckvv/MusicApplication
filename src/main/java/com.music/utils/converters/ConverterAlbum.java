package com.music.utils.converters;

import com.music.TemplateFx.AlbumFx;
import com.music.TemplateFx.BandFx;
import com.music.database.models.Album;
import com.music.database.models.Band;

public class ConverterAlbum {

    public static Album convertToAlbum(AlbumFx albumFx){
        Album album = new Album();
        album.setId(albumFx.getId());
        album.setName(albumFx.getName());
        return album;
    }

    public static AlbumFx convertToAlbumFx(Album album){
        AlbumFx albumFx = new AlbumFx();
        albumFx.setId(album.getId());
        albumFx.setName(album.getName());
        albumFx.setBandFx(ConverterBand.convertToBandFx(album.getBand()));
        return albumFx;
    }
}
