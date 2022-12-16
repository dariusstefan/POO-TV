package Strategies;

import Entities.POOTVCore;

import java.util.ArrayList;

public class ActorsFilter implements FilterStrategy {
    private final ArrayList<String> actors;

    public ActorsFilter(ArrayList<String> actors) {
        this.actors = actors;
    }

    @Override
    public void filter() {
        if (actors == null)
            return;
        POOTVCore.getInstance().getCurrentMovies()
                .removeIf(movie -> (!movie.getActors().containsAll(actors)));
    }
}
