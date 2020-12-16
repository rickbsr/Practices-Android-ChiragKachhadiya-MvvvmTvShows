package com.rick.mvvmtvshows.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rick.mvvmtvshows.R;
import com.rick.mvvmtvshows.databinding.ActivityTVShowDetailsBinding;
import com.rick.mvvmtvshows.viewmodels.TVShowDetailsViewModel;

public class TVShowDetailsActivity extends AppCompatActivity {

    private static final String TAG = TVShowDetailsActivity.class.getSimpleName();
    private ActivityTVShowDetailsBinding activityTVShowDetailsBinding;
    private TVShowDetailsViewModel tvShowDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_show_details);
        activityTVShowDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_t_v_show_details);
        doInitialization();
    }

    private void doInitialization() {
        tvShowDetailsViewModel = new ViewModelProvider(this).get(TVShowDetailsViewModel.class);
        getTVShowDetails();
    }

    private void getTVShowDetails() {
        activityTVShowDetailsBinding.setIsLoading(true);
        String tvShowId = String.valueOf(getIntent().getIntExtra("id", -1));
        Log.d(TAG, "getTVShowDetails: " + tvShowId);
        tvShowDetailsViewModel.getTVShowDetails(tvShowId).observe(this, tvShowDetailsResponse -> {
                    activityTVShowDetailsBinding.setIsLoading(false);
                    Toast.makeText(getApplicationContext(), tvShowDetailsResponse.getTvShowDetails().getUrl(), Toast.LENGTH_SHORT).show();
                }
        );
    }
}