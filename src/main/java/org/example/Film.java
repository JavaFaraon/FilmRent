package org.example;

import java.time.LocalDate;

public class Film {

    int number;
    private final String name;
    private final LocalDate dateOfProduction;
    private FilmType type;

    public Film(int number, String name, LocalDate dateOfProduction, FilmType type) {
        this.number = number;
        this.name = name;
        this.dateOfProduction = dateOfProduction;
        this.type = type;
    }

    @Override
    public String toString() {
        return number + ". \'"
                + name +
                "\', год выпуска " + dateOfProduction +
                ", " + type;
    }

    public void setType(FilmType type) {
        this.type = type;
    }

    public FilmType getType() {
        return type;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }
}
