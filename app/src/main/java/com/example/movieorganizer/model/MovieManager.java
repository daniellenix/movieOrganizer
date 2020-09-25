package com.example.movieorganizer.model;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private static MovieManager instance;

    public static MovieManager getInstance() {
        if(instance == null) {
            instance = new MovieManager();
        }
        return instance;
    }

    private MovieManager() {}

    ArrayList<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovies() {
        return movieList;
    }

    public void add(Movie movie) {
        movieList.add(movie);
    }

    public void remove(Movie movie) {
        movieList.remove(movie);
    }
}
