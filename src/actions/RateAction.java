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

public final class RateAction extends Action {
    private final int rating;

    public RateAction(final int rating) {
        this.rating = rating;
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
        Logger.getInstance().printError();
    }

    @Override
    public void execute(final Upgrades upgradesPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(final SeeDetails seeDetailsPage) {
        int result = POOTVCore.getInstance().getCurrentUser()
                .rateMovie(POOTVCore.getInstance().getCurrentMovie(), this.rating);
        if (result != 0) {
            Logger.getInstance().printError();
            return;
        }
        seeDetailsPage.toLogger(Logger.getInstance());
    }
}
