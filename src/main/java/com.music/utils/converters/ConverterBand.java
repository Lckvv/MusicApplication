package com.music.utils.converters;

import com.music.TemplateFx.BandFx;
import com.music.database.models.Band;

public class ConverterBand {

    public static Band convertToBand(BandFx bandFx){
        Band band = new Band();
        band.setId(bandFx.getId());
        band.setName(bandFx.getName());
        return  band;
    }

    public static BandFx convertToBandFx(Band band){
        BandFx bandFx = new BandFx();
        bandFx.setId(band.getId());
        bandFx.setName(band.getName());
        bandFx.setGenresFx(ConverterGenres.convertToGenresFx(band.getGenres()));
        return bandFx;
    }
}
