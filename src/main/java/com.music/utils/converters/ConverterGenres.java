package com.music.utils.converters;

import com.music.TemplateFx.GenresFx;
import com.music.database.models.Genres;

public class ConverterGenres {

        public static Genres converToGenres(GenresFx genresFx){
            Genres genres = new Genres();
            genres.setId(genresFx.getId());
            genres.setName(genresFx.getName());
            return genres;
        }

        public static GenresFx convertToGenresFx(Genres genres){
            GenresFx genresFx = new GenresFx();
            genresFx.setId(genres.getId());
            genresFx.setName(genres.getName());
            return genresFx;
        }
    }
