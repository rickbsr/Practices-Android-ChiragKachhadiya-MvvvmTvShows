package com.rick.mvvmtvshows.listeners;

import com.rick.mvvmtvshows.model.TVShow;

public interface WatchlistListener {

    void onTVShowClicked(TVShow tvShow);

    void removeTVShowFromWatchlist(TVShow tvShow, int position);
}
