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
import strategies.FilterStrategy;

import java.util.ArrayList;

public final class FilterAction extends Action {
    private final ArrayList<FilterStrategy> strategies;

    public FilterAction(final ArrayList<FilterStrategy> strategies) {
        this.strategies = strategies;
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
        for (FilterStrategy strategy : strategies) {
            strategy.filter();
        }
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
