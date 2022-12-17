package Actions;

import Entities.Logger;
import Entities.POOTVCore;
import Pages.*;

public class BuyPremiumAccountAction extends Action {
    public BuyPremiumAccountAction() {
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
        int result = POOTVCore.getInstance().getCurrentUser().upgradeAccount();
        if (result != 0)
            Logger.getInstance().printError();
    }

    @Override
    public void execute(SeeDetails seeDetailsPage) {
        Logger.getInstance().printError();
    }
}
