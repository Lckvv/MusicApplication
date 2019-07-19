package com.music.TemplateFx;

import javafx.beans.property.*;

public class SongsFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<AlbumFx> albumFx = new SimpleObjectProperty<>();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty textt = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public AlbumFx getAlbumFx() {
        return albumFx.get();
    }

    public ObjectProperty<AlbumFx> albumFxProperty() {
        return albumFx;
    }

    public void setAlbumFx(AlbumFx albumFx) {
        this.albumFx.set(albumFx);
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

    public String getTextt() {
        return textt.get();
    }

    public StringProperty texttProperty() {
        return textt;
    }

    public void setTextt(String textt) {
        this.textt.set(textt);
    }

    @Override
    public String toString() {
        return name.get() + textt.get();

    }
}
