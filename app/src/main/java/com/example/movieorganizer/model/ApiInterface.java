package com.example.movieorganizer.model;

import com.example.movieorganizer.model.MovieManager;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET()
    Call<MovieManager> getMovie();

    @GET("movie/{id}")
    Call<MovieManager> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}