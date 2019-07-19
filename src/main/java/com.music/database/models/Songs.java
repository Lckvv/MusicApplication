package com.music.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Songs")
public class Songs implements BaseModel{

    public Songs() {
 }

    public static final String Album_Id = "Album_Id";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = Album_Id, foreign = true, foreignAutoRefresh = true,foreignAutoCreate = true,canBeNull = false)
    private Album album;

    @DatabaseField(columnName = "Name", canBeNull = false)
    private String name;

    @DatabaseField(columnName = "Textt", canBeNull = false, width = 5000)

    private String textt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextt() {
        return textt;
    }

    public void setTextt(String textt) {
        this.textt = textt;
    }
}
