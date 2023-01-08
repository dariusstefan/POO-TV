package actions;

import entities.Credentials;
import entities.Logger;
import entities.POOTVCore;
import entities.User;
import pages.HomepageUnauth;
import pages.HomepageAuth;
import pages.LoginPage;
import pages.RegisterPage;
import pages.Movies;
import pages.Upgrades;
import pages.SeeDetails;

import java.util.ArrayList;

public final class RegisterAction extends Action {
    private final Credentials credentials;

    public RegisterAction(final Credentials credentials) {
        this.credentials = credentials;
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
        ArrayList<User> regUsers = POOTVCore.getInstance().getRegUsers();
        for (User user : regUsers) {
            if (user.getCredentials().getName().equals(this.credentials.getName())) {
                POOTVCore.getInstance().setCurrentPage(HomepageUnauth.getInstance());
                Logger.getInstance().printError();
                return;
            }
        }
        User newUser = new User(this.credentials);
        POOTVCore.getInstance().regUser(newUser);
        POOTVCore.getInstance().setCurrentUser(newUser);
        POOTVCore.getInstance().setCurrentPage(HomepageAuth.getInstance());
        Logger.getInstance().printLogin();
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
        Logger.getInstance().printError();
    }
}
