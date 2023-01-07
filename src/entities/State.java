package entities;

import pages.Page;

public final class State {
    private final Page currentPage;
    private final Movie currentMovie;

    public State(final Page currentPage, final Movie currentMovie) {
        this.currentPage = currentPage;
        this.currentMovie = currentMovie;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }
}
