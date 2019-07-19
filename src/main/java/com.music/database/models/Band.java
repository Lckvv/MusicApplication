package com.music.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Band")
public class Band implements BaseModel{

    public static final String Genres_Id = "Genres_Id";

    public Band() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = Genres_Id, foreign = true, foreignAutoRefresh = true,foreignAutoCreate = true,canBeNull = false)
    private Genres genres;

    @DatabaseField(columnName = "Name", canBeNull = false)
    private String name;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Album> albums;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForeignCollection<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ForeignCollection<Album> albums) {
        this.albums = albums;
    }
}
