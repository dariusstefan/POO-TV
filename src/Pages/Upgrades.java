package Pages;

import Actions.Action;
import Entities.iLogger;

public class Upgrades extends Page {
    private static Upgrades instance = null;

    private Upgrades() {
    }

    public static Upgrades getInstance() {
        if (instance == null) {
            instance = new Upgrades();
        }
        return instance;
    }

    @Override
    public void completeReachable() {
        this.addReachable(HomepageAuth.getInstance());
        this.addReachable(Movies.getInstance());
        this.addReachable(LogoutPage.getInstance());
    }

    @Override
    public void makeAction(Action action) {
        action.execute(this);
    }

    @Override
    public void toLogger(iLogger logger) {
        logger.print(this);
    }

    @Override
    public void auto() {

    }

    @Override
    public String toString() {
        return "Upgrades{}";
    }
}
