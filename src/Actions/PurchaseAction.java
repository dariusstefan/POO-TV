package Actions;

import Entities.Logger;
import Entities.POOTVCore;
import Pages.*;

public class PurchaseAction extends Action {
    public PurchaseAction() {
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
        int result = POOTVCore.getInstance().getCurrentUser()
                .purchaseMovie(POOTVCore.getInstance().getCurrentMovie());
        if (result != 0) {
            Logger.getInstance().printError();
            return;
        }
        seeDetailsPage.toLogger(Logger.getInstance());
    }
}
