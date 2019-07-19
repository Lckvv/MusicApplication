package com.music.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Genres")
public class Genres implements BaseModel {
    public Genres() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "Name", canBeNull = false)
    private String name;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Band> bands;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForeignCollection<Band> getBands() {
        return bands;
    }

    public void setBands(ForeignCollection<Band> bands) {
        this.bands = bands;
    }
}
