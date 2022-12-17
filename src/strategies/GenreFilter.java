package strategies;

import entities.POOTVCore;

import java.util.ArrayList;

public final class GenreFilter implements FilterStrategy {
    private final ArrayList<String> genres;

    public GenreFilter(final ArrayList<String> genres) {
        this.genres = genres;
    }

    @Override
    public void filter() {
        if (genres == null) {
            return;
        }
        POOTVCore.getInstance().getCurrentMovies()
                .removeIf(movie -> (!movie.getGenres().containsAll(genres)));
    }
}
