package actions;

import entities.*;
import pages.*;

public final class DeleteMovieAction extends Action {
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
                if (user.getWatchedMovies().removeIf(movie -> movie.getName().equals(deletedMovie))) {
                    user.getLikedMovies().removeIf(movie -> movie.getName().equals(deletedMovie));
                    user.getRatedMovies().removeIf(movie -> movie.getName().equals(deletedMovie));
                }

                if (user.getCredentials().getAccountType().equals("premium"))
                    user.incNumFreePremiumMovies();
                else
                    user.incTokens(2);

                user.getNotifications().add(new Notification(deletedMovie, "DELETE"));
            }
        }
    }

    @Override
    public void execute(HomepageUnauth homepageUnauth) {
        deleteMovie();
    }

    @Override
    public void execute(HomepageAuth homepageAuth) {
        deleteMovie();
    }

    @Override
    public void execute(LoginPage loginPage) {
        deleteMovie();
    }

    @Override
    public void execute(RegisterPage registerPage) {
        deleteMovie();
    }

    @Override
    public void execute(Movies moviesPage) {
        deleteMovie();
    }

    @Override
    public void execute(Upgrades upgradesPage) {
        deleteMovie();
    }

    @Override
    public void execute(SeeDetails seeDetailsPage) {
        deleteMovie();
    }
}
