package Pages;

import Actions.Action;
import Entities.iLogger;

public class HomepageAuth extends Page {
    private static HomepageAuth instance = null;

    private HomepageAuth() {
    }

    public static HomepageAuth getInstance() {
        if (instance == null) {
            instance = new HomepageAuth();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
        this.addReachable(Movies.getInstance());
        this.addReachable(Upgrades.getInstance());
        this.addReachable(LogoutPage.getInstance());
    }

    @Override
    public void makeAction(Action action) {
        action.execute(this);
    }

    @Override
    public void toLogger(String error, iLogger logger) {
        logger.print(error, this);
    }


    @Override
    public String toString() {
        return "HomepageAuth{}";
    }
}
