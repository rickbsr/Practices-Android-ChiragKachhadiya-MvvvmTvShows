package com.rick.mvvmtvshows.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rick.mvvmtvshows.repositories.TVShowDetailsRepository;
import com.rick.mvvmtvshows.responses.TVShowDetailsResponse;

public class TVShowDetailsViewModel extends ViewModel {

    private TVShowDetailsRepository tvShowDetailsRepository;

    public TVShowDetailsViewModel() {
        tvShowDetailsRepository = new TVShowDetailsRepository();
    }

    public LiveData<TVShowDetailsResponse> getTVShowDetails(String tvShowId) {
        return tvShowDetailsRepository.getTVShowDetails(tvShowId);
    }
}
