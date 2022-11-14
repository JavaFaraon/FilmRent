package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.FilmType.*;

public class Main {
    public static void main(String[] args) {

        Film film1 = new Film(1,"Jurassic Park", LocalDate.of(1993,01,01), ОБЫЧНЫЙ);
        Film film2 = new Film(2,"Аватар 2: Путь воды", LocalDate.of(2022,8,01 ), ОБЫЧНЫЙ);
        Film film3 = new Film(3,"Базз Лайтер", LocalDate.of(2022,10,25), ДЕТСКИЙ);
        Film film4 = new Film(4,"Приключения электроника", LocalDate.of(1979,10,25), ДЕТСКИЙ);

        ArrayList<Film> filmArrayList = new ArrayList<>();
        filmArrayList.add(film1);
        filmArrayList.add(film2);
        filmArrayList.add(film3);
        filmArrayList.add(film4);

        for (Film film:filmArrayList) {
            LocalDate newPeriod = film.getDateOfProduction().plusMonths(3);// устанавливаем период новизны фильма 3 месяца
            if ( newPeriod.isAfter(LocalDate.now())) {
                film.setType(НОВЫЙ);
            }
        }

        System.out.println("Выберите номер фильма из списка:");
        for (Film film:filmArrayList) {
            System.out.println(film);
        }

        Film selectedFilm = selectFilm(getNumberOfFilm(),filmArrayList);

        System.out.println("Вы выбрали: " + selectedFilm + ".  Цена за день аренды: " + selectedFilm.getType().pricePerDay);

        System.out.println("Введите кол-во дней аренды:");
        int rentDays = getDays();
        System.out.println("Стоимость аренды за " + rentDays + " дней составляет: " + (rentDays * selectedFilm.getType().pricePerDay));
    }
    private static Film selectFilm(int numberOfFilm, ArrayList<Film> filmArrayList) {
        return filmArrayList.get(numberOfFilm-1);
    }
    public static int getNumberOfFilm() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int i = scan.nextInt();
            if (i>0 & i<5) {
                return i;
            }
            else {
                System.out.println("Неверный ввод, номер должен быть от 1 до 4:");
                return getNumberOfFilm();
            }
        }
        else {
            System.out.println("Неверный ввод, повторите:");
            return getNumberOfFilm();
        }
    }
    public static Integer getDays() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            return scan.nextInt();
        }
        else {
            System.out.println("Неверный ввод, введите число:");
            return getDays();
        }
    }

}