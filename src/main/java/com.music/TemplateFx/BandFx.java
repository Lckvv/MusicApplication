package com.music.TemplateFx;

import javafx.beans.property.*;

public class BandFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<GenresFx> genresFx = new SimpleObjectProperty<>();
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

    public GenresFx getGenresFx() {
        return genresFx.get();
    }

    public ObjectProperty<GenresFx> genresFxProperty() {
        return genresFx;
    }

    public void setGenresFx(GenresFx genresFx) {
        this.genresFx.set(genresFx);
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
