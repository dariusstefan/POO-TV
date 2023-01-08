package actions;

import entities.*;
import input.MovieInput;
import pages.*;

public final class AddMovieAction extends Action {
    private final MovieInput addedMovie;

    public AddMovieAction(final MovieInput addedMovie) {
        this.addedMovie = addedMovie;
    }

    private void addMovie() {
        for (Movie movie : POOTVCore.getInstance().getMovies()) {
            if (movie.getName().equals(addedMovie.getName())) {
                Logger.getInstance().printError();
                return;
            }
        }

        POOTVCore.getInstance().getMovies().add(new Movie(addedMovie));

        for (User user : POOTVCore.getInstance().getRegUsers()) {
            if (addedMovie.getCountriesBanned().contains(user.getCredentials().getCountry()))
                continue;
            for (String genre : addedMovie.getGenres()) {
                if (user.getSubscriptions().contains(genre)) {
                    user.getNotifications().add(new Notification(addedMovie.getName(), "ADD"));
                    break;
                }
            }
        }
    }

    @Override
    public void execute(HomepageUnauth homepageUnauth) {
        addMovie();
    }

    @Override
    public void execute(HomepageAuth homepageAuth) {
        addMovie();
    }

    @Override
    public void execute(LoginPage loginPage) {
        addMovie();
    }

    @Override
    public void execute(RegisterPage registerPage) {
        addMovie();
    }

    @Override
    public void execute(Movies moviesPage) {
        addMovie();
    }

    @Override
    public void execute(Upgrades upgradesPage) {
        addMovie();
    }

    @Override
    public void execute(SeeDetails seeDetailsPage) {
        addMovie();
    }
}
