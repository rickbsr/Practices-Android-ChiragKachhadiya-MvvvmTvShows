package com.rick.mvvmtvshows.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.rick.mvvmtvshows.R;
import com.rick.mvvmtvshows.adapters.TVShowsAdapter;
import com.rick.mvvmtvshows.databinding.ActivityMainBinding;
import com.rick.mvvmtvshows.model.TVShow;
import com.rick.mvvmtvshows.viewmodels.MostPopularTVShowsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MostPopularTVShowsViewModel viewModel;
    private List<TVShow> tvShows = new ArrayList<>();
    private TVShowsAdapter tvShowsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doInitialization();
    }

    private void doInitialization() {
        activityMainBinding.tvShowsRecyclerView.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(MostPopularTVShowsViewModel.class);
        tvShowsAdapter = new TVShowsAdapter(tvShows);
        activityMainBinding.tvShowsRecyclerView.setAdapter(tvShowsAdapter);
        getMostPopularTVShows();
    }

    private void getMostPopularTVShows() {
        activityMainBinding.setIsLoading(true);
        viewModel.getMostPopularTVShows(0).observe(this, mostPopularTVShowsResponse -> {
                    activityMainBinding.setIsLoading(false);
                    if (mostPopularTVShowsResponse != null) {
                        tvShows.addAll(mostPopularTVShowsResponse.getTvShows());
                        tvShowsAdapter.notifyDataSetChanged();
                    }
                }
        );
    }
}