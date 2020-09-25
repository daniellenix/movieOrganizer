package com.example.movieorganizer.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("prod/trial/lookup")
    Call<MovieManager> getMovie(@Query("upc") String id);
}