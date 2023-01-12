package actions;

import entities.POOTVCore;
import entities.Logger;
import entities.User;
import entities.Notification;
import pages.HomepageUnauth;
import pages.HomepageAuth;
import pages.RegisterPage;
import pages.LoginPage;
import pages.Movies;
import pages.SeeDetails;
import pages.Upgrades;

public final class DeleteMovieAction implements Action {
    private final String deletedMovie;

    public DeleteMovieAction(final String deletedMovie) {
        this.deletedMovie = deletedMovie;
    }

    private void deleteMovie() {
        boolean flag = POOTVCore.getInstance().getMovies()
                .removeIf(movie -> movie.getName().equals(deletedMovie));

        if (!flag) {
            Logger.getInstance().printError();
            return;
        }

        for (User user : POOTVCore.getInstance().getRegUsers()) {
            if (user.getPurchasedMovies().removeIf(movie -> movie.getName().equals(deletedMovie))) {
                if (user.getWatchedMovies()
                        .removeIf(movie -> movie.getName().equals(deletedMovie))) {
                    user.getLikedMovies().removeIf(movie -> movie.getName().equals(deletedMovie));
                    user.getRatedMovies().removeIf(movie -> movie.getName().equals(deletedMovie));
                }

                if (user.getCredentials().getAccountType().equals("premium")) {
                    user.incNumFreePremiumMovies();
                } else {
                    user.incTokens(2);
                }

                user.getNotifications().add(new Notification(deletedMovie, "DELETE"));
            }
        }
    }

    @Override
    public void execute(final HomepageUnauth homepageUnauth) {
        deleteMovie();
    }

    @Override
    public void execute(final HomepageAuth homepageAuth) {
        deleteMovie();
    }

    @Override
    public void execute(final LoginPage loginPage) {
        deleteMovie();
    }

    @Override
    public void execute(final RegisterPage registerPage) {
        deleteMovie();
    }

    @Override
    public void execute(final Movies moviesPage) {
        deleteMovie();
    }

    @Override
    public void execute(final Upgrades upgradesPage) {
        deleteMovie();
    }

    @Override
    public void execute(final SeeDetails seeDetailsPage) {
        deleteMovie();
    }
}
