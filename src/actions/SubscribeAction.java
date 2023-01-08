package actions;

import entities.Logger;
import entities.POOTVCore;
import pages.*;

public final class SubscribeAction extends Action {
    private String subscribedGenre;

    public SubscribeAction(final String subscribedGenre) {
        this.subscribedGenre = subscribedGenre;
    }

    @Override
    public void execute(HomepageUnauth homepageUnauth) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(HomepageAuth homepageAuth) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(LoginPage loginPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(RegisterPage registerPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(Movies moviesPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(Upgrades upgradesPage) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(SeeDetails seeDetailsPage) {
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
