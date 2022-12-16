package Strategies;

import Entities.POOTVCore;

import java.util.ArrayList;

public class GenreFilter implements FilterStrategy {
    private final ArrayList<String> genres;

    public GenreFilter(ArrayList<String> genres) {
        this.genres = genres;
    }

    @Override
    public void filter() {
        if (genres == null)
            return;
        POOTVCore.getInstance().getCurrentMovies()
                .removeIf(movie -> (!movie.getGenres().containsAll(genres)));
    }
}
