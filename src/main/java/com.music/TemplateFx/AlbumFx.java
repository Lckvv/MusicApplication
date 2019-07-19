package com.music.TemplateFx;

import javafx.beans.property.*;

public class AlbumFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<BandFx> bandFx = new SimpleObjectProperty<>();
    private StringProperty name = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public BandFx getBandFx() {
        return bandFx.get();
    }

    public ObjectProperty<BandFx> bandFxProperty() {
        return bandFx;
    }

    public void setBandFx(BandFx bandFx) {
        this.bandFx.set(bandFx);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return name.get();

    }
}
