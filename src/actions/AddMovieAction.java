package actions;

import entities.POOTVCore;
import entities.Logger;
import entities.User;
import entities.Movie;
import entities.Notification;
import input.MovieInput;
import pages.HomepageUnauth;
import pages.HomepageAuth;
import pages.RegisterPage;
import pages.LoginPage;
import pages.Movies;
import pages.SeeDetails;
import pages.Upgrades;

public final class AddMovieAction implements Action {
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
            if (addedMovie.getCountriesBanned().contains(user.getCredentials().getCountry())) {
                continue;
            }

            for (String genre : addedMovie.getGenres()) {
                if (user.getSubscriptions().contains(genre)) {
                    user.getNotifications().add(new Notification(addedMovie.getName(), "ADD"));
                    break;
                }
            }
        }
    }

    @Override
    public void execute(final HomepageUnauth homepageUnauth) {
        addMovie();
    }

    @Override
    public void execute(final HomepageAuth homepageAuth) {
        addMovie();
    }

    @Override
    public void execute(final LoginPage loginPage) {
        addMovie();
    }

    @Override
    public void execute(final RegisterPage registerPage) {
        addMovie();
    }

    @Override
    public void execute(final Movies moviesPage) {
        addMovie();
    }

    @Override
    public void execute(final Upgrades upgradesPage) {
        addMovie();
    }

    @Override
    public void execute(final SeeDetails seeDetailsPage) {
        addMovie();
    }
}
