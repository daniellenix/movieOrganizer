package com.example.movieorganizer.model;

import java.util.List;

public class Movie {
    private String title;
    private int year;
    private double rating;
    private String director;
    // add image string url

    public Movie(String title, int year, double rating, String director) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", director='" + director + '\'' +
                '}';
    }
}
