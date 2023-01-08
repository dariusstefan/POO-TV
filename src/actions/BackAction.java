package actions;

import entities.Logger;
import entities.POOTVCore;
import entities.State;
import pages.*;

public final class BackAction extends Action {
    public BackAction() {
    }

    private void back() {
        if (POOTVCore.getInstance().getPagesHistory().isEmpty()) {
            Logger.getInstance().printError();
            return;
        }

        State lastState = POOTVCore.getInstance().getPagesHistory()
                .remove(POOTVCore.getInstance().getPagesHistory().size() - 1);

        if (lastState.getCurrentMovie() != null)
            POOTVCore.getInstance().setCurrentMovie(lastState.getCurrentMovie().getName());

        POOTVCore.getInstance().setCurrentPage(lastState.getCurrentPage());
        lastState.getCurrentPage().toLogger(Logger.getInstance());
    }

    @Override
    public void execute(final HomepageUnauth homepageUnauth) {
        Logger.getInstance().printError();
    }

    @Override
    public void execute(final HomepageAuth homepageAuth) {
        back();
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
        back();
    }

    @Override
    public void execute(final Upgrades upgradesPage) {
        back();
    }

    @Override
    public void execute(final SeeDetails seeDetailsPage) {
        back();
    }
}
