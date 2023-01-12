package actions;

import entities.Logger;
import entities.POOTVCore;
import pages.HomepageUnauth;
import pages.HomepageAuth;
import pages.RegisterPage;
import pages.LoginPage;
import pages.Movies;
import pages.SeeDetails;
import pages.Upgrades;

public final class SubscribeAction implements Action {
    private final String subscribedGenre;

    public SubscribeAction(final String subscribedGenre) {
        this.subscribedGenre = subscribedGenre;
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
        if (!POOTVCore.getInstance().getCurrentMovie().getGenres().contains(subscribedGenre)) {
            Logger.getInstance().printError();
            return;
        }

        if (POOTVCore.getInstance().getCurrentUser().getSubscriptions().contains(subscribedGenre)) {
            Logger.getInstance().printError();
            return;
        }

        POOTVCore.getInstance().getCurrentUser().getSubscriptions().add(subscribedGenre);
    }
}
