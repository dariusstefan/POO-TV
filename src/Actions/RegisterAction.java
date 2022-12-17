package Actions;

import Entities.Credentials;
import Entities.Logger;
import Entities.POOTVCore;
import Entities.User;
import Pages.*;

import javax.swing.*;
import java.util.ArrayList;

public class RegisterAction extends Action {
    private Credentials credentials;

    public RegisterAction(Credentials credentials) {
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
        Logger.getInstance().printError();
    }

    @Override
    public void execute(RegisterPage registerPage) {
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
        HomepageAuth.getInstance().toLogger(Logger.getInstance());
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
