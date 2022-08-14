package com.rick.mvvmtvshows.responses;

import com.google.gson.annotations.SerializedName;
import com.rick.mvvmtvshows.model.TVShowDetails;

public class TVShowDetailsResponse {

    @SerializedName("tvShow")
    private TVShowDetails tvShowDetails;

    public TVShowDetails getTvShowDetails() {
        return tvShowDetails;
    }
}
