package actions;

import entities.Logger;
import entities.POOTVCore;
import pages.HomepageUnauth;
import pages.HomepageAuth;
import pages.LoginPage;
import pages.RegisterPage;
import pages.Movies;
import pages.Upgrades;
import pages.SeeDetails;

public final class SearchAction implements Action {
    private final String startsWith;

    public SearchAction(final String startsWith) {
        this.startsWith = startsWith;
    }

    @Override
    public void execute(final HomepageUnauth homepageUnauth) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(final HomepageAuth homepageAuth) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(final LoginPage loginPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(final RegisterPage registerPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(final Movies moviesPage) {
        POOTVCore.getInstance().resetCurrentMovies();
        POOTVCore.getInstance().getCurrentMovies()
                .removeIf(movie -> (!movie.getName().startsWith(startsWith)));
        moviesPage.toLogger(Logger.getInstance());
    }

    @Override
    public void execute(final Upgrades upgradesPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(final SeeDetails seeDetailsPage) {
        Logger.getInstance().printError();
    }
}
