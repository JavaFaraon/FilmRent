package org.example;

public enum FilmType {
    НОВЫЙ(3),
    ДЕТСКИЙ(1),
    ОБЫЧНЫЙ(2);

    int pricePerDay;

    FilmType(int pricePerDay) {
        this.pricePerDay = pricePerDay;

    }
}
