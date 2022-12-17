package strategies;

import entities.POOTVCore;

import java.util.ArrayList;

public final class ActorsFilter implements FilterStrategy {
    private final ArrayList<String> actors;

    public ActorsFilter(final ArrayList<String> actors) {
        this.actors = actors;
    }

    @Override
    public void filter() {
        if (actors == null) {
            return;
        }
        POOTVCore.getInstance().getCurrentMovies()
                .removeIf(movie -> (!movie.getActors().containsAll(actors)));
    }
}
