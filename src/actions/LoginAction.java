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

public final class LoginAction extends Action {
    private final Credentials credentials;

    public LoginAction(final Credentials credentials) {
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
        ArrayList<User> regUsers = POOTVCore.getInstance().getRegUsers();
        boolean foundFlag = false;
        User foundUser = null;
        for (User user : regUsers) {
            if (user.getCredentials().getName().equals(this.credentials.getName())) {
                foundFlag = true;
                foundUser = user;
            }
        }
        if (!foundFlag) {
            POOTVCore.getInstance().setCurrentPage(HomepageUnauth.getInstance());
            Logger.getInstance().printError();
            return;
        }
        if (!foundUser.getCredentials().getPassword().equals(this.credentials.getPassword())) {
            POOTVCore.getInstance().setCurrentPage(HomepageUnauth.getInstance());
            Logger.getInstance().printError();
            return;
        }
        POOTVCore.getInstance().setCurrentUser(foundUser);
        POOTVCore.getInstance().setCurrentPage(HomepageAuth.getInstance());
        Logger.getInstance().loginPrint();
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
        Logger.getInstance().printError();
    }
}
