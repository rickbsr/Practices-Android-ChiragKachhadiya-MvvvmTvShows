package com.rick.mvvmtvshows.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rick.mvvmtvshows.model.TVShow;
import com.rick.mvvmtvshows.model.TVShowDetails;
import com.rick.mvvmtvshows.network.ApiClient;
import com.rick.mvvmtvshows.network.ApiService;
import com.rick.mvvmtvshows.responses.TVShowDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVShowDetailsRepository {
    private static final String TAG = TVShowDetailsRepository.class.getSimpleName();
    private final ApiService apiService;

    public TVShowDetailsRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<TVShowDetailsResponse> getTVShowDetails(String tvShowId) {
        MutableLiveData<TVShowDetailsResponse> data = new MutableLiveData<>();
        apiService.getTVShowDetails(tvShowId).enqueue(new Callback<TVShowDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<TVShowDetailsResponse> call, @NonNull Response<TVShowDetailsResponse> response) {
                Log.d(TAG, "onResponse: ");
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TVShowDetailsResponse> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
