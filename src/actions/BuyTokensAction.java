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

public final class BuyTokensAction implements Action {
    private int count;

    public BuyTokensAction(final int count) {
        this.count = count;
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
        int result = POOTVCore.getInstance().getCurrentUser().buyTokens(count);
        if (result != 0) {
            Logger.getInstance().printError();
        }
    }

    @Override
    public void execute(final SeeDetails seeDetailsPage) {
        Logger.getInstance().printError();
    }
}
