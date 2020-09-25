package com.example.movieorganizer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.movieorganizer.R;
import com.example.movieorganizer.model.ApiClient;
import com.example.movieorganizer.model.ApiInterface;
import com.example.movieorganizer.model.CustomAdapter;
import com.example.movieorganizer.model.Movie;
import com.example.movieorganizer.model.MovieManager;

import java.util.List;

public class Activity3 extends AppCompatActivity {

    private static final String EXTRA_VALUE = "com.example.movieorganizer.Activity3 - value";
    private String valueScanned;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    public static Intent makeIntent(Context context, String displayValue) {
        Intent intent = new Intent(context, Activity3.class);
        intent.putExtra(EXTRA_VALUE, displayValue);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        extractDataFromIntent();

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MovieManager> call = apiService.getMovie(valueScanned);

        call.enqueue(new Callback<MovieManager>() {
            @Override
            public void onResponse(Call<MovieManager> call, Response<MovieManager> response) {
                List<Movie> movies = response.body().getMovies();
            }

            @Override
            public void onFailure(Call<MovieManager> call, Throwable t) {
                Toast.makeText(Activity3.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void extractDataFromIntent() {
        Intent intent = getIntent();
        valueScanned = intent.getStringExtra(EXTRA_VALUE);
    }

//    private void generateDataList(Movie photoList) {
//        recyclerView = findViewById(R.id.recyclerView);
//        adapter = new CustomAdapter(photoList, Activity3.this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Activity3.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//    }
}