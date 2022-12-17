package Actions;

import Entities.Credentials;
import Entities.Logger;
import Entities.POOTVCore;
import Entities.User;
import Pages.*;

import java.util.ArrayList;

public class LoginAction extends Action {
    private Credentials credentials;

    public LoginAction(Credentials credentials) {
        this.credentials = credentials;
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
        HomepageAuth.getInstance().toLogger(Logger.getInstance());
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
        Logger.getInstance().printError();
    }
}
