package com.music.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Album")
public class Album implements BaseModel{

    public static final String Band_Id = "Band_Id";

    public Album(){

    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = Band_Id, foreign = true, foreignAutoRefresh = true,foreignAutoCreate = true,canBeNull = false)
    private Band band;

    @DatabaseField(columnName = "Name", canBeNull = false)
    private String name;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Songs> songs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForeignCollection<Songs> getSongs() {
        return songs;
    }

    public void setSongs(ForeignCollection<Songs> songs) {
        this.songs = songs;
    }
}
